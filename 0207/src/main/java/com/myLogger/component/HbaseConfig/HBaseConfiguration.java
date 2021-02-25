package com.myLogger.component.HbaseConfig;


import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.ipc.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.apache.hadoop.hbase.client.Connection;
import java.io.IOException;

@Configuration
public class HBaseConfiguration {

    @Value("${hbase.zookeeper.quorum}")
    private String zookeeperQuorum;

    @Value("${hbase.zookeeper.property.clientPort}")
    private String clientPort;

    @Value("${zookeeper.znode.parent}")
    private String znodeParent;

    @Bean
    public HbaseTemplate hbaseTemplate() {
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hbase.zookeeper.quorum", zookeeperQuorum);
        conf.set("hbase.zookeeper.property.clientPort", clientPort);
        conf.set("zookeeper.znode.parent", znodeParent);
        return new HbaseTemplate(conf);
    }

    @Bean
    public Connection myfHbaseConnection(){
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hbase.zookeeper.quorum", zookeeperQuorum);
        conf.set("hbase.zookeeper.property.clientPort", clientPort);
        conf.set("zookeeper.znode.parent", znodeParent);
        conf.set("zookeeper.sasl.client", "false");//-------暂时保留不清楚用处
        try {
            return ConnectionFactory.createConnection(conf);
        } catch (IOException e) {

            System.out.println("------Hbase初始化失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


}