package com.regex.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.regex.admin.common.dto.jms.MQDatas;

@Component
@Transactional
public class MessageService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
	
	public int send(MQDatas data) {
		LOGGER.error(data.getData());
		return 1;
	}
	
	public int sendMessage(MQDatas data) throws Exception {
		LOGGER.error("\n\n\n\n========来自TEST的消息【BEGIN】========");
		return send(data);
	}

}
