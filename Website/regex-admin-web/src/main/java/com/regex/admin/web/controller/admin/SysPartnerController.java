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
import com.regex.admin.common.dto.web.PartnerDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IPartnerService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 合作伙伴管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/partner")
public class SysPartnerController {

	
	@Autowired
	private IPartnerService partnerService;
	
	/**
	 * 合作伙伴列表管理
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
		List<PartnerDTO> productList = partnerService.selectPartnerDTO(assist);
		long total = partnerService.getPartnerDTORowCount(assist);
        Page<PartnerDTO> result = new Page<PartnerDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/partner/show";
	}
	
	/**
	 * 新增/修改合作火把
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			PartnerDTO partnerDTO = partnerService.selectPartnerDTOById(Long.parseLong(id));
			model.addAttribute("partnerDTO", partnerDTO);
		}
		return "admin/partner/input";
	}
	
	/**
	 * 保存合作伙伴
	 * @param PartnerDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (PartnerDTO PartnerDTO, HttpServletResponse response) {
		int n = 0;
		if(StringUtils.isNotEmpty(PartnerDTO.getLogo())) {
			PartnerDTO.setUpdateTime(new Date());
			if(PartnerDTO.getId() > 0) {
				n = partnerService.updateNonEmptyPartnerDTOById(PartnerDTO);
			} else {
				PartnerDTO.setCreateTime(new Date());
				PartnerDTO.setIsDel("0");
				n = partnerService.insertPartnerDTO(PartnerDTO);
			}
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 删除合作伙伴
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		PartnerDTO PartnerDTO = partnerService.selectPartnerDTOById(id);
		int n = 1;
		if(PartnerDTO != null) {
			PartnerDTO.setIsDel("1");
			n = partnerService.updatePartnerDTOById(PartnerDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}


}
