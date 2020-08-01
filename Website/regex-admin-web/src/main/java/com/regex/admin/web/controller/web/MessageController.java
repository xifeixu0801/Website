package com.regex.admin.web.controller.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.MessageDTO;
import com.regex.admin.service.web.IMessageService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;
import com.regex.admin.web.controller.utils.HttpUtil;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping("save")
	public void save(MessageDTO messageDTO, HttpServletResponse response, HttpServletRequest request) {
		String ip = HttpUtil.getClientIP(request);
		messageDTO.setIp(ip);
		int n = 0;
		if(StringUtils.isNotEmpty(messageDTO.getContent())) {
			messageDTO.setIsDel("0");
			messageDTO.setUpdateTime(new Date());
			messageDTO.setCreateTime(new Date());
			n = messageService.insertMessageDTO(messageDTO);
		} else {
			n = 1;
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}

}
