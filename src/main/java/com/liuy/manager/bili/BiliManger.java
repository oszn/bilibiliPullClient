package com.liuy.manager.bili;

import com.liuy.dao.entry.Bili;
import com.liuy.dao.entry.BiliExample;
import com.liuy.dao.mapper.BiliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @className: BiliManger
 * @description: 操作数据层的
 * @author: liuy
 * @create: 2021-03-06 11:04
 **/

@Component
public class BiliManger {
    @Autowired
    BiliMapper biliMapper;
    public int countByExample(BiliExample example){
        return (int) biliMapper.countByExample(example);
    }
    public List<Bili> getUserRandByLimit(int limit){
        Random r=new Random();
        int uid=r.nextInt(countByExample(new BiliExample()));
        return biliMapper.getUserRandByLimit(uid,limit);
    }
}
