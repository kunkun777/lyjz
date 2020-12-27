package com.zxc.inters;

import com.zxc.common.entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AttendanceInter {
    /**
     * 根据用户id和月份查询已归档的考勤明细
     */
    @RequestMapping(value = "/archive/{userId}/{yearMonth}" , method = RequestMethod.GET)
    public Result historyData(@PathVariable String userId, @PathVariable String yearMonth);
}
