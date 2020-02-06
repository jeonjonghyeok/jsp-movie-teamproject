<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="include/header.jspf" %> 

<script>
	alert("${param.name}님, 회원 가입에 성공했습니다.");
	history.go(-2);
</script>