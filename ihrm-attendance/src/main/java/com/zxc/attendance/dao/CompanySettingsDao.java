package com.zxc.attendance.dao;


import com.zxc.model.salarys.CompanySettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanySettingsDao extends JpaRepository<CompanySettings,String> ,JpaSpecificationExecutor<CompanySettings> {
}
