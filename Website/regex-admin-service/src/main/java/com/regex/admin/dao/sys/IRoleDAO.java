package com.regex.admin.dao.sys;

import java.util.List;
import java.util.Map;

import com.regex.admin.common.IBaseDAO;
import com.regex.admin.common.dto.sys.RoleDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 角色权限DAO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IRoleDAO extends IBaseDAO<RoleDTO> {
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
