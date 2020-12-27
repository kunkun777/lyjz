package com.zxc.salary.service;


import com.zxc.model.salarys.Settings;
import com.zxc.salary.dao.SettingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 福利津贴service
 */
@Service
public class SettingsService {
    @Autowired
    private SettingsDao settingsDao;

    /**
     * 根据id获取企业设置
     * @param companyId 企业id
     * @return 企业设置
     */
    public Settings findById(String companyId) {
        Optional<Settings> optionalSettings = settingsDao.findById(companyId);
        return optionalSettings.isPresent() ? optionalSettings.get() : null;
    }

    /**
     * 保存配置
     */
    public void save(Settings settings) {
        settingsDao.save(settings);
    }
}
