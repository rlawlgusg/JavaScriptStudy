package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.customerDAO;
import com.sist.vo.customerVO;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private customerDAO dao;
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
        super();
        dao = new customerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get방식의 요청입니다");
		ArrayList<customerVO> list = dao.getListCustomer();
		Gson gson = new Gson();
		
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(list));
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post방식의 요청입니다");
		request.setCharacterEncoding("utf-8");
		int custid = Integer.parseInt(request.getParameter("custid"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		customerVO c = new customerVO(custid, name, address, phone);
		int re = dao.insert(c);
		String result = "{\"re\":"+re+"}";
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
