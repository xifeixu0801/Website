package com.regex.admin.dao.sys;

import java.util.List;

import com.regex.admin.common.IBaseDAO;
import com.regex.admin.common.dto.sys.RoleMenuDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 角色菜单DAO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IRoleMenuDAO extends IBaseDAO<RoleMenuDTO> {
    /**
     * 
     * 功能描述: <br>
     * 创建角色菜单
     *
     * @param roleMenuDTO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer insert(RoleMenuDTO roleMenuDTO);
    /**
     * 
     * 功能描述: <br>
     * 获取角色菜单列表
     *
     * @param id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<RoleMenuDTO> getRoleMenuListByRoleId(long roleId);
    /**
     * 
     * 功能描述: <br>
     * 删除角色菜单
     *
     * @param roleId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void del(long roleId);
    /**
     * 
     * 功能描述: <br>
     * 通过菜单id删除权限
     *
     * @param menuId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void deleteByMenuId(long menuId);

}
