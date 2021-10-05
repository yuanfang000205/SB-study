package com.yuanfang;

import com.yuanfang.dao.UserDao;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName JasyptTests
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/10/5
 **/
@SpringBootTest
public class JasyptTests {

    private StringEncryptor stringEncryptor;

    @Autowired
    public JasyptTests(StringEncryptor stringEncryptor) {
        this.stringEncryptor = stringEncryptor;
    }

    @Test
    public void testSecret() {
        //加密
        String secret = stringEncryptor.encrypt("localhost");
        System.out.println(secret);
        //解密
        String decrypt = stringEncryptor.decrypt("zEcilX/9gieZ8iTcNfKwMA==");
        System.out.println(decrypt);
    }
}
