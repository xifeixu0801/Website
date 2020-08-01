package com.regex.admin.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regex.admin.dao.sys.ISquenceCodeDAO;
import com.regex.admin.service.sys.ISquenceCodeService;

@Service
public class SquenceCodeServiceImpl implements ISquenceCodeService {
	
	@Autowired
	private ISquenceCodeDAO squenceCodeDAO;

	public int getSquenceCode(String code) {
		return squenceCodeDAO.getSquenceCode(code);
	}

}
