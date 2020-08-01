package com.regex.admin.common.dto.sys;

import java.io.Serializable;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * Squence code
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SquenceCodeDTO implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = 7260067845301027707L;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
