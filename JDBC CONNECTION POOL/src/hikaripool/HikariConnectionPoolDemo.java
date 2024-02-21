package hikaripool;

import java.sql.Connection;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionPoolDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Srigmk@28";

	public static void main(String[] args) throws Exception {

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(4);

		HikariDataSource datasource = new HikariDataSource(config);
		Connection con = datasource.getConnection();
		String sql = "INSERT INTO BOOKS VALUES (200,'SpringBatch',1000.00)";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("Record is inserted !!");
		con.close();

	}
}
