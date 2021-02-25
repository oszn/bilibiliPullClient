package com.myLogger.controller;

import com.myLogger.http.walkMilk;
import com.myLogger.tools.initClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class test {
    @Autowired
    initClass c;
    @Autowired
    walkMilk w;
    @RequestMapping("/hello")
    public String getx(@RequestParam("uid")String uid){
//        try {
//            w.insert(uid);
//        }catch (Exception e){
//            return "error";
//        }
        w.insert(uid);
        return "success";
    }
}
