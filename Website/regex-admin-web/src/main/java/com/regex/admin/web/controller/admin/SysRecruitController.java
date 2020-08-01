package com.regex.admin.web.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.web.RecruitDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IRecruitService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 人才招聘
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/recruit")
public class SysRecruitController {
	
	@Autowired
	private IRecruitService recruitService;
	/**
	 * 人才招聘列表
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
		List<RecruitDTO> productList = recruitService.selectRecruitDTO(assist);
		long total = recruitService.getRecruitDTORowCount(assist);
        Page<RecruitDTO> result = new Page<RecruitDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/recruit/show";
	}
	
	/**
	 * 人才招聘新增/修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			RecruitDTO recruitDTO = recruitService.selectRecruitDTOById(Long.parseLong(id));
			model.addAttribute("recruitDTO", recruitDTO);
		}
		return "admin/recruit/input";
	}
	
	/**
	 * 人才招聘保存
	 * @param RecruitDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (RecruitDTO RecruitDTO, HttpServletResponse response) {
		int n = 0;
		if(StringUtils.isNotEmpty(RecruitDTO.getJobName()) && StringUtils.isNotEmpty(RecruitDTO.getJobAddress())
				&& StringUtils.isNotEmpty(RecruitDTO.getJobDemand())) {
			RecruitDTO.setUpdateTime(new Date());
			if(RecruitDTO.getId() > 0) {
				n = recruitService.updateNonEmptyRecruitDTOById(RecruitDTO);
			} else {
				RecruitDTO.setCreateTime(new Date());
				RecruitDTO.setIsDel("0");
				n = recruitService.insertRecruitDTO(RecruitDTO);
			}
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 人才招聘删除
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		RecruitDTO RecruitDTO = recruitService.selectRecruitDTOById(id);
		int n = 1;
		if(RecruitDTO != null) {
			RecruitDTO.setIsDel("1");
			n = recruitService.updateRecruitDTOById(RecruitDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}



}
