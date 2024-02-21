package jdbc_prepareStatments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TaskDemoBooksPrice {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Price::");
		double price = sc.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		StringBuilder sql = new StringBuilder("SELECT * FROM BOOKS ");
		if (price > 0) {
			sql.append("WHERE book_price <=?");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		if (price > 0) {
			pstmt.setDouble(1, price); //1 means one ? positional parameter
		}

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getDouble(3));
		}

		con.close();

	}
}
