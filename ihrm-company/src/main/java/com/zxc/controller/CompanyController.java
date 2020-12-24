package com.zxc.controller;

import com.zxc.common.entity.Result;
import com.zxc.common.entity.ResultCode;
import com.zxc.model.company.Company;
import com.zxc.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/company")
@Api(tags = "Company-controller",description = "About 公司")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "保存公司")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result save(@RequestBody Company company)  {

        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation(value = "根据id更新企业信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody Company company ) {

        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation(value = "根据id删除企业")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    @ApiOperation(value = "根据id查询企业")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findCompanyById(@PathVariable(value="id") String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    @ApiOperation("查询全部企业列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result findAll() {
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

    @ApiOperation("更新企业状态")
    @RequestMapping(value="/{id}/state/{state}",method = RequestMethod.PUT)
    public Result findAll(@PathVariable(value = "id") String id ,
                          @PathVariable(value = "state") int state) {
        Company company = companyService.findById(id);
        company.setState(state);
        companyService.save(company);
        return new Result(ResultCode.SUCCESS);
    }
}
