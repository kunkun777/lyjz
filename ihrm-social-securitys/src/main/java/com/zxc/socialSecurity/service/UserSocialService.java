package com.zxc.socialSecurity.service;

import com.zxc.common.entity.PageResult;
import com.zxc.model.social_security.UserSocialSecurity;
import com.zxc.socialSecurity.dao.UserSocialSecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserSocialService {
	
    @Autowired
    private UserSocialSecurityDao userSocialSecurityDao;

    /**
     * 分页查询用户的社保数据
     * @param page  页数
     * @param pageSize  每页条数
     * @param companyId 公司id
     * @return  分页结果
     */
    public PageResult findAll(int page, int pageSize, String companyId) {
        Page<Map> pageData = userSocialSecurityDao.findPage(companyId, PageRequest.of(page - 1, pageSize));
        return new PageResult(pageData.getTotalElements() , pageData.getContent());
    }

    /**
     * 根据id查询社保数据
     * @param id    用户id
     * @return  根据ID查询的社保数据
     */
    public UserSocialSecurity findById(String id) {
        Optional<UserSocialSecurity> userSocialSecurity = userSocialSecurityDao.findById(id);
        return userSocialSecurity.isPresent() ? userSocialSecurity.get() : null;
    }

    /**
     * 保存或更新用户社保
     * @param uss   用户社保
     */
    public void save(UserSocialSecurity uss) {
        userSocialSecurityDao.save(uss);
    }
}
