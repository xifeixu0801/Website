package com.regex.admin.service.sys;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.UserDTO;

public interface IUserService {
    
    UserDTO getUserByLoginName(String loginName);
    
    int insert(UserDTO userDTO);
    
    Page<UserDTO> selectAll(Page<UserDTO> page);
    
    int selectCount();
    
    UserDTO selectById(long id);

    int updateUser(UserDTO userDTO);
    
    int deleteUser(long id);
    
    int updatePwd(UserDTO userDTO);
    /**
     * 
     * 功能描述: <br>
     * 重置密码
     *
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int resetPassword(Map<String, Object> map);

}
