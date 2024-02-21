package Asignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetreiveEmpData {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String DB_SELECT = "SELECT * FROM EMP e, EMPADDRESS a WHERE e.EMP_ID=a.EMP_ID AND e.EMP_ID=?";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Emp_Id");
		int empId = sc.nextInt();

		PreparedStatement pstmt = con.prepareStatement(DB_SELECT);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getDouble(3) + "_" + rs.getString(4)
					+ "_" + rs.getString(5) + "_" + rs.getString(6));
		}
		con.close();
	}
}
