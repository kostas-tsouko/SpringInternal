<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--
<!DOCTYPE html>
<html class="log">

<head>

  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>-->

<!--  <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">-->
<!--
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>


	<h2 id="login">Login</h2>
<div class="form-group">
	


   
	<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
	
	<div class="field"  >


			<label class="form-label">User Id</label> 
			<input type="text" name="username"/>
		
			<label class="form-label">Password</label> 
			<input type="password" name="password"/>
			<div style="padding:10px;">
			<button class="btn btn-primary" type="submit" >Login</button>
			</div>
			</div>
			</div>
			
		<c:if test="${param.error != null}">
		<!-- 
					<p>Sorry! Invalid username/password!</p>
		 -->
<!--	<p> <font color="red">Sorry! Invalid username/password!</font> </p>
			<p> <font color="red">If you are sure your entered credits are valid, you may be not allowed to make a job application form yet</font> </p>
			
		</c:if>
			
	</form:form>


	
</div>
</div>

</body>
</html>-->


<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V6</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<!--===============================================================================================-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/util.css" />
<!--===============================================================================================-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/main.js" />
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form:form class="login100-form validate-form"
					action="${pageContext.request.contextPath}/authUser" method="POST">
					<!--<form class="login100-form validate-form">-->
					<span class="login100-form-title p-b-70"> Welcome </span>
					<span class="login100-form-avatar"> <img
						src="https://eduguidegr.s3.amazonaws.com/filer_public_thumbnails/filer_public/2014/07/12/hua1.gif__200x200_q75_background-%23fff_subsampling-2.jpg"
						alt="AVATAR">
					</span>

					<div class="wrap-input100 validate-input m-t-85 m-b-35"
						data-validate="Enter username">
						<input class="input100" type="text" name="username" /> <span
							class="focus-input100" data-placeholder="Username"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Enter password">
						<input class="input100" type="password" name="password" /> <span
							class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
				
						<button class="login100-form-btn" type="submit">Login</button>
					</div>

						<c:if test="${param.error != null}">

					
	
	<p style="color:red; padding: 30px; font-size:120%;"> Wrong Username/Password ! </p>

			
		</c:if>
					
					
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>


