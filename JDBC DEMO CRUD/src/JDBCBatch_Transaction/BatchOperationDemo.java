package JDBCBatch_Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Using Batch Operation !! -->only non-select queries.
public class BatchOperationDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO BOOKS VALUES(103,'CPROGRAM',7000.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(104,'OOPS',4000.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(103,'.NET',2000.00)");

		int[] count = stmt.executeBatch();

		for (int i : count) {
			System.out.println(count.length );
		}
		con.close();

	}
}
