package com.zxc.audit.inter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zxc.common.entity.Result;
import com.zxc.inters.SystemInter;
import com.zxc.model.system.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Component("FeignClientService")
public class FeignClientService {
    @Reference(version = "1.0.0",url="dubbo://127.0.0.1:12341")
    private SystemInter systemInter;

    /**
     * 查询用户信息
     */
    public User getUserInfoByUserId(String userId) {
        if (StringUtils.isEmpty(userId)){
            throw new RuntimeException("获取当前用户为空！");
        }

        Result result = systemInter.findById(userId);
        if (!result.isSuccess()){
            throw new RuntimeException("用户ID不存在，请联系管理员：" + userId);
        }
        return JSON.parseObject(JSON.toJSONString(result.getData()), User.class);
    }
}
