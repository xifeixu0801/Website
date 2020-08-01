package com.regex.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.common.dto.sys.RoleMenuDTO;
import com.regex.admin.dao.sys.IRoleMenuDAO;
import com.regex.admin.service.sys.IRoleMenuService;

@Service
public class RoleMenuServiceImpl implements IRoleMenuService {
    
    @Autowired
    private IRoleMenuDAO roleMenuDAO;

    public int insert(RoleMenuDTO roleMenuDTO) {
        return roleMenuDAO.insert(roleMenuDTO);
    }

    public List<RoleMenuDTO> getRoleMenuListByRoleId(long roleId) {
        return roleMenuDAO.getRoleMenuListByRoleId(roleId);
    }

    public void del(long roleId) {
        roleMenuDAO.del(roleId);
    }

    @Override
    public void deleteByMenuId(long menuId) {
        roleMenuDAO.deleteByMenuId(menuId);        
    }

	
}
