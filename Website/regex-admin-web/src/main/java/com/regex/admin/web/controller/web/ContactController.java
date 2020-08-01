package com.regex.admin.web.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.service.web.IWebInfoService;

@Controller
@RequestMapping("")
public class ContactController {
	
	@Autowired
    protected IWebInfoService webInfoService;
	
	@RequestMapping("contact")
	public String contact(Model model) {
		WebInfoDTO webInfoDTO = webInfoService.selectWebInfoDTOById(1l);
		model.addAttribute("webInfoDTO", webInfoDTO);
		return "web/contact";
	}
	
	@RequestMapping("map")
	public String map(Model model) {
		WebInfoDTO webInfoDTO = webInfoService.selectWebInfoDTOById(1l);
		model.addAttribute("webInfoDTO", webInfoDTO);
		return "web/map/map";
	}

}
