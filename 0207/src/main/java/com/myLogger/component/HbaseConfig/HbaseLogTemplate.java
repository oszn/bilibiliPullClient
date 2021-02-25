package com.myLogger.component.HbaseConfig;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import java.io.IOException;

public class HbaseLogTemplate {
    public Connection getConnection() {
        return connection;
    }

    public void setConnection( Connection connection ) {
        this.connection = connection;
    }

    private Connection connection;
    public void insert_log(String info,String time,String user,String type){
//        hbaseTemplate.put ("BilibiliLog",);
        put (HbaseConst.Bilibili,user+type,HbaseConst.BibibiliLogFamily,HbaseConst.INFO,info);
        put (HbaseConst.Bilibili,user+type,HbaseConst.BibibiliLogFamily,HbaseConst.Time,time);
    }
    public void put(String tableName,String row,String columnFamily,String colunm,String value){
        TableName name=TableName.valueOf (tableName);
        try {
            Table table=connection.getTable (name);
            Put put=new Put (Bytes.toBytes (row));
            put.addColumn (Bytes.toBytes (columnFamily),Bytes.toBytes (colunm),Bytes.toBytes (value));
            table.put (put);
        } catch (IOException e) {
            System.out.println (e.toString ());
            e.printStackTrace ();
        }
    }

    public HbaseTemplate getHbaseTemplate() {
        return hbaseTemplate;
    }

    public void setHbaseTemplate( HbaseTemplate hbaseTemplate ) {
        this.hbaseTemplate = hbaseTemplate;
    }

    HbaseTemplate hbaseTemplate;
}
