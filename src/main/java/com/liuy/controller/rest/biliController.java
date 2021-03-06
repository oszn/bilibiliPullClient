package com.liuy.controller.rest;

import com.liuy.controller.dto.BaseRsp;
import com.liuy.service.bili.BiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: biliController
 * @description: 展示哔哩哔哩数据。
 * @author: liuy
 * @create: 2021-03-06 11:00
 **/

@RestController
@RequestMapping("/bili")
public class biliController {
    @Autowired
    BiliService biliService;

    @GetMapping("/count")
    public BaseRsp getBiliMyCount(){
       return new BaseRsp(biliService.getCount());
    }
    @GetMapping("/rand")
    public BaseRsp getRandLimit(@RequestParam(value = "limit",required = false) int limit){
        return new BaseRsp(biliService.getRand(limit));
    }
}
