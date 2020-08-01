package com.regex.admin.web.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
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


@Component
@Transactional
public class RegexQuartzService {
	
	private static Logger logger = LoggerFactory.getLogger(RegexQuartzService.class);
	
	@Autowired
	private SchedulerFactoryBean clusterQuartzScheduler;
	
	/**
	 * 恢复任务
	 */
	public boolean resume(JobKey jobKey) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			scheduler.resumeJob(jobKey);
		} catch (Exception e) {
			logger.error("resume exception!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 暂停任务
	 */
	public boolean pause(JobKey jobKey) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			scheduler.pauseJob(jobKey);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除任务
	 */
	public boolean delete(JobKey jobKey) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			scheduler.deleteJob(jobKey);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 添加任务
	 */
	public boolean add(TaskJobInfo task) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			try {
				Class _class = Class.forName(task.getClasses());
				JobDetail jobDetail = JobBuilder.newJob(_class)
						.withIdentity("task_" + task.getId(), "group_" + task.getId()).build();
				jobDetail.getJobDataMap().put(String.valueOf(task.getId()), task);
				// 表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task
						.getCronExpression());
				// 按新的表达式构建一个新的trigger
				CronTrigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("task_" + task.getId(), "group_" + task.getId())
						.withSchedule(scheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, trigger);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 立即运行任务
	 */
	public boolean trigger(JobKey jobKey) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			scheduler.triggerJob(jobKey);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新任务（时间表达式）
	 */
	public boolean reschedule(TriggerKey triggerKey, String cronExpression) {
		try {
			Scheduler scheduler = clusterQuartzScheduler.getScheduler();
			// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
					.withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

//	public Pagination<TaskJobInfo> taskJobList(Map<String, Object> searchParams,
//			RequestPageInfo page) {
//		Query query = new Query();
//		Map<String, Object> params = washParams(searchParams);
//		if(params.containsKey("id")){
//			if(StringUtils.isNotBlank(params.get("id").toString())){
//				searchParams.put("EQ_id", Long.valueOf(params.get("id").toString()));
//			}
//		}
//		if(params.containsKey("state")){
//			if(StringUtils.isNotBlank(params.get("state").toString())){
//				searchParams.put("EQ_state", Long.valueOf(params.get("state").toString()));
//			}
//		}
//		Query _query = mapToMongoQuery(query, searchParams);
//		long totalCount = mongoTemplate.count(_query, TaskJobInfo.class);
//		Pagination<TaskJobInfo> pagination = new Pagination<TaskJobInfo>(page.getPageNo(),
//				page.getPageSize(), totalCount);
//		_query.skip(pagination.getFirstResult());
//		_query.limit(pagination.getPageSize());
//		if (totalCount > 0) {
//			List<TaskJobInfo> dataList = getAllClassOrder(_query, page, TaskJobInfo.class);
//			pagination.setDatas(dataList);
//		}
//		return pagination;
//	}
}
