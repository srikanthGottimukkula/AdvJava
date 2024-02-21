package com.srikanth.gmk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;

	public static Connection getConnection() throws IOException, SQLException {

		if (ds == null) {
			FileInputStream fis = new FileInputStream(new File(
					"D:\\Full Stack Developer\\Backend\\PracticeIT\\AdJava\\TomServlet\\src\\main\\java\\db.properties"));

			Properties p = new Properties();
			p.load(fis);

			String url = p.getProperty("db.url");
			String driver = p.getProperty("db.driver");
			String uname = p.getProperty("db.username");
			String pwd = p.getProperty("db.password");

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setDriverClassName(driver);

			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}
}
