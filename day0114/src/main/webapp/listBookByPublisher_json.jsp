<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	//String publisher = "굿스포츠";
	BookDao dao = new BookDao();
	ArrayList<BookVO> list = dao.listBookByPublisher(publisher);
	
	String result = "[";
	for(int i=0;i<list.size();i++){
		BookVO b = list.get(i);
		result += "{\"bookid\":"+b.getBookid()+",\"bookname\":"+b.getBookname()+",\"publisher\":"+b.getPublisher()+",\"price\":"+b.getPrice()+"}";
		if(i != list.size()-1){
			result += ",";
		}
	}
	result += "]";	
%>
<%=result%>