# SpringBoot中的文件上传与下载

## 文件上传

### 	第一种

   * Controller中进行如下编写

        * ```java
          /**
               * 测试文件上传
               * @param file 该文件名必须与form中对应file类型的name一致才行
               * @param request 用于获取真实路径
               * @return
               */
              @RequestMapping("upload")
              public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
                  String originalFilename = file.getOriginalFilename();
                
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
          ```
          

* 对应前台页面访问相关路径，相应webapp如下

     * 	![image-20210917120907843](https://stu-manager.oss-cn-beijing.aliyuncs.com/img/20210917120908.png)

* application.yml中配置上传文件大小以及服务器处理文件大小

     * ```xml
          spring:
            mvc:
              view:
                prefix: / #配置视图前缀
                suffix: .jsp #配置视图后缀
            servlet:
              multipart: #设置文件大小
                max-file-size: 120MB #上传文件最大限制
                max-request-size: 120MB #服务器处理文件最大限制
          ```

### 	第二种，推荐使用

* 同样在Controller层中编写代码

  * ```java
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
            log.debug("绝对路径：{}",realPath);
      
            //改名
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;
             //上传文件到哪
           file.transferTo(new File(realPath,newFileName));
       
           return  "redirect:/upload.jsp";
       }
     ```

* 对应页面修改访问路径即可

* 这里不需要配置文件大小限制，配置部署环境，本地或者服务器

  * 本地：

    ```yml
    # 指定文件上传位置
    file:
      upload:
        dir: C:\Users\WE\Desktop\本地上传文件夹 #指定本地测试上传目录
    ```

  * 服务器：

    ```yml
    # 指定文件上传位置
    file:
      upload:
        dir: /home/upload #指定本地测试上传目录
    ```

## 文件下载

* ```java
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
  ```

* 前台调用相应接口

* yml中配置下载地址

  * ```yml
    # 指定文件下载位置
      download:
        dir: C:\Users\WE\Desktop\download
    ```

    

