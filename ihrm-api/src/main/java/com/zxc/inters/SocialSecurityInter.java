package com.zxc.inters;

import com.zxc.common.entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SocialSecurityInter {
    /**
     * 根据用户id和考勤年月查询用户考勤归档明细
     */
    @RequestMapping(value = "/historys/archiveDetail/{userId}/{yearMonth}" , method = RequestMethod.GET)
    public Result historyData(@PathVariable String userId, @PathVariable String yearMonth);
}
