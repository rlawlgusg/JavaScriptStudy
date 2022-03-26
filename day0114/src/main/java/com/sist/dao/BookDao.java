package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;
import com.sist.vo.OrderBookInfo;

public class BookDao {
	
	public ArrayList<OrderBookInfo> listOrderBook(int custid){
		ArrayList<OrderBookInfo> list = new ArrayList<OrderBookInfo>();
		String sql = "select b.bookid, bookname, publisher, orderdate, price, saleprice from book b, customer c, orders o where b.bookid = o.bookid and c.custid = o.custid and c.custid = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new OrderBookInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	
	public ArrayList listBookByPublisher(String publisher) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try {
			String sql = "select * from book where publisher =?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}		
		return list;
	};
	
	
	
	
	public BookVO getBook(int bookid) {
		BookVO b = null;
		//ArrayList<BookVO> list = new ArrayList<BookVO>();
		try {
			String sql = "select * from book where bookid =?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				b = new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}		
		//return list;
		return b;
	};
		
	public int getPrice(String bookname,String publisher) {
		int price = 0;
		String sql = "select price from book where bookname = ? and publisher = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			pstmt.setString(2, publisher);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				price = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return price;
	}
}
