package com.zxc.attendance.dao;

import com.zxc.model.atte.entity.DeductionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface DeductionTypeDao extends JpaRepository<DeductionType, String>, JpaSpecificationExecutor<DeductionType> {
}
