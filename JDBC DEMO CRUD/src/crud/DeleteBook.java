package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String DELETE_SQL = "DELETE FROM BOOKS WHERE BOOK_ID=103";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		Statement stmt = con.createStatement(); // ctrl+1+enter

		int rowsEffected = stmt.executeUpdate(DELETE_SQL);
		System.out.println("The row deleted!!" + rowsEffected);
		con.close();

	}

}
