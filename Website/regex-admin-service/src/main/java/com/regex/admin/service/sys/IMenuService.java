package com.regex.admin.service.sys;

import java.util.List;
import java.util.Map;

import com.regex.admin.common.dto.sys.MenuDTO;

public interface IMenuService {
    /**
     * 
     * 功能描述: <br>
     * 新增
     *
     * @param t
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int insert(MenuDTO t);
    /**
     * 
     * 功能描述: <br>
     * 更新
     *
     * @param t
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int update(MenuDTO t);
    /**
     * 
     * 功能描述: <br>
     * 根据id获取
     *
     * @param id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    MenuDTO getById(long id);
    /**
     * 
     * 功能描述: <br>
     * 获取列表
     *
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MenuDTO> getByParam();
    /**
     * 
     * 功能描述: <br>
     * 获取总数
     *
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int getByCountParam();
    /**
     * 
     * 功能描述: <br>
     * 删除
     *
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void del(long id);
    /**
     * 
     * 功能描述: <br>
     * 根据parentid获取菜单
     *
     * @param map type=2 取不包括按钮的所有菜单   type>2时取所有菜单 parentId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MenuDTO> getMenuDTOByParentId(Map<String, Object> map);
    /**
     * 
     * 功能描述: <br>
     * 获取菜单是否含有子菜单
     *
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int getCountByParentId(Map<String, Object> map);
}
