package com.regex.admin.web.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.regex.admin.common.dto.sys.TaskJobInfo;
import com.regex.admin.service.sys.ITaskJobInfoService;

public class TestJob implements Job {
    
    @Autowired
    private ITaskJobInfoService taskJobInfoService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(TestJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		TaskJobInfo task = null;
		try {
			JobDetail jobDetail = context.getJobDetail();
			String jobName = jobDetail.getKey().getName();
			LOGGER.error("当前执行的任务：" + jobName + "\n");
			// 取参数
			JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
			String taskId = jobDetail.getKey().getName().replace("task_", "");
			Object data = jobDataMap.get(taskId);
			if(null != data) {
				task = (TaskJobInfo)data;
				LOGGER.error("The job'name is : " +  task.getName());
				taskJobInfoService.updateState(taskId);
			}
		} catch (Exception e) {
			LOGGER.error("This is Job is running Exception!");
			e.printStackTrace();
		}
		LOGGER.error("This is my first Job running is end！");
	}

}
