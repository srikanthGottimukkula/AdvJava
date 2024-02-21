package callablestatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcdedureIN {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String PROCEDURE_SQL = "CALL GETBOOKBYID(?)";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Book_id:");
		int book_id = sc.nextInt();
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		CallableStatement cstmt = con.prepareCall(PROCEDURE_SQL);
		cstmt.setInt(1, book_id);
		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getDouble(3));
		}
		con.close();
	}
}
