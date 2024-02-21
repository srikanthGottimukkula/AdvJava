package CPF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource dataSource = null;

	static {
		try {
			File file = new File("D:\\Full Stack Developer\\Backend\\PracticeIT\\AdJava\\CPDEMO\\src\\db.properties");

			FileInputStream fis = new FileInputStream(file);

			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("db.url");
			String uname = p.getProperty("db.uname");
			String password = p.getProperty("db.password");
			String poolSize = p.getProperty("db.poolSize");

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(password);
			config.setMaximumPoolSize(Integer.parseInt(poolSize));

			dataSource = new HikariDataSource(config);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getDBConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
