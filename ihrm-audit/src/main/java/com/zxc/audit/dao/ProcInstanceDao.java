package com.zxc.audit.dao;

import com.zxc.audit.entity.ProcInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author Administrator
 */
public interface ProcInstanceDao extends JpaRepository<ProcInstance,String>,
		JpaSpecificationExecutor<ProcInstance> {
}
