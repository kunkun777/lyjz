package com.zxc.socialSecurity.dao;

import com.zxc.model.social_security.ArchiveDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义dao接口继承
 * JpaRepository<实体类，主键>
 * JpaSpecificationExecutor<实体类>
 */
@Component(value = "ArchiveDetailDao_salay")
public interface ArchiveDetailDao extends JpaRepository<ArchiveDetail, String>, JpaSpecificationExecutor<ArchiveDetail> {

    void deleteByArchiveId(String archiveId);

    List<ArchiveDetail> findByArchiveId(String archiveId);

    //根据用户id和年月查询归档明细
    ArchiveDetail findByUserIdAndYearsMonth(String userId, String yearMonth);
}
