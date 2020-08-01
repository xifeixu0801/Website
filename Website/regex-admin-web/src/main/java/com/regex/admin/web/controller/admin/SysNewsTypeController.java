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
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.INewsTypeService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 新闻类型管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/newsType")
public class SysNewsTypeController {
	
	@Autowired
	private INewsTypeService newsTypeService;
	
	/**
	 * 类型列表管理
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
		List<NewsTypeDTO> productList = newsTypeService.selectNewsTypeDTO(assist);
		long total = newsTypeService.getNewsTypeDTORowCount(assist);
        Page<NewsTypeDTO> result = new Page<NewsTypeDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/newsType/show";
	}
	
	/**
	 * 新闻类型新增或修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			NewsTypeDTO newsTypeDTO = newsTypeService.selectNewsTypeDTOById(Long.parseLong(id));
			model.addAttribute("newsTypeDTO", newsTypeDTO);
		}
		return "admin/newsType/input";
	}
	
	/**
	 * 新闻保存
	 * @param NewsTypeDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (NewsTypeDTO NewsTypeDTO, HttpServletResponse response) {
		int n = 0;
		if(StringUtils.isNotEmpty(NewsTypeDTO.getType())) {
			NewsTypeDTO.setUpdateTime(new Date());
			if(NewsTypeDTO.getId() > 0) {
				n = newsTypeService.updateNonEmptyNewsTypeDTOById(NewsTypeDTO);
			} else {
				NewsTypeDTO.setCreateTime(new Date());
				NewsTypeDTO.setIsDel("0");
				n = newsTypeService.insertNewsTypeDTO(NewsTypeDTO);
			}
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 新闻类型删除
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		NewsTypeDTO NewsTypeDTO = newsTypeService.selectNewsTypeDTOById(id);
		int n = 1;
		if(NewsTypeDTO != null) {
			NewsTypeDTO.setIsDel("1");
			n = newsTypeService.updateNewsTypeDTOById(NewsTypeDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}



}
