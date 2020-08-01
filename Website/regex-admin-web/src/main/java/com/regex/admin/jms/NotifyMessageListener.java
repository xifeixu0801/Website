package com.regex.admin.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.regex.admin.common.dto.jms.MQDatas;
import com.regex.admin.service.MessageService;

/**
 * 消息的异步被动接收者.
 * 
 * 使用Spring的MessageListenerContainer侦听消息并调用本Listener进行处理.
 * 
 * @author peter.zhuang
 */
public class NotifyMessageListener implements MessageListener {
	
	private static Logger logger = LoggerFactory.getLogger(NotifyMessageListener.class);
	
	@Autowired
	private MessageService messageService;

	public void onMessage(Message message) {
		TextMessage messageText = (TextMessage) message;
//		ObjectMessage obj = (ObjectMessage)message;
			try {
				String mqStr = messageText.getText();
				MQDatas data = JSON.parseObject(mqStr, MQDatas.class);
				logger.error("" + data.getId());
				int result = messageService.sendMessage(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("1111111111111111111111");
			}
	}

//	@Autowired
//	protected MongoTemplate mongoTemplate;

//	@Autowired
//	private MessageService messageService;

//	@Override
//	public void onMessage(Message message) {
//		ObjectMessage obj = (ObjectMessage) message;
//		try {
//			MQDatas data = (MQDatas) obj.getObject();
//			if (null == data) {
//				return;
//			}
//			String source = data.getSource();
//			if (StringUtils.isBlank(source) || source.equals(MsgRoute.MQ_DATA_CONSTANT_SOURCE_PLAT)) {// plat
//				int result = messageService.sendPlat(data);
//				logger.info("plat:" + result);
//			} else if (source.equals(MsgRoute.MQ_DATA_CONSTANT_SOURCE_PUSH)) {// push
//				int result = messageService.sendPush(data);
//				logger.info("push:" + result);
//			} else if (source.equals(MsgRoute.MQ_DATA_CONSTANT_SOURCE_CRM)) {// crm
//				int result = messageService.sendPush(data);
//				logger.info("crm:" + result);
//			} else if (source.equals(MsgRoute.MQ_DATA_CONSTANT_SOURCE_JOB)) {// job
//				int result = messageService.sendQuarz(data);
//				logger.info("crm:" + result);
//			} else if (source.equals(MsgRoute.MQ_DATA_CONSTANT_SOURCE_WX)) {// wx
//				int result = messageService.sendWP(data);
//				logger.info("crm:" + result);
//			}
//			if (data.getStatus().equals("0")) {
//				Query query = new Query();
//				query.addCriteria(Criteria.where("id").is(data.getId()));
//				Update update = new Update();
//				update.set("status", "1");
//				update.set("updateTime", System.currentTimeMillis());
//				mongoTemplate.updateFirst(query, update, MQDatas.class);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
