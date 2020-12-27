package com.zxc.salary.controller;

import com.zxc.common.controller.BaseController;
import com.zxc.common.entity.Result;
import com.zxc.common.entity.ResultCode;
import com.zxc.model.salarys.Settings;
import com.zxc.salary.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *	津贴controller
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/salarys")
public class SettingsController extends BaseController {

	@Autowired
	private SettingsService settingsService;

	/**
	 * 获取企业计薪及津贴设置
	 */
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public Result getSettings() throws Exception {
		Settings settings = settingsService.findById(companyId);
		return new Result(ResultCode.SUCCESS, settings);
	}

	/**
	 * 保存企业计薪及津贴设置
	 */
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public Result saveSettings(@RequestBody Settings settings) throws Exception {
		settings.setCompanyId(companyId);
		settingsService.save(settings);
		return new Result(ResultCode.SUCCESS);
	}
}
