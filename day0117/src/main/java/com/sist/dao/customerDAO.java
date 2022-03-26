package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.customerVO;

public class customerDAO {

	public int insert(customerVO c) {
		int re = -1;
		String sql = "insert into customer values (?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getCustid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getAddress());
			pstmt.setString(4, c.getPhone());
			re = pstmt.executeUpdate();
			
			if(re == 1) {
				System.out.println("insert에 성공하였습니다");
			}else {
				System.out.println("insert에 실패하였습니다");
			}
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	public int update(customerVO c) {
		int re = -1;
		String sql = "update customer set name=?,address=?,phone=? where custid = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			pstmt.setInt(4, c.getCustid());
			re = pstmt.executeUpdate();
			
			if(re == 1) {
				System.out.println("update에 성공하였습니다");
			}else {
				System.out.println("update에 실패하였습니다");
			}
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}	
		return re;
	}
	
	public int delete(int custid) {
		int re = -1;
		String sql = "delete from customer where custid = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, custid);
			re = pstmt.executeUpdate();
			
			if(re == 1) {
				System.out.println("delete에 성공하였습니다");
			}else {
				System.out.println("delete에 실패하였습니다");
			}
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}	
		
		return re;
	}
	
	
	public ArrayList<customerVO> getListCustomer(){
		ArrayList<customerVO> list = new ArrayList<customerVO>();
		String sql = "select * from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new customerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}		
		return list;
	}
	
	
	
}
