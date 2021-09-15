package com.yuanfang.test;

import com.yuanfang.utils.VerifyCodeUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VerifyCodeTests {

    @Test
    public void testGenerate() throws IOException {
        String s = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println(s);
        //写入图片
        FileOutputStream os = new FileOutputStream(new File("F:\\SBProjects\\ems-jsp/aa.png"));
        VerifyCodeUtils.outputImage(220,80,os,s);

    }
}
