package com.regex.admin.dao.sys;

import java.util.List;

import com.regex.admin.common.IBaseDAO;
import com.regex.admin.common.dto.sys.UserRoleDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * userRoleDAO
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IUserRoleDAO extends IBaseDAO<UserRoleDTO> {
    /**
     * 
     * 功能描述: <br>
     * 新增用户角色
     *
     * @param userRoleDTO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer insert(UserRoleDTO userRoleDTO);
    /**
     * 
     * 功能描述: <br>
     * 获取用户角色
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<UserRoleDTO> getByUserId(long userId);
    /**
     * 
     * 功能描述: <br>
     * 删除用户角色
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void del(long userId);
    /**
     * 
     * 功能描述: <br>
     * 获取当前权限有无用户使用
     *
     * @param roleId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int getByRoleId(long roleId);
    
    int update(UserRoleDTO userRoleDTO);
    
    UserRoleDTO selectById(long id);
}
