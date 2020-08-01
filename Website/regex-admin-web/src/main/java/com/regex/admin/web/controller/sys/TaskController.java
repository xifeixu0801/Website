package com.regex.admin.web.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.regex.admin.common.dto.sys.TaskJobInfo;
import com.regex.admin.service.sys.ITaskJobInfoService;
import com.regex.admin.web.controller.filter.WebInfoFilter;
import com.regex.admin.web.controller.utils.AjaxUtil;
import com.regex.admin.web.quartz.RegexQuartzService;

@Controller
@RequestMapping("sys/task")
public class TaskController {
    
    @Autowired
    private ITaskJobInfoService taskJobInfoService;
    
    @Autowired
    private RegexQuartzService regexQuartzService;
    
    @RequiresPermissions("task:show")
    @RequestMapping("show")
    public String show(Page<TaskJobInfo> page,@ModelAttribute("state") String state, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotEmpty(state)) {
            map.put("state", state);
        }
        page.setCondition(map);
        page.setAsc(false);
        page.setOrderByField("update_time");
        Page<TaskJobInfo> result = taskJobInfoService.getPage(page);
        model.addAttribute("result", result);
        return "sys/task/show";
    }
    
    @RequiresPermissions("task:show")
    @RequestMapping("tosave")
    public String tosave(String id, Model model) {
        if(StringUtils.isNotEmpty(id)) {
            TaskJobInfo taskJobInfo = taskJobInfoService.getById(id);
            model.addAttribute("taskJobInfo", taskJobInfo);
        }
        return "sys/task/input";
    }
    
    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param taskJobInfo
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("task:save")
    @RequestMapping("save")
    public void save(TaskJobInfo taskJobInfo, HttpServletResponse response) {
        int n = 0;
        try {
            if(StringUtils.isNotEmpty(taskJobInfo.getClasses()) && StringUtils.isNotEmpty(taskJobInfo.getCronExpression())
                    && StringUtils.isNotEmpty(taskJobInfo.getName())) {
                if(taskJobInfo.getId() != null) {
//                    JobKey jobKey = JobKey.jobKey("task_" + taskJobInfo.getId(), "group_" + taskJobInfo.getId());
                    taskJobInfoService.update(taskJobInfo);
//                    regexQuartzService.delete(jobKey);
                } else {
                    taskJobInfo.setIsDel("0");
                    taskJobInfo.setCreateTime(new Date());
                    taskJobInfo.setUpdateTime(new Date());
                    taskJobInfo.setState(1);
                    taskJobInfoService.insert(taskJobInfo);
                    regexQuartzService.add(taskJobInfo);
                }
                n = 1;
            } else {
                n = 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, n);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 停止和启动任务
     *
     * @param id
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequiresPermissions("task:reset")
    @RequestMapping("resetTask")
    public void resetTask(String id, HttpServletResponse response) {
        int n = 0;
        if(StringUtils.isNotEmpty(id)) {
            TaskJobInfo taskJobInfo = taskJobInfoService.getById(id);
            if (1 == taskJobInfo.getState()) {// 停止
                taskJobInfo.setState(0);
                JobKey jobKey = JobKey.jobKey("task_" + taskJobInfo.getId(), "group_" + taskJobInfo.getId());
                regexQuartzService.delete(jobKey);
            } else if (0 == taskJobInfo.getState()) {// 启动
                regexQuartzService.add(taskJobInfo);
                taskJobInfo.setState(1);
            }
            taskJobInfo.setUpdateTime(new Date());
            n = taskJobInfoService.update(taskJobInfo);
        } else {
            n = 2;
        }
        WebInfoFilter.flag = 1;
        AjaxUtil.ajaxJsonSucMessage(response, n);
    }

}
