<%@page import="com.sist.dao.bookDao"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	

	String bookname = request.getParameter("bookname");
	String publisher = request.getParameter("publisher");
	
	bookDao dao = new bookDao();
	int price = dao.getPrice(bookname, publisher);
%>
<%=price%>