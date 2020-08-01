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
import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.common.util.Contant;
import com.regex.admin.service.web.IProductService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;

/**
 * 服务产品管理
 * @author admin
 *
 */
@Controller
@RequestMapping("sys/sucProduct")
public class SysSucProductController {
	
	@Autowired
	private IProductService productService;
	
	/**
	 * 服务产品列表管理
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
        assist.setRequires(Assist.andEq("type", "1"));
        assist.setRowSize(Contant.NONMAL_PAGE_SIZE);
        if(StringUtils.isEmpty(current)) {
        	current = "0";
        }
        assist.setStartRow(Integer.parseInt(current));
		List<ProductDTO> productList = productService.selectProductDTO(assist);
		long total = productService.getProductDTORowCount(assist);
        Page<ProductDTO> result = new Page<ProductDTO>();
        result.setRecords(productList);
        result.setSize(Contant.NONMAL_PAGE_SIZE);
        result.setTotal((int)total);
        result.setCurrent(Integer.parseInt(current));
        model.addAttribute("result", result);
		return "admin/sucProduct/show";
	}
	
	/**
	 * 服务产品新增/修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String input(String id, Model model) {
		if(StringUtils.isNotEmpty(id)) {
			ProductDTO productDTO = productService.selectProductDTOById(Long.parseLong(id));
			model.addAttribute("productDTO", productDTO);
		}
		return "admin/sucProduct/input";
	}
	
	/**
	 * 服务产品保存
	 * @param ProductDTO
	 * @param response
	 */
	@RequestMapping("save")
	public void save (ProductDTO ProductDTO, HttpServletResponse response, HttpServletRequest request) {
		int n = 0;
		if(StringUtils.isNotEmpty(ProductDTO.getName())) {
			ProductDTO.setUpdateTime(new Date());
			if(ProductDTO.getId() > 0) {
				n = productService.updateNonEmptyProductDTOById(ProductDTO);
			} else {
				ProductDTO.setType("1");
				ProductDTO.setCreateTime(new Date());
				ProductDTO.setIsDel("0");
				n = productService.insertProductDTO(ProductDTO);
			}
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}
	
	/**
	 * 服务产品删除
	 * @param id
	 * @param response
	 */
	@RequestMapping("del")
	public void del(long id, HttpServletResponse response) {
		ProductDTO ProductDTO = productService.selectProductDTOById(id);
		int n = 1;
		if(ProductDTO != null) {
			ProductDTO.setIsDel("1");
			n = productService.updateProductDTOById(ProductDTO);
		}
		WebInfoFilter.flag = 1;
		AjaxUtil.ajaxJsonSucMessage(response, n);
	}

}
