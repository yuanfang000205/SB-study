<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>文件上传</title>
</head>
<body>
<h1>测试文件上传</h1>

<form action="${pageContext.request.contextPath}/file/uploadByJarDeploy"
      method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="文件上传">
</form>

</body>
</html>