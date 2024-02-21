package Asignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//program: to find different locations in same column use IN clause

public class AM2 {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SQL = "SELECT * FROM EMPLOYEE WHERE WORK_LOCATION IN ('PUNE','WARANGAL')";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getInt(3) + "_" + rs.getString(4) + "_"
					+ rs.getString(5) + "_" + rs.getString(6));
		}
		con.close();
	}
}
