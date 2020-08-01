package com.regex.admin.web.controller.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.regex.admin.common.dto.web.AboutUsDTO;
import com.regex.admin.common.dto.web.BannerDTO;
import com.regex.admin.common.dto.web.NewsTypeDTO;
import com.regex.admin.common.dto.web.ProductDTO;
import com.regex.admin.common.dto.web.WebInfoDTO;
import com.regex.admin.common.util.Assist;
import com.regex.admin.service.web.IAboutUsService;
import com.regex.admin.service.web.IBannerService;
import com.regex.admin.service.web.INewsTypeService;
import com.regex.admin.service.web.IProductService;
import com.regex.admin.service.web.IWebInfoService;

/**
 * 网站信息过滤器
 * @author admin
 *
 */
public class WebInfoFilter extends OncePerRequestFilter {
    
    @Autowired
    protected IWebInfoService webInfoService;
    
    @Autowired
    private IBannerService bannerService;
    
    @Autowired
	private IProductService productService;
    
    @Autowired
    private INewsTypeService newsTypeService;
    
    @Autowired
	private IAboutUsService aboutUsService;
    
    public static int flag = 0;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Object sessionObj = request.getSession().getAttribute("webInfo");
        // 如果Session为空，则跳转到指定页面
        if (sessionObj == null || flag == 1) {
            WebInfoDTO webInfo = webInfoService.selectWebInfoDTOById(1l);
            request.getSession().setAttribute("webInfo", webInfo);
            
            Assist assist = new Assist();
            assist.setOrder(Assist.order("create_time", false));
            assist.setRequires(Assist.andNeq("is_del", "1"));
            List<BannerDTO> bannerList = bannerService.selectBannerDTO(assist);
            request.getSession().setAttribute("bannerList", bannerList);
            
            Assist assist1 = new Assist();
    		assist1.setOrder(Assist.order("sort", true));
            assist1.setOrder(Assist.order("create_time", false));
            assist1.setRequires(Assist.andNeq("is_del", "1"));
            assist1.setRequires(Assist.andEq("type", "0"));
    		List<ProductDTO> productListFilter = productService.selectProductDTO(assist1);
    		request.getSession().setAttribute("productListFilter", productListFilter);
    		
    		Assist assist5 = new Assist();
    		assist5.setOrder(Assist.order("sort", true));
    		assist5.setOrder(Assist.order("create_time", false));
    		assist5.setRequires(Assist.andNeq("is_del", "1"));
            List<NewsTypeDTO> newsTypeListFilter = newsTypeService.selectNewsTypeDTO(assist5);
            request.getSession().setAttribute("newsTypeListFilter", newsTypeListFilter);
    		
    		
    		Assist assist4 = new Assist();
    		assist4.setOrder(Assist.order("sort", true));
    		assist4.setOrder(Assist.order("create_time", false));
    		assist4.setRequires(Assist.andNeq("is_del", "1"));
    		assist4.setRequires(Assist.andEq("type", "1"));
    		assist4.setRowSize(4);
    		assist4.setStartRow(0);
            List<ProductDTO> sucProductListFilter = productService.selectProductDTO(assist4);
            request.getSession().setAttribute("sucProductListFilter", sucProductListFilter);
            
            Assist assist2 = new Assist();
    		assist2.setOrder(Assist.order("sort", true));
    		assist2.setOrder(Assist.order("create_time", false));
            assist2.setRequires(Assist.andNeq("is_del", "1"));
    		List<AboutUsDTO> aboutUsListFilter = aboutUsService.selectAboutUsDTO(assist2);
    		request.getSession().setAttribute("aboutUsListFilter", aboutUsListFilter);
    		flag=0;
    		filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }
    }
