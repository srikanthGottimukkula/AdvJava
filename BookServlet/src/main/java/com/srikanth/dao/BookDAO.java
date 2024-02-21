package com.srikanth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.srikanth.dto.BookDTO;
import com.srikanth.util.ConnectionFactory;


public class BookDAO {

	private static final String INSERT_SQL ="INSERT INTO BOOKS VALUES(?,?,?)";
	
	public boolean saveBook(BookDTO dto ) throws Exception {
		
		Connection con =ConnectionFactory.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setInt(1, dto.getBookId());
		pstmt.setString(2, dto.getBookName());
		pstmt.setDouble(3, dto.getBookPrice());
		
		int count = pstmt.executeUpdate();
		
		con.close();
		return count>0;
		
	}
}
