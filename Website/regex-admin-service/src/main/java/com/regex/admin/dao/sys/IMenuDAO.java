package com.regex.admin.dao.sys;

import java.util.List;
import java.util.Map;

import com.regex.admin.common.IBaseDAO;
import com.regex.admin.common.dto.sys.MenuDTO;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * menuDAO 
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IMenuDAO extends IBaseDAO<MenuDTO> {
    
    List<MenuDTO> getMenuDTOByParentId(Map<String, Object> map);
    
    int getCountByParentId(Map<String, Object> map);
    
}
