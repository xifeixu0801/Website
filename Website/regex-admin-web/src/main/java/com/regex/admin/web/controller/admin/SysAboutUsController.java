package com.regex.admin.web.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.web.AboutUsDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IAboutUsService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;
/**
 * 关于我们
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/aboutUs")
public class SysAboutUsController {
	
	@Autowired
	private IAboutUsService aboutUsService;
	
	/**
	 * 关于我们列表查询
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
		List<AboutUsDTO> productList = aboutUsService.selectAboutUsDTO(assist);
		long total = aboutUsService.getAboutUsDTORowCount(assist);
        Page<AboutUsDTO> result = new Page<AboutUsDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/aboutUs/show";
	}
	
	/**
	 * 关于我们修改/新增
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			AboutUsDTO aboutUsDTO = aboutUsService.selectAboutUsDTOById(Long.parseLong(id));
			model.addAttribute("aboutUsDTO", aboutUsDTO);
		}
		return "admin/aboutUs/input";
	}
	
	/**
	 * 保存
	 * @param AboutUsDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (AboutUsDTO AboutUsDTO, HttpServletResponse response, HttpServletRequest request) {
		int n = 0;
		try {
		if(StringUtils.isNotEmpty(AboutUsDTO.getName())) {
			AboutUsDTO.setUpdateTime(new Date());
			if(AboutUsDTO.getId() > 0) {
				n = aboutUsService.updateNonEmptyAboutUsDTOById(AboutUsDTO);
			} else {
				AboutUsDTO.setCreateTime(new Date());
				AboutUsDTO.setIsDel("0");
				n = aboutUsService.insertAboutUsDTO(AboutUsDTO);
			}
		}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 删除
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		AboutUsDTO AboutUsDTO = aboutUsService.selectAboutUsDTOById(id);
		int n = 1;
		if(AboutUsDTO != null) {
			AboutUsDTO.setIsDel("1");
			n = aboutUsService.updateAboutUsDTOById(AboutUsDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}



}
