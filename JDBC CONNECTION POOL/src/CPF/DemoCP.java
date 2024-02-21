package CPF;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DemoCP {

	public static void main(String[] args) throws Exception {

		File file = new File(
				"D:\\Full Stack Developer\\Backend\\PracticeIT\\AdJava\\JDBC CONNECTION POOL\\src\\db.properties");
		FileInputStream fis = new FileInputStream(file);

		Properties p = new Properties();
		p.load(fis);

		String name = p.getProperty("db.userName");
		String password = p.getProperty("db.password");
		System.out.println(name);
		System.out.println(password);

	}

}
