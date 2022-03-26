<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.customerVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.customerDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	customerDAO dao = new customerDAO();
	ArrayList<customerVO> list = dao.getListCustomer();
	
	Gson gson = new Gson();
	String result = gson.toJson(list);
	
%>
<%=result%>