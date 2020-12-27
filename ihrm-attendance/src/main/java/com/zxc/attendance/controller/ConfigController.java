package com.zxc.attendance.controller;

import com.zxc.common.controller.BaseController;
import com.zxc.common.entity.Result;
import com.zxc.common.entity.ResultCode;
import com.zxc.model.atte.entity.AttendanceConfig;
import com.zxc.attendance.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
public class ConfigController extends BaseController {

    @Autowired
    private ConfigurationService configurationService;

    /**
     * 获取考勤设置
     */
    @RequestMapping(value = "/atte/item" , method = RequestMethod.POST)
    public Result atteConfig(String departmentId){
        AttendanceConfig ac;
        ac = configurationService.getAtteConfig(companyId , departmentId);
        return new Result(ResultCode.SUCCESS , ac);
    }

    /**
     * 保存考勤设置
     */
    @RequestMapping(value = "/atte" , method = RequestMethod.PUT)
    public Result saveAtteConfig(@RequestBody AttendanceConfig ac){
        ac.setCompanyId(companyId );
        configurationService.saveAtteConfig(ac);
        return new Result(ResultCode.SUCCESS);
    }

}
