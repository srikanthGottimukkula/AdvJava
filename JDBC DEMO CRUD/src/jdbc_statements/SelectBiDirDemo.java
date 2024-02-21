package jdbc_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBiDirDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SELECT_SQL = "SELECT * FROM BOOKS";
	
	public static void main(String[] args) throws Exception{

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
//		Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		
		rs.absolute(2);
//		rs.updateDouble(3, 1500.00);
//		rs.updateRow();
//		rs.deleteRow();

		if(rs.next()) {
	System.out.println(rs.getInt(1)+"__"+rs.getString(2)+"__"+rs.getDouble(3));
		}	
		//if means single value getting output
		//while means multiple records getting output.
		
		
		con.close();
	}
}
