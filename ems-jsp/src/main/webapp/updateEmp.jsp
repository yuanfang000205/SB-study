<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css" />
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
						更新员工信息:
					</h1>
					<form action="" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left" >
									<input value="1" name="id" readonly />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="张三"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="2300"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									bir:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="bir" value="2012/12/12"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sex:
								</td>
								<td valign="middle" align="left">
									<select name="sex">
										<option value="true">男</option>
										<option value="false">女</option>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>update Emp</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
				更新员工信息:
			</h1>
			<form action="${pageContext.request.contextPath}/employee/update" method="post">
				<table cellpadding="0" cellspacing="0" border="0"
					   class="form_table">
					<tr>
						<td valign="middle" align="right">
							id:
						</td>
						<td valign="middle" align="left" >
							<input value="${employee.id}" name="id" readonly />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							name:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="name" value="${employee.name}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							salary:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="salary" value="${employee.salary}"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							bir:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="birthday" value="<fmt:formatDate value="${employee.birthday}" pattern="yyyy/MM/dd"/>"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							sex:
						</td>
						<td valign="middle" align="left">
							<select name="gender">

								<option value="1"
										<c:if test="${employee.gender}">
											selected
										</c:if>
								>男</option>

								<option value="0"
										<c:if test="${!employee.gender}">
											selected
										</c:if>
								>女</option>

							</select>
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="Confirm" />
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
>>>>>>> e615503... 用户登录、查询员工列表以及添加和更新员工信息
>>>>>>> 84c9a3e... 用户登录、添加和更新以及查询员工信息
>>>>>>> 9044dc1... 用户登录、添加和更新以及查询员工信息
</html>
