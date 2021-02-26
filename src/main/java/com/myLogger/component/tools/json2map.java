package com.myLogger.component.tools;

import com.alibaba.fastjson.JSONObject;
import com.myLogger.dao.entry.Bili;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class json2map {

    public final Logger logger= LoggerFactory.getLogger(this.getClass());

    public json2map(){

    }
    public String contact(String key){
        String str[]=key.split("_");
        String nas="";
        for(int i=0;i<str.length;i++) {
            if (i != 0)
                str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1, str[i].length()).toLowerCase();

            nas += str[i];
        }
//        return nas;
        return nas.substring(0,1).toLowerCase()+nas.substring(1,nas.length());
    }
    public void inrect(Bili bilibili,Map<String,Object> cmap){
        Class tclass=bilibili.getClass();
        Field[] fields=tclass.getDeclaredFields();
        for(Field field:fields){
            if(field.getName().equals("id")||field.getName().equals("insertDate")||field.getName().equals("mac"))
                continue;;
            try {
                field.setAccessible(true);
                field.set(bilibili,cmap.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public void loopJson(Object object,String prefix,Map<String,Object> cmap){
        if(object instanceof JSONObject) {
            JSONObject jsObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry : jsObject.entrySet()) {
                Object o = entry.getValue();

                String _prefix=prefix+"_"+entry.getKey();
                if (o instanceof String||o instanceof Integer||o==null) {
                    Object value=entry.getValue();
                    String key=contact(_prefix);
//                    System.out.println("key:" + contact(_prefix) + "，value:" + entry.getValue());
                    cmap.put(key,value==null?"":value);
                } else {
                    loopJson(o,_prefix,cmap);
                }
            }
        }
    }
    public Map<String,Object> init(String x,Bili bilibili){
        Map<String,Object> cmap=new HashMap<>();
        JSONObject j=JSONObject.parseObject(x);
        loopJson(j,"", cmap);

        logger.info("code:{},message:{},ttl:{}",cmap.get("code"),cmap.get("message"),cmap.get("ttl"));
        if((int)cmap.get("code")!=0&&!cmap.get("message").equals("0")){
            bilibili.setCode((int)cmap.get("code"));
            bilibili.setMessage((String) cmap.get("message"));
            return cmap;
        }
        inrect(bilibili,cmap);
        return cmap;
    }

    public static void main(String[] args) {
        json2map i=new json2map();
        Bili bili=new Bili();
        i.init("",bili);
    }
}
