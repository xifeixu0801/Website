package com.regex.admin.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.web.MessageDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IMessageService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 留言管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/message")
public class SysMessageController {

	@Autowired
	private IMessageService messageService;
	
	/**
	 * 留言查询列表
	 * @param model
	 * @param current
	 * @return
	 */
	@RequestMapping("show")
	public String show(Model model, String current) {
		Assist assist = new Assist();
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        assist.setRowSize(Contant.NONMAL_PAGE_SIZE);
        if(StringUtils.isEmpty(current)) {
        	current = "0";
        }
        assist.setStartRow(Integer.parseInt(current));
		List<MessageDTO> productList = messageService.selectMessageDTO(assist);
		long total = messageService.getMessageDTORowCount(assist);
        Page<MessageDTO> result = new Page<MessageDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/message/show";
	}
	
	/**
	 * 查看留言
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			MessageDTO messageDTO = messageService.selectMessageDTOById(Long.parseLong(id));
			model.addAttribute("messageDTO", messageDTO);
		}
		return "admin/message/input";
	}
	
	/**
	 * 删除留言
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		MessageDTO MessageDTO = messageService.selectMessageDTOById(id);
		int n = 1;
		if(MessageDTO != null) {
			MessageDTO.setIsDel("1");
			n = messageService.updateMessageDTOById(MessageDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}




}
