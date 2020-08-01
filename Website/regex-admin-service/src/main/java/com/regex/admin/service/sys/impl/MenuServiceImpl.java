package com.regex.admin.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.aop.LogAop;
import com.regex.admin.common.dto.sys.MenuDTO;
import com.regex.admin.dao.sys.IMenuDAO;
import com.regex.admin.service.sys.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
    
    @Autowired
    private IMenuDAO menuDAO;

    @LogAop(content="菜单查询",type="menu_select")
    public int insert(MenuDTO t) {
        return menuDAO.insert(t);
    }

    public int update(MenuDTO t) {
        return menuDAO.update(t);
    }

    public MenuDTO getById(long id) {
        return menuDAO.getById(id);
    }

    public List<MenuDTO> getByParam() {
        return menuDAO.getByParam(null);
    }

    public int getByCountParam() {
        return menuDAO.getByCountParam(null);
    }

    public void del(long id) {
        menuDAO.del(id);
    }

    public List<MenuDTO> getMenuDTOByParentId(Map<String, Object> map) {
        return menuDAO.getMenuDTOByParentId(map);
    }

    @Override
    public int getCountByParentId(Map<String, Object> map) {
        return menuDAO.getCountByParentId(map);
    }

}
