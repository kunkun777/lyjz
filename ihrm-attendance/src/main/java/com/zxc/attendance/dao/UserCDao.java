package com.zxc.attendance.dao;

import com.zxc.model.system.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserCDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    User findByMobile(String mobile);

    List<User> findByCompanyId(String companyId);

    @Query(value = "select * from bs_user where company_id = ?1" , nativeQuery = true)
    Page<User> findPage(String companyId, Pageable pageable);
}
