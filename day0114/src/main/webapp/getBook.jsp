<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	BookDao dao = new BookDao();
	BookVO b = dao.getBook(bookid);

%>
<%=b.getBookname()%>,<%=b.getPublisher()%>,<%=b.getPrice()%>