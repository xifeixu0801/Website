package com.regex.admin.service.sys;

import java.util.List;
import java.util.Map;

import com.regex.admin.common.dto.sys.RoleDTO;
import com.regex.admin.common.util.QueryParam;
import com.regex.admin.common.util.QueryResult;

public interface IRoleService {
    
    int insert(RoleDTO role);
    
    int update(RoleDTO role);
    
    RoleDTO getById(long id);
    
    QueryResult<RoleDTO> getPageByParam(QueryParam param);
    
    int getByCountParam(QueryParam param);
    
    void del(long id);
    /**
     * 
     * 功能描述: <br>
     * 根据角色名称获取角色
     *
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int getRoleByName(Map<String, Object> map);
    
    List<RoleDTO>  selectAll();
    /**
     * 检查roleCode是否被占用
     * @param map
     * @return
     */
    int checkRoleCode(Map<String, Object> map);
}
