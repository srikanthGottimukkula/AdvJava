package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";
	private static final String INSERT_SQL = "INSERT INTO BOOKS values(102,'postman',500)";

	public static void main(String[] args) throws Exception {

		// Step-1: Load Driver.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step-2: Get DB Connection.
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		// Step-3: Create Connection.
		Statement stmt = con.createStatement();

		// Step-4: Execute Query
		int rowsEffected = stmt.executeUpdate(INSERT_SQL);

		// Step-5: Process Result
		System.out.println("Rows Effected form the database!! " + rowsEffected);

		// Step-6: Close Connection
		con.close();
	}

}
