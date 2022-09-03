<%-- 
	이 주석은 사용자한테 안보여요 
--%>

<!--
	JSP(Java Server Page)
	- 자바 서버에서 만들어내는 페이지
	- language는 이 페이지 내부에서는 Java 언어를 사용할 언어 명시 (표시를 해야함, 어차피 Java 이외의 언어는 사용 불가)
	- contentType은 사용자(브라우저)가 받게 될 내용의 형태를 명시
		- text/html : 대분류는 text이고, 소분류가 html이라는 뜻 (MIME 타입)
	- charset은 사용자(브라우저)가 받게 될 유니코드의 인코딩 방식
	- pageEncoding은 서버에서 내부적으로 변환이 일어날 때 적용될 인코딩 방식
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>HelloJsp</h1>