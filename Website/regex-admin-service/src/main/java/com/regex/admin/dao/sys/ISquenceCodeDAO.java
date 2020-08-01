package com.regex.admin.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.regex.admin.common.dto.sys.SquenceCodeDTO;

public interface ISquenceCodeDAO extends BaseMapper<SquenceCodeDTO> {
	
    int getSquenceCode(String code);

}
