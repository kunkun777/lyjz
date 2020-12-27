package com.zxc.inters;

import com.zxc.model.company.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface DepartmentInter {
    @RequestMapping(value = "/department/search" , method = RequestMethod.POST)
    public Department findByCode(@RequestParam("code") String code, @RequestParam("companyId") String companyId);
}
