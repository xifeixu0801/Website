package com.regex.admin.service.sys.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.aop.LogAop;
import com.regex.admin.common.dto.sys.UserDTO;
import com.regex.admin.dao.sys.IUserDAO;
import com.regex.admin.service.sys.IUserService;

@EnableAspectJAutoProxy
@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDAO IUserDAO;



    /*@LogAop(content="查询",type="SELECT")*/
    public UserDTO getUserByLoginName(String loginName) {
        return IUserDAO.getUserByLoginName(loginName);
    }
    
    @LogAop(content="添加用户",type="INSERT",desc="user_insert")
	public int insert(UserDTO userDTO) {
		return IUserDAO.insert(userDTO);
	}
    
    
	public Page<UserDTO> selectAll(Page<UserDTO> page) {
		page.setRecords(IUserDAO.selectAll(page, page.getCondition()));
		return page;
	}
    
	public int selectCount() {
		return IUserDAO.selectCount();
	}

	
	public UserDTO selectById(long id) {
		return IUserDAO.selectById(id);
	}

	@LogAop(content="修改用户信息",type="UPDATE",desc="user_update")
	public int updateUser(UserDTO userDTO) {
		
		return IUserDAO.updateUser(userDTO);
	}

	@LogAop(content="根据用户ID删除",type="DELETE",desc="user_delete")
	public int deleteUser(long id) {
		
		return IUserDAO.deleteUser(id);
	}

	@LogAop(content="修改密码",type="UPDATE",desc="updatePwd")
	public int updatePwd(UserDTO userDTO) {
		
		return IUserDAO.updatePwd(userDTO);
	}

	@Override
	public int resetPassword(Map<String, Object> map) {
		return IUserDAO.resetPassword(map);
	}

}
