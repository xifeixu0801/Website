package com.regex.admin.web.controller.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.AboutUsDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IAboutUsService;

@Controller
@RequestMapping("aboutUs")
public class AboutUsController {
	
	@Autowired
	private IAboutUsService aboutUsService;
	
	@RequestMapping("detial_{id}")
	public String detial(@PathVariable("id") String id, Model model) {
		if(StringUtils.isEmpty(id)) {
			id="1";
		}
		AboutUsDTO aboutUsDTO = aboutUsService.selectAboutUsDTOById(Long.parseLong(id));
		model.addAttribute("aboutUsDTO", aboutUsDTO);
		
		Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
		assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
		List<AboutUsDTO> aboutUsList = aboutUsService.selectAboutUsDTO(assist);
		model.addAttribute("aboutUsList", aboutUsList);
		return "web/about";
	}

}
