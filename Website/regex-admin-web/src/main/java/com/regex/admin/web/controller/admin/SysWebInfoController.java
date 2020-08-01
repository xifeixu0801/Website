package com.regex.admin.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.service.web.IWebInfoService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 网站设置
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/webinfo")
public class SysWebInfoController {
	
	@Autowired
	private IWebInfoService webInfoService;
	
	/**
	 * 网站设置修改
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(Model model) {
		WebInfoDTO webInfoDTO = webInfoService.selectWebInfoDTOById(1l);
		model.addAttribute("webInfoDTO", webInfoDTO);
		return "admin/web/input";
	}
	
	/**
	 * 网站设置保存
	 * @param webInfoDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save(WebInfoDTO webInfoDTO, HttpServletResponse response, HttpServletRequest request) {
		int n = 0;
		WebInfoDTO webInfoDTOOld = webInfoService.selectWebInfoDTOById(1l);
		webInfoDTOOld.setDescription(webInfoDTO.getDescription());
		webInfoDTOOld.setFooter(webInfoDTO.getFooter());
		webInfoDTOOld.setHeader(webInfoDTO.getHeader());
		webInfoDTOOld.setKeywords(webInfoDTO.getKeywords());
		webInfoDTOOld.setTel(webInfoDTO.getTel());
		webInfoDTOOld.setTitle(webInfoDTO.getTitle());
		webInfoDTOOld.setWxPic(webInfoDTO.getWxPic());
		webInfoDTOOld.setEmail(webInfoDTO.getEmail());
		webInfoDTOOld.setAddress(webInfoDTO.getAddress());
		webInfoDTOOld.setLx(webInfoDTO.getLx());
		webInfoDTOOld.setLy(webInfoDTO.getLy());
		n = webInfoService.updateWebInfoDTOById(webInfoDTOOld);
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}

}
