package com.regex.admin.dao.sys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.TaskJobInfo;

public interface ITaskJobInfoDAO extends BaseMapper<TaskJobInfo> {
    
    List<TaskJobInfo> getAll();
    
    int updateState(String id);
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
    int getByCountParam(Object obj);
    /**
     * 
     * 功能描述: <br>
     * 删除
     *
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void del(Serializable id);
    /**
     * 
     * 功能描述: <br>
     * 查询分页
     *
     * @param page
     * @param map page.condition
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<TaskJobInfo> getPage(Page<TaskJobInfo> page, Map<String, Object> map);

}
