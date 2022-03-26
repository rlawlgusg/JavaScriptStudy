<%@page import="com.sist.vo.customerVO"%>
<%@page import="com.sist.dao.customerDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt(request.getParameter("custid"));
	customerDAO dao = new customerDAO();
	int re = dao.delete(custid);
%>
{"re:"<%=re%>}