package jdbc_prepareStatments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class preparedStatemnetsDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SELECT_SQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		PreparedStatement pstmt = con.prepareStatement(SELECT_SQL);
		pstmt.setInt(1, 104);
		pstmt.setString(2, "Oracle");
		pstmt.setDouble(3, 5900);
		int count = pstmt.executeUpdate();
		System.out.println("Rows Effected ::" + count);
		con.close();
	}
}
