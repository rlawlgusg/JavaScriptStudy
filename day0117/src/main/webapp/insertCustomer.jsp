<%@page import="com.sist.dao.customerDAO"%>
<%@page import="com.sist.vo.customerVO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt(request.getParameter("custid"));
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	
	customerVO c = new customerVO(custid,name,address,phone);
	customerDAO dao = new customerDAO();
	int re = dao.insert(c);

%>
{"re:"<%=re%>}