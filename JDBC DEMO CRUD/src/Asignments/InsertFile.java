package Asignments;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertFile {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String INSERT_SQL = "INSERT INTO USER values(?,?,?)";

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\Srikanth Gmk\\OneDrive\\Documents\\std.txt");
		FileInputStream fis = new FileInputStream(file);

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

		pstmt.setInt(1, 1);
		pstmt.setString(2, "srikanth_gmk");
		pstmt.setBinaryStream(3, fis);

		int count = pstmt.executeUpdate();

		if (count == 1) {
			System.out.println("Record is inserted!!");
		} else {
			System.out.println("Record is not inserted!!");
		}
		con.close();
	}
}
