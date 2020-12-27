package com.zxc.socialSecurity.service;

import com.zxc.socialSecurity.dao.CityPaymentItemDao;
import com.zxc.socialSecurity.dao.PaymentItemDao;
import com.zxc.model.social_security.CityPaymentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentItemService {
	
    @Autowired
    private PaymentItemDao paymentItemDao;
	
    @Resource(type = CityPaymentItemDao.class)
    private CityPaymentItemDao cityPaymentItemDao;

    /**
     * 根据城市id获取参保项目
     * @param id    城市id
     * @return  城市对应获取参保项目
     */
    public List<CityPaymentItem> findAllByCityId(String id) {
        return cityPaymentItemDao.findAllByCityId(id);
    }
}
