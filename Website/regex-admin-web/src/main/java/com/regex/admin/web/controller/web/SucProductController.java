package com.regex.admin.web.controller.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IProductService;

@Controller
@RequestMapping("sucProduct")
public class SucProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("detial_{id}")
	public String detial(@PathVariable("id") String id, Model model) {
		Assist assist4 = new Assist();
		assist4.setOrder(Assist.order("sort", true));
		assist4.setOrder(Assist.order("create_time", false));
		assist4.setRequires(Assist.andNeq("is_del", "1"));
		assist4.setRequires(Assist.andEq("type", "1"));
		assist4.setRowSize(4);
		assist4.setStartRow(0);
		List<ProductDTO> sucProductList = productService.selectProductDTO(assist4);
		if(StringUtils.isEmpty(id)) {
	        if(null != sucProductList&& sucProductList.size() != 0) {
	        	id = sucProductList.get(0).getId() + "";
	        }
		}
		
		ProductDTO sucProductDTO = productService.selectProductDTOById(Long.parseLong(id));
		//model.addAttribute("productList", sucProductList);
		model.addAttribute("sucProductList", sucProductList);
		model.addAttribute("sucProductDTO", sucProductDTO);
		//return "web/product";2020-3-23
		return "web/sucProduct";
	}

}
