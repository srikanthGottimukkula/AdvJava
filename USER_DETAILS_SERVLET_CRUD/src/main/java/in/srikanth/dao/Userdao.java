package in.srikanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.srikanth.dto.UserDTO;
import in.srikanth.util.ConnectionFactory;

public class Userdao {


	// save operation
	public boolean saveUser(UserDTO dto) throws Exception {
		
		String INSERT_SQL = "insert into user_dlts(user_name,user_email,user_phno) values(?,?,?)";
		boolean isSaved = false;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setString(1, dto.getUserName());
		pstmt.setString(2, dto.getUserEmail());
		pstmt.setInt(3, dto.getUserPhno());

		int count = pstmt.executeUpdate();

		if (count > 0) {
			isSaved = true;
		} else {
			isSaved = false;
		}
		return isSaved;
	}

	// get Operation
	public List<UserDTO> getUsers() throws Exception {

		String SELECT_SQL = "SELECT * FROM user_dlts";
		List<UserDTO> users = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		while (rs.next()) {
			UserDTO user = new UserDTO();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserPhno(rs.getInt("user_phno"));

			users.add(user);
		}
		return users;

	}
	
	//update operation
	public boolean updateUser(UserDTO dto) throws Exception {
		String UPDATE_SQL="UPDATE user_dlts SET user_name=?, user_email=?, user_phno=? WHERE user_id=?";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL);
		pstmt.setInt(1, dto.getUserId());
		pstmt.setString(2, dto.getUserName());
		pstmt.setString(3, dto.getUserEmail());
		pstmt.setInt(4, dto.getUserPhno());		
		boolean count = pstmt.executeUpdate()>0;
		return count;
	}

}
