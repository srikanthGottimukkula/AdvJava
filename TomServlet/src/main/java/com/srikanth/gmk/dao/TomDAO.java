package com.srikanth.gmk.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srikanth.gmk.dto.TomDTO;
import com.srikanth.gmk.util.ConnectionFactory;

public class TomDAO {

	private static final String INSERT_SQL = "INSERT INTO TOM VALUES(?,?)";

	public boolean saveTom(TomDTO dto) throws IOException, SQLException {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

		pstmt.setInt(1, dto.getId());
		pstmt.setString(2, dto.getName());

		int count = pstmt.executeUpdate();
		con.close();
		return count > 0;
	}

}
