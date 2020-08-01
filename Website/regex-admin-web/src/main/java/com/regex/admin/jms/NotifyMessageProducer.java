package com.regex.admin.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

/**
 * JMS用户变更消息生产者.
 * 使用jmsTemplate将用户变更消息分别发送到queue与topic.
 * @author ocean
 *
 */
public class NotifyMessageProducer {

	private JmsTemplate jmsTemplate;
	
	private Destination notifyQueue;
	
	private Destination notifyQuarz;
	
	private Destination notifyTopic;

	public void sendQueue(final String json) {
		sendMessage(json, notifyQueue);
	}
	
	//计划任务队列
	public void sendQuarz(final String json) {
		sendMessage(json, notifyQuarz);
	}

	public void sendTopic(final String json) {
		sendMessage(json, notifyTopic);
	}

	/**
	 * 使用jmsTemplate最简便的封装convertAndSend()发送Map类型的消息.
	 */
	private void sendMessage(String json, Destination destination) {
		jmsTemplate.convertAndSend(destination, json);
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setNotifyQueue(Destination notifyQueue) {
		this.notifyQueue = notifyQueue;
	}

	public void setNotifyTopic(Destination nodifyTopic) {
		this.notifyTopic = nodifyTopic;
	}

	public void setNotifyQuarz(Destination notifyQuarz) {
		this.notifyQuarz = notifyQuarz;
	}
}