<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>文件下载</title>
</head>
<body>
<h1>测试文件下载</h1>
<a href="${pageContext.request.contextPath}/file/download?fileName=HELP.md">HELP.md</a>
<a href="${pageContext.request.contextPath}/file/download?fileName=img.png">img.png</a>
<a href="${pageContext.request.contextPath}/file/download?fileName=readme.txt">readme.txt</a>
<a href="${pageContext.request.contextPath}/file/download?fileName=项目介绍.md">项目介绍.md</a>


</body>
</html>