<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
\
<%
	session.invalidate();
%>

<%@ include file="include/header.jspf" %> 

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>All In Movie</title>

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/template/img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="${pageContext.request.contextPath}/template/style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="${pageContext.request.contextPath}/template/css/responsive/responsive.css" rel="stylesheet">

</head>

<body class="hold-transition login-page">
<div class="col-3 col-md-3 col-lg-3">
<div class="login-page">
<div class="logo_area text-center">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index.html"><b></b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
  
    <c:choose>
		<c:when test="${errors.idOrPwNotMatch}">
		 <p class="login-box-msg">아이디와 암호가 일치하지 않습니다.</p>
		</c:when>
		<c:otherwise>
		 <p class="login-box-msg">로그인 정보를 입력하세요.</p>
		</c:otherwise>
	</c:choose>
    
    <form action="login.do" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="id" class="form-control" placeholder="아이디">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="비밀번호">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>
        </div>
        
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
        Google+</a>
    </div>
    <!-- /.social-auth-links -->

    <a href="#">I forgot my password</a><br>
    <a href="join.do" class="text-center">신규 가입</a>

  </div>
  </div>
  <!-- /.login-box-body -->
</div>
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<div class="social_icon_area clearfix">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="footer-social-area d-flex">
					<div class="single-icon">
						<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i><span>facebook</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i><span>Twitter</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i><span>GOOGLE+</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-linkedin-square"
							aria-hidden="true"></i><span>linkedin</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-instagram" aria-hidden="true"></i><span>Instagram</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-vimeo" aria-hidden="true"></i><span>VIMEO</span></a>
					</div>
					<div class="single-icon">
						<a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i><span>YOUTUBE</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<footer class="footer_area">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="footer-content">
					<!-- Logo Area Start -->
					<div class="footer-logo-area text-center">
						<a href="index.do" class="yummy-logo">All In Movie</a>
					</div>
					<!-- Menu Area Start -->
					<nav class="navbar navbar-expand-lg">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#yummyfood-footer-nav"
							aria-controls="yummyfood-footer-nav" aria-expanded="false"
							aria-label="Toggle navigation">
							<i class="fa fa-bars" aria-hidden="true"></i> Menu
						</button>
						<!-- Menu Area Start -->
						<div class="collapse navbar-collapse justify-content-center"
							id="yummyfood-footer-nav">
							<ul class="navbar-nav">
								<li class="nav-item active"><a class="nav-link" href="#">Home
										<span class="sr-only">(current)</span>
								</a></li>
								<li class="nav-item"><a class="nav-link" href="#">Features</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Categories</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Archive</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">About</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Contact</a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<!-- Copywrite Text -->
				<div class="copy_right_text text-center">
					<p>
						Copyright @2018 All rights reserved | This template is made with <i
							class="fa fa-heart-o" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>

<!-- ****** Footer Menu Area End ****** -->

<!-- Jquery-2.2.4 js -->
<script
	src="${pageContext.request.contextPath}/template/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script
	src="${pageContext.request.contextPath}/template/js/bootstrap/popper.min.js"></script>
<!-- Bootstrap-4 js -->
<script
	src="${pageContext.request.contextPath}/template/js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins JS -->
<script
	src="${pageContext.request.contextPath}/template/js/others/plugins.js"></script>
<!-- Active JS -->
<script src="${pageContext.request.contextPath}/template/js/active.js"></script>
</body>

</html>

