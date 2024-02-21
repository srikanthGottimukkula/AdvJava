package CPF;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource dataSource = null;

	static {

		try {
			File file = new File(
					"D:\\Full Stack Developer\\Backend\\PracticeIT\\AdJava\\BookServlet\\src\\main\\java\\db.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties p = new Properties();
			p.load(fis);
			
			String url = p.getProperty("db.url");
			String name = p.getProperty("db.userName");
			String password = p.getProperty("db.password");
			String poolSize = p.getProperty("db.poolSize");

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(name);
			config.setPassword(password);
			config.setMaximumPoolSize(Integer.parseInt(poolSize));

			dataSource  = new HikariDataSource(config);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getDBConnection() throws Exception {
		return dataSource.getConnection();
	}

}
