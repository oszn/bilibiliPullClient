package com.myLogger.tools;


import com.myLogger.dao.entry.colunm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Component
public class initClass {
    @Autowired
    colunm cmapper;

    public List<HashMap> get(String table){
        List<HashMap> c=cmapper.getMap(table);
//        return c;
        return c;
    }

}
