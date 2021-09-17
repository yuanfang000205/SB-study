package com.yuanfang.controller;

import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
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
    private String uploadPath;

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
        log.debug("绝对路径：{}",uploadPath);

        //改名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;


        //上传文件到哪
        file.transferTo(new File(uploadPath,newFileName));

        return  "redirect:/upload.jsp";
    }

    @Value("${file.download.dir}")
    private String downloadPath;
    /**
     * 测试文件下载
     * @param fileName 下载的文件名
     * @param response 响应参数
     * @return
     */
    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        log.debug("当前下载文件名为：{}",fileName);
        log.debug("当前下载文件目录：{}",downloadPath);
        //1.去指定目录中读取文件
        File file = new File(downloadPath,fileName);
        //2.将文件读取为输入流
        FileInputStream is = new FileInputStream(file);
        //获取响应流之前设置以附件的形式下载
        response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.将输入流复制给输出流
        //定义数据缓冲
        //byte[] b = new byte[1024];
        ////读取数据长度
        //int len;
        //while (true){
        //    len = is.read(b);
        //    if (len == -1) {
        //        break;
        //    }
        //    os.write(b,0,len);
        //}
        ////5.释放资源
        //is.close();
        FileUtil.copyStream(is, os);
    }

}
