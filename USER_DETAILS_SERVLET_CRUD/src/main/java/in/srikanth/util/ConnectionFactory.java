package in.srikanth.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;

	public static Connection getConnection() throws Exception {

		if (ds == null) {
			FileInputStream fis = new FileInputStream(new File(
					"D:\\Full Stack Developer\\Backend\\PracticeIT\\AdJava\\USER_DETAILS_SERVLET_CRUD\\src\\main\\java\\db.properties"));

			Properties p = new Properties();
			p.load(fis);

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(p.getProperty("db.url"));
			config.setDriverClassName(p.getProperty("db.driver"));
			config.setUsername(p.getProperty("db.username"));
			config.setPassword(p.getProperty("db.password"));
			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}
}
