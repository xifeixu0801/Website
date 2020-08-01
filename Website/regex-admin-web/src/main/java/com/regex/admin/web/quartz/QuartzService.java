package com.regex.admin.web.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.regex.admin.common.dto.sys.TaskJobInfo;
import com.regex.admin.service.sys.ITaskJobInfoService;

@Component
@Transactional
public class QuartzService  {

	private static Logger logger = LoggerFactory.getLogger(QuartzService.class);

	@Autowired
	private SchedulerFactoryBean clusterQuartzScheduler;
	
	@Autowired
	private ITaskJobInfoService taskJobInfoService;
	
	public void welcome() {
		StringBuffer buff = new StringBuffer();
		buff.append("********************* QUARTZ IS START *******************\n");
		logger.error(buff.toString());
	}

	public void initTask() {
		welcome();
		try {
			logger.info("准备加载任务列表");
//			Query query = new Query();
//			query.addCriteria(Criteria.where("state").is(1));
//			query.with(new Sort(Sort.Direction.DESC, "id"));
			List<TaskJobInfo> _taskList = taskJobInfoService.getAll(); //mongoTemplate.find(query, TaskJobInfo.class);
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			scheduler.clear();
			for (TaskJobInfo task : _taskList) {
				logger.info("加载任务列表：" + task.getName() + " " + task.getId());
				// 任务名称和任务组设置规则 名称：task_1 .. 组 ：group_1 ..
				TriggerKey triggerKey = TriggerKey.triggerKey("task_" + task.getId(), "group_"
						+ task.getId());
				CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
//				String clzz = ""; //MsgRoute.QUARZ_JOB_CLAZZ;
//				String rlzz = "";//MsgRoute.QUARZ_JOB_RELATION_CLAZZ;
//				if (task.getClasses().equals(clzz) || task.getClasses().equals(rlzz)) {
//					// 检查为执行任务，存在则推迟执行
//					String cronDate = DateFormat.formatDateByPattern(task.getCronExpression());
//					String nowDate = DateFormat.getDate(new Date());
//					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					long cromTime = dateformat.parse(cronDate).getTime();
//					long nowTime = dateformat.parse(nowDate).getTime();
//					if (nowTime >= cromTime) {
//						// 往后延时1分钟执行
//						long cntime = nowTime + (60 * 1000);
//						String cronExpression = DateFormat.getCron(new Date(cntime));
//						task.setCronExpression(cronExpression);
//					}
//				}
				// 不存在，创建一个
				if (null == trigger) {
					Class _class = Class.forName(task.getClasses());
					JobDetail jobDetail = JobBuilder.newJob(_class)
							.withIdentity("task_" + task.getId(), "group_" + task.getId()).build();
					jobDetail.getJobDataMap().put(String.valueOf(task.getId()), task);
					try {
						// 表达式调度构建器
						CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task
								.getCronExpression());
						// 按新的表达式构建一个新的trigger
						trigger = TriggerBuilder.newTrigger()
								.withIdentity("task_" + task.getId(), "group_" + task.getId())
								.withSchedule(scheduleBuilder).build();
						scheduler.scheduleJob(jobDetail, trigger);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						// trigger已存在，则更新相应的定时设置
						CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task
								.getCronExpression());
						// 按新的cronExpression表达式重新构建trigger
						trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
								.withSchedule(scheduleBuilder).build();
						// 按新的trigger重新设置job执行
						scheduler.rescheduleJob(triggerKey, trigger);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			logger.info("加载任务列表结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
