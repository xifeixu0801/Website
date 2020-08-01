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
import com.regex.admin.common.dto.web.BannerDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IBannerService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * banner管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/banner")
public class SysBannerController {
	
	@Autowired
	private IBannerService bannerService;
	
	/**
	 * banner列表
	 * @param model
	 * @param current
	 * @return
	 */
	@RequestMapping("show")
	public String show (Model model, String current) {
		Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        assist.setRowSize(Contant.NONMAL_PAGE_SIZE);
        if(StringUtils.isEmpty(current)) {
        	current = "0";
        }
        assist.setStartRow(Integer.parseInt(current));
        List<BannerDTO> bannerList = bannerService.selectBannerDTO(assist);
        long total = bannerService.getBannerDTORowCount(assist);
        Page<BannerDTO> result = new Page<BannerDTO>();
        result.setRecords(bannerList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/banner/show";
	}
	
	/**
	 * 新增/修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			BannerDTO bannerDTO = bannerService.selectBannerDTOById(Long.parseLong(id));
			model.addAttribute("bannerDTO", bannerDTO);
		}
		return "admin/banner/input";
	}
	
	/**
	 * 保存
	 * @param bannerDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (BannerDTO bannerDTO, HttpServletResponse response, HttpServletRequest request) {
		int n = 0;
		if(StringUtils.isNotEmpty(bannerDTO.getBannerUrl())) {
			bannerDTO.setUpdateTime(new Date());
			if(bannerDTO.getId() > 0) {
				n = bannerService.updateNonEmptyBannerDTOById(bannerDTO);
			} else {
				bannerDTO.setCreateTime(new Date());
				bannerDTO.setIsDel("0");
				n = bannerService.insertBannerDTO(bannerDTO);
			}
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
		BannerDTO bannerDTO = bannerService.selectBannerDTOById(id);
		int n = 1;
		if(bannerDTO != null) {
			bannerDTO.setIsDel("1");
			n = bannerService.updateBannerDTOById(bannerDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}

}
