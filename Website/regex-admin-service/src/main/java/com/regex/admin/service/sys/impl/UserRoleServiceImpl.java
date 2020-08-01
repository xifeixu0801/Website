package com.regex.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.common.dto.sys.UserRoleDTO;
import com.regex.admin.dao.sys.IUserRoleDAO;
import com.regex.admin.service.sys.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    
    @Autowired
    private IUserRoleDAO userRoleDAO;

    public int insert(UserRoleDTO userRoleDTO) {
        return userRoleDAO.insert(userRoleDTO);
    }

    public List<UserRoleDTO> getByUserId(long userId) {
        return userRoleDAO.getByUserId(userId);
    }

    public void del(long userId) {
        userRoleDAO.del(userId);
    }

    @Override
    public int getByRoleId(long roleId) {
        return userRoleDAO.getByRoleId(roleId);
    }

	@Override
	public int update(UserRoleDTO userRoleDTO) {
		
		return userRoleDAO.update(userRoleDTO);
	}

	
	public UserRoleDTO selectById(long id) {
		
		return userRoleDAO.selectById(id);
	}

}
