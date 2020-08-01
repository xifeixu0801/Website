package com.regex.admin.web.controller.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.web.NewsDTO;
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.INewsService;
import com.regex.admin.service.web.INewsTypeService;
import com.regex.admin.web.controller.utils.HTMLSpiritUtil;

@Controller
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private INewsTypeService newsTypeService;
	
	@RequestMapping("show_{type}")
	public String show(@PathVariable("type") String type, Model model, String current) {
		Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        if(StringUtils.isEmpty(type)) {
        	type = "1";
        }
        assist.setRequires(Assist.andEq("type", type));
        assist.setRowSize(Contant.NONMAL_PAGE_SIZE);
        if(StringUtils.isEmpty(current)) {
        	current = "0";
        } else {
        	current = (Integer.parseInt(current) -1) +"";
        }
        assist.setStartRow(Integer.parseInt(current));
		List<NewsDTO> productList = newsService.selectNewsDTO(assist);
		for(NewsDTO newsDTO : productList) {
			newsDTO.setDetial(HTMLSpiritUtil.delHTMLTag(newsDTO.getDetial()));
		}
		long total = newsService.getNewsDTORowCount(assist);
        Page<NewsDTO> result = new Page<NewsDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
        
		NewsTypeDTO newsTypeDTO = newsTypeService.selectNewsTypeDTOById(Long.parseLong(type));
		model.addAttribute("newsTypeDTO", newsTypeDTO);
		
		Assist assist5 = new Assist();
		assist5.setOrder(Assist.order("sort", true));
		assist5.setOrder(Assist.order("create_time", false));
		assist5.setRequires(Assist.andNeq("is_del", "1"));
        List<NewsTypeDTO> newsTypeList = newsTypeService.selectNewsTypeDTO(assist5);
        model.addAttribute("newsTypeList", newsTypeList);
        
		return "web/news-hy";
	}
	
	@RequestMapping("detial_{id}")
	public String detial(@PathVariable("id") String id, Model model) {
		NewsDTO newsDTO = newsService.selectNewsDTOById(Long.parseLong(id));
		NewsTypeDTO newsTypeDTO = newsTypeService.selectNewsTypeDTOById(Long.parseLong(newsDTO.getType()));
		newsDTO.setType(newsTypeDTO.getType());
		model.addAttribute("newsDTO", newsDTO);
		
		Assist assist5 = new Assist();
		assist5.setOrder(Assist.order("sort", true));
		assist5.setOrder(Assist.order("create_time", false));
		assist5.setRequires(Assist.andNeq("is_del", "1"));
        List<NewsTypeDTO> newsTypeList = newsTypeService.selectNewsTypeDTO(assist5);
        model.addAttribute("newsTypeList", newsTypeList);
        
		return "web/news-detail";
	}

}
