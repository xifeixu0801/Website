package com.regex.admin.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.common.dto.sys.RoleDTO;
import com.regex.admin.common.util.Contant;
import com.regex.admin.common.util.QueryParam;
import com.regex.admin.common.util.QueryResult;
import com.regex.admin.dao.sys.IRoleDAO;
import com.regex.admin.service.sys.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
    
    @Autowired
    private IRoleDAO roleDAO;

    public int insert(RoleDTO role) {
        return roleDAO.insert(role);
    }

    public int update(RoleDTO role) {
        return roleDAO.update(role);
    }

    public RoleDTO getById(long id) {
        return roleDAO.getById(id);
    }

    public QueryResult<RoleDTO> getPageByParam(QueryParam param) {
        param.setPageSize(Contant.NONMAL_PAGE_SIZE);
        param.setStartIndex((param.getPageNumber() - 1) * Contant.NONMAL_PAGE_SIZE);
        List<RoleDTO> data = roleDAO.getByParam(param);
        int totalCount = roleDAO.getByCountParam(param);
        QueryResult<RoleDTO> result = new QueryResult<RoleDTO>(totalCount, Contant.NONMAL_PAGE_SIZE, param.getPageNumber());
        result.setDatas(data);
        return result;
    }

    public int getByCountParam(QueryParam param) {
        return roleDAO.getByCountParam(param);
    }

    public void del(long id) {
        roleDAO.del(id + "");
    }

    @Override
    public int getRoleByName(Map<String, Object> map) {
        return roleDAO.getRoleByName(map);
    }

	
	public List<RoleDTO> selectAll() {
		
		return roleDAO.selectAll();
	}

	@Override
	public int checkRoleCode(Map<String, Object> map) {
		return roleDAO.checkRoleCode(map);
	}

}
