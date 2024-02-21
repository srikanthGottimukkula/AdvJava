package jdbc_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class demoRefreshRow {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SELECT_SQL = "SELECT * FROM BOOKS";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println("column count:" + metaData.getColumnCount());
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			String columnName = metaData.getColumnName(i);
			System.out.println(columnName);
		}

		System.out.println("The query execution is completed .... data available!!");
		while (rs.next()) {
			System.in.read();
			System.in.read(); // when we enter any key then next record will display.
			rs.refreshRow(); // compare the row data with database if not matching give latest data.
			System.out.println(rs.getInt(1) + "__" + rs.getString(2) + "__" + rs.getDouble(3));

		}

	}
}
