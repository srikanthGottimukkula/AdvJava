package jdbc_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class absoulte {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SELECT_SQL = "SELECT * FROM BOOKS";
	
	public static void main(String[] args) throws Exception{

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		
		rs.absolute(2);
		
		System.out.println("this is second record!!");
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getDouble(3));
		System.out.println("previous Record!!");
		rs.previous();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getDouble(3));

		
		
	}
}
