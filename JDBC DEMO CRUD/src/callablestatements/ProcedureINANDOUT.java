package callablestatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureINANDOUT {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String PROCEDURE_SQL = "CALL getBookNameByPrice(?,?) ";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Book_price:");
		double bookPrice = sc.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		CallableStatement cstmt = con.prepareCall(PROCEDURE_SQL);
		cstmt.setDouble(1, bookPrice);
		cstmt.registerOutParameter(2, Types.VARCHAR);

		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}

		con.close();

	}
}
