package com.regex.admin.service.sys;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.TaskJobInfo;

public interface ITaskJobInfoService {
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
    int insert(TaskJobInfo t);
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
    int update(TaskJobInfo t);
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
    TaskJobInfo getById(String id);
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
    void del(String id);
    /**
     * 
     * 功能描述: <br>
     * 查询分页
     *
     * @param page
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Page<TaskJobInfo> getPage(Page<TaskJobInfo> page);
    /**
     * 
     * 功能描述: <br>
     * 获取所有Task
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<TaskJobInfo> getAll();
    /**
     * 
     * 功能描述: <br>
     * 更新task状态
     *
     * @param id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int updateState(String id);
}
