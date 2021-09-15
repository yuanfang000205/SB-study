<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="./css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加员工信息:
					</h1>
<<<<<<< HEAD
					<form th:action="@{/emp/save}" method="post">
=======
<<<<<<< HEAD
					<form th:action="@{/emp/save}" method="post">
=======
<<<<<<< HEAD
					<form th:action="@{/emp/save}" method="post">
=======
					<form action="${pageContext.request.contextPath}/employee/add" method="post">
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									bir:
								</td>
								<td valign="middle" align="left">
<<<<<<< HEAD
									<input type="text" class="inputgri" name="bir" />
=======
<<<<<<< HEAD
									<input type="text" class="inputgri" name="bir" />
=======
<<<<<<< HEAD
									<input type="text" class="inputgri" name="bir" />
=======
									<input type="text" class="inputgri" name="birthday" />
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sex:
								</td>
								<td valign="middle" align="left">
<<<<<<< HEAD
									<select name="sex">
										<option value="true">男</option>
										<option value="false">女</option>
=======
<<<<<<< HEAD
									<select name="sex">
										<option value="true">男</option>
										<option value="false">女</option>
=======
<<<<<<< HEAD
									<select name="sex">
										<option value="true">男</option>
										<option value="false">女</option>
=======
									<select name="gender">
										<option value="1">男</option>
										<option value="0">女</option>
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
