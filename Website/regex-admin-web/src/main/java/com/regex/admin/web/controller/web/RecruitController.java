package com.regex.admin.web.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.RecruitDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IRecruitService;

@Controller
@RequestMapping("recruit")
public class RecruitController {
	
	@Autowired
	private IRecruitService recruitService;
	
	@RequestMapping("show")
	public String show(Model model) {
		Assist assist = new Assist();
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
		List<RecruitDTO> recruitList = recruitService.selectRecruitDTO(assist);
		model.addAttribute("recruitList", recruitList);
		return "web/per-zp";
	}

}
