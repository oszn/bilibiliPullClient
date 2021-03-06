package com.liuy.service.bili;

import com.liuy.dao.entry.Bili;
import com.liuy.dao.entry.BiliExample;
import com.liuy.manager.bili.BiliManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @className: BiliServiceImpl
 * @description: bili的服务
 * @author: liuy
 * @create: 2021-03-06 11:04
 **/

@Service
public class BiliServiceImpl implements BiliService{
    @Autowired
    BiliManger biliManger;
    @Override
    public int getCount() {
        return biliManger.countByExample(new BiliExample());
    }

    @Override
    public List<Bili> getRand(int limit) {

        if(limit>10)
            return new ArrayList<Bili>();
        return biliManger.getUserRandByLimit(limit);
    }
}
