<%@page import="com.sist.vo.customerVO"%>
<%@page import="com.sist.dao.customerDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String name = request.getParameter("name");
String address = request.getParameter("address");
String phone = request.getParameter("phone");
int custid = Integer.parseInt(request.getParameter("custid"));

customerVO c = new customerVO(custid,name,address,phone);
customerDAO dao = new customerDAO();
int re = dao.update(c);

%>
{"re:"<%=re%>}

