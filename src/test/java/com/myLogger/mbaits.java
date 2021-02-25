package com.myLogger;

import com.myLogger.tools.initClass;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan({"com.myLogger.dao.**"})
public class mbaits {
    @Test
    public void test(){
        initClass c=new initClass();
        c.get("bilibili");
}
}
