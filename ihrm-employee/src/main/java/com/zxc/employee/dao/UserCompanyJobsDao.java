package com.zxc.employee.dao;

import com.zxc.model.employee.UserCompanyJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 */
public interface UserCompanyJobsDao extends JpaRepository<UserCompanyJobs, String>, JpaSpecificationExecutor<UserCompanyJobs> {
    UserCompanyJobs findByUserId(String userId);
}