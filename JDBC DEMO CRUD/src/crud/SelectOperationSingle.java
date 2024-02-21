package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectOperationSingle {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String SELECT_SQL = "SELECT * FROM BOOKS WHERE BOOK_ID=101";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		while (rs.next()) {
			int bookid = rs.getInt("BOOK_ID");
			String bookName = rs.getString("BOOK_NAME");
			double bookPrice = rs.getDouble("BOOK_PRICE");
			System.out.println(bookid + "--" + bookName + "--" + bookPrice);
		}
		con.close();
	}
}
