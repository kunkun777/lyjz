package com.zxc.salary.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zxc.inters.AttendanceInter;
import com.zxc.inters.SocialSecurityInter;
import com.zxc.model.atte.entity.ArchiveMonthlyInfo;
import com.zxc.model.salarys.SalaryArchive;
import com.zxc.model.salarys.SalaryArchiveDetail;
import com.zxc.model.salarys.Settings;
import com.zxc.model.salarys.UserSalary;
import com.zxc.model.social_security.ArchiveDetail;
import com.zxc.salary.dao.ArchiveDao;
import com.zxc.salary.dao.ArchiveDetailDao;
import com.zxc.salary.dao.UserSalaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 归档service
 */
@Service
public class ArchiveService {

    @Autowired
    private ArchiveDao archiveDao;

    @Autowired
    private ArchiveDetailDao archiveDetailDao;

//    @Autowired
//    private FeignClientService feignClientService;

    @Reference(version = "1.0.0",url="dubbo://127.0.0.1:12345")
    private AttendanceInter attendanceInter;

    @Reference(version = "1.0.0",url="dubbo://127.0.0.1:12342")
    private SocialSecurityInter socialSecurityInter;

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private UserSalaryDao userSalaryDao;

    @Autowired
    private SalaryService salaryService;


    /**
     * 根据企业和年月查询归档主表数据
     * @param yearMonth 年月
     * @param companyId 企业id
     * @return  企业和年月对应的归档主表数据
     */
    public SalaryArchive findSalaryArchive(String yearMonth, String companyId) {
        return archiveDao.findByCompanyIdAndYearsMonth(companyId , yearMonth);
    }

    /**
     * 根据归档的id查询所有的归档明细记录
     * @param id    归档id
     * @return  归档id对应的所有的归档明细记录
     */
    public List<SalaryArchiveDetail> findSalaryDetail(String id) {
        return archiveDetailDao.findByArchiveId(id);
    }

    /**
     *  查询月报表
     * @param yearMonth 年月
     * @param companyId 企业id
     * @return  对应企业id和年月的月报表数据
     */
    public List<SalaryArchiveDetail> getReports(String yearMonth, String companyId) {
        List<SalaryArchiveDetail> list = new ArrayList<>();
        //查询当前企业的福利津贴
        Settings setting = settingsService.findById(companyId);
        //查询所有的用户
        Page<Map> users = userSalaryDao.findPage(companyId, null);
        //遍历用户数据
        for (Map user : users.getContent()) {
            //构造SalaryArchiveDetail
            SalaryArchiveDetail saDetail = new SalaryArchiveDetail();
            saDetail.setUser(user);
            //获取每个用户社保数据
            Object obj = socialSecurityInter.historyData(saDetail.getUserId(), yearMonth).getData();
            if (obj != null){
                ArchiveDetail socialInfo = JSON.parseObject(JSON.toJSONString(obj),  ArchiveDetail.class);
                if (socialInfo != null){
                    saDetail.setSocialInfo(socialInfo);
                    if (obj != null){
                        obj = attendanceInter.historyData(saDetail.getUserId(), yearMonth).getData();
                        if (obj != null){
                            ArchiveMonthlyInfo atteInfo = JSON.parseObject(JSON.toJSONString(obj),  ArchiveMonthlyInfo.class);
                            if (atteInfo != null){
                                saDetail.setAtteInfo(atteInfo);
                                //获取每个用户的薪资
                                UserSalary userSalary = salaryService.findUserSalary(saDetail.getUserId());
                                if (userSalary != null){
                                    saDetail.setUserSalary(userSalary);
                                    //计算工资
                                    saDetail.calSalary(setting);
                                }
                            }
                        }
                    }
                }
            }

            list.add(saDetail);
        }
        return list;
    }
}
