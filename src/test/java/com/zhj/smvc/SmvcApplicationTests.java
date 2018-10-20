package com.zhj.smvc;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmvcApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("90041225");
        System.out.println(result);
    }

}
