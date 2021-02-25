package com.myLogger.component.HbaseConfig;

import org.apache.hadoop.hbase.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HBaseLog extends HbaseLogTemplate {
    @Autowired
    Connection connection;
    @Autowired
    HbaseTemplate template;
    @PostConstruct
    public void init(){
        super.setConnection (connection);
        super.setHbaseTemplate (hbaseTemplate);
    }

}
