package CPF;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStore {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getDBConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "_" + rs.getString(2) + "_" + rs.getDouble(3));
		}
		rs.close();
		stmt.close();
		con.close();

	}
}

