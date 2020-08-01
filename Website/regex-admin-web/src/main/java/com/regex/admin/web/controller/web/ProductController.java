package com.regex.admin.web.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("detial_{id}")
	public String detial(@PathVariable("id") String id, Model model) {
		ProductDTO productDTO = productService.selectProductDTOById(Long.parseLong(id));
		Assist assist = new Assist();
		assist.setOrder(Assist.order("sort", true));
        assist.setOrder(Assist.order("create_time", false));
        assist.setRequires(Assist.andNeq("is_del", "1"));
        assist.setRequires(Assist.andEq("type", "0"));
		List<ProductDTO> productList = productService.selectProductDTO(assist);
		model.addAttribute("productList", productList);
		model.addAttribute("productDTO", productDTO);
		return "web/product";
	}

}
