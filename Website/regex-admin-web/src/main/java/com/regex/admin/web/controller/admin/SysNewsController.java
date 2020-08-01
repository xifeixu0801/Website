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
import com.regex.admin.common.dto.web.NewsDTO;
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.INewsService;
import com.regex.admin.service.web.INewsTypeService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 新闻管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/news")
public class SysNewsController {
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private INewsTypeService newsTypeService;
	
	/**
	 * 新闻列表查询
	 * @param model
	 * @param current
	 * @return
	 */
	@RequestMapping("show")
	public String show(Model model, String current) {
		Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        assist.setRowSize(Contant.NONMAL_PAGE_SIZE);
        if(StringUtils.isEmpty(current)) {
        	current = "0";
        }
        assist.setStartRow(Integer.parseInt(current));
		List<NewsDTO> productList = newsService.selectNewsDTO(assist);
		long total = newsService.getNewsDTORowCount(assist);
		for(NewsDTO newsDTO : productList) {
			NewsTypeDTO newsTypeDTO = newsTypeService.selectNewsTypeDTOById(Long.parseLong(newsDTO.getType()));
			newsDTO.setType(newsTypeDTO.getType());
		}
        Page<NewsDTO> result = new Page<NewsDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/news/show";
	}
	
	/**
	 * 新增或修改新闻
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		Assist assist = new Assist();
        assist.setRequires(Assist.andNeq("is_del", "1"));
        List<NewsTypeDTO> newsTypeList = newsTypeService.selectNewsTypeDTO(assist);
        model.addAttribute("newsTypeList", newsTypeList);
		if(StringUtils.isNotEmpty(id)) {
			NewsDTO newsDTO = newsService.selectNewsDTOById(Long.parseLong(id));
			model.addAttribute("newsDTO", newsDTO);
		}
		return "admin/news/input";
	}
	
	/**
	 * 保存新闻
	 * @param NewsDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (NewsDTO NewsDTO, HttpServletResponse response) {
		int n = 0;
		if(StringUtils.isNotEmpty(NewsDTO.getTitle())) {
			NewsDTO.setUpdateTime(new Date());
			if(NewsDTO.getId() > 0) {
				n = newsService.updateNonEmptyNewsDTOById(NewsDTO);
			} else {
				NewsDTO.setCreateTime(new Date());
				NewsDTO.setIsDel("0");
				n = newsService.insertNewsDTO(NewsDTO);
			}
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 删除新闻
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		NewsDTO NewsDTO = newsService.selectNewsDTOById(id);
		int n = 1;
		if(NewsDTO != null) {
			NewsDTO.setIsDel("1");
			n = newsService.updateNewsDTOById(NewsDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}

}
