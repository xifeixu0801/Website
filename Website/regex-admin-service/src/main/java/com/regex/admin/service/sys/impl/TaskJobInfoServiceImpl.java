package com.regex.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.TaskJobInfo;
import com.regex.admin.dao.sys.ITaskJobInfoDAO;
import com.regex.admin.service.sys.ITaskJobInfoService;

@Service
public class TaskJobInfoServiceImpl implements ITaskJobInfoService {
    
    @Autowired
    private ITaskJobInfoDAO taskJobInfoDAO;

    @Override
    public int insert(TaskJobInfo t) {
        return taskJobInfoDAO.insert(t);
    }

    @Override
    public int update(TaskJobInfo t) {
        return taskJobInfoDAO.updateById(t);
    }

    @Override
    public TaskJobInfo getById(String id) {
        return taskJobInfoDAO.selectById(id);
    }

    @Override
    public int getByCountParam(Object obj) {
        return taskJobInfoDAO.getByCountParam(obj);
    }

    @Override
    public void del(String id) {
        taskJobInfoDAO.del(id);
    }

    @Override
    public Page<TaskJobInfo> getPage(Page<TaskJobInfo> page) {
        page.setRecords(taskJobInfoDAO.getPage(page, page.getCondition()));
        return page;
    }

    @Override
    public List<TaskJobInfo> getAll() {
        return taskJobInfoDAO.getAll();
    }

    @Override
    public int updateState(String id) {
        return taskJobInfoDAO.updateState(id);
    }

}
