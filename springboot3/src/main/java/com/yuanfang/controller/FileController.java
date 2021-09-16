package com.yuanfang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/16
 **/
@Controller
@RequestMapping("file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    /**
     * 测试文件上传
     * @param file 该文件名必须与form中对应file类型的name一致才行
     * @param request 用于获取真实路径
     * @return
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        log.debug("文件名：{}",originalFilename);
        log.debug("文件大小：{}",file.getSize());
        log.debug("文件类型：{}",file.getContentType());


        //1.根据相对路径获取服务器上的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        log.debug("绝对路径：{}",realPath);
        //2.文件上传至目录,参数一：文件目录；参数二：文件名称
        //修改文件名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;
        file.transferTo(new File(realPath,newFileName));


        return "redirect:/upload.jsp";
    }

    @Value("${file.upload.dir}")
    private String realPath;

    /**
     * 第二种文件上传
     * 注意: 这种方式适用于任何一种部署方式 推荐使用这种方式
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("uploadByJarDeploy")
    public String uploadByJarDeploy(MultipartFile file) throws IOException {
        //文件名
        String originalFilename = file.getOriginalFilename();
        log.debug("文件名: {}", originalFilename);
        log.debug("文件大小: {}", file.getSize());
        log.debug("文件类型: {}", file.getContentType());

        //改名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;


        //上传文件到哪
        file.transferTo(new File(realPath,newFileName));

        return  "redirect:/upload.jsp";
    }
}
