package com.zxc.salary.dao;

import com.zxc.model.salarys.SalaryArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 自定义dao接口继承
 *      JpaRepository<实体类，主键>
 *      JpaSpecificationExecutor<实体类>
 */
public interface ArchiveDao extends JpaRepository<SalaryArchive,String> ,JpaSpecificationExecutor<SalaryArchive> {

    SalaryArchive findByCompanyIdAndYearsMonth(String companyId, String yearMonth);
}
