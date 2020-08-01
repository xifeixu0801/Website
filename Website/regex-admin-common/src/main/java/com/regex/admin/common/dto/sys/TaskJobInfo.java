package com.regex.admin.common.dto.sys;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 定时任务
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@TableName("sys_task_job_info")
@KeySequence
public class TaskJobInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8987341793970005844L;

	@TableId(value = "id", type=IdType.ID_WORKER)
	private Long id;
	/**
	 * 0 正常 1 删除
	 */
	private String isDel;
	
	private Date createTime;

	private Date updateTime;
	/**
	 * 任务名称
	 */
	private String name;
	/**
	 * 任务状态1待执行  0 已执行
	 */
	private int state;
	/**
	 *  执行时间表达式
	 */
	private String cronExpression;
	/**
	 * 通知的邮件地址多个,分割
	 */
	private String sendNotificaMails;
	/**
	 * 通知的手机多个,分割
	 */
	private String sendNotificaTels;
	/**
	 * 执行的任务类
	 */
	private String classes;
	/**
	 * 执行的任务的参数集合 json格式
	 */
	private String parameter;
	/**
	 * 描述
	 */
	private String discription;

	public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getSendNotificaMails() {
		return sendNotificaMails;
	}

	public void setSendNotificaMails(String sendNotificaMails) {
		this.sendNotificaMails = sendNotificaMails;
	}

	public String getSendNotificaTels() {
		return sendNotificaTels;
	}

	public void setSendNotificaTels(String sendNotificaTels) {
		this.sendNotificaTels = sendNotificaTels;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
