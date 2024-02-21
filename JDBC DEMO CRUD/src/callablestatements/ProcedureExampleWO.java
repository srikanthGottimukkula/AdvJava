package callablestatements;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ProcedureExampleWO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String PROCEDURE_SQL = "CALL GETBOOKSDATA()";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		CallableStatement cstmt = con.prepareCall(PROCEDURE_SQL);
		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getDouble(3));
		}
		con.close();
	}
}
