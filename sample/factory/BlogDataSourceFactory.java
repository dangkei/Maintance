package factory;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BlogDataSourceFactory {

	Connection conn = null;
	// dbcp连接池
	private static DataSource dataSource = null;
	private static BasicDataSource baseDataSource = null;
	//C3P0连接池
	private static ComboPooledDataSource c3p0DataSource = null;

	/*
	 * 读取xml配置的方式获取C3P0连接池
	 */
	public static DataSource getC3P0DataSourceByXml() {
		if (null != c3p0DataSource) {
			return c3p0DataSource;
		}
		c3p0DataSource = new ComboPooledDataSource();// 使用默认的配置

		// 获取连接
		Connection con;
		try {
			con = c3p0DataSource.getConnection();
			// 执行更新
			con.prepareStatement("select * from blog where id=5").executeUpdate();
			// 关闭
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c3p0DataSource;
	}

	/*
	 * 硬编码获取，使用C3P0连接池管理
	 */

	public static DataSource getC3P0DataSource() {
		if (null != c3p0DataSource) {
			return c3p0DataSource;
		}
		c3p0DataSource = new ComboPooledDataSource();
		// 设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
		c3p0DataSource.setJdbcUrl("jdbc:mysql://localhost:3306/blog");
		try {
			c3p0DataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c3p0DataSource.setUser("root");
		c3p0DataSource.setPassword("root");
		c3p0DataSource.setInitialPoolSize(3);
		c3p0DataSource.setMaxPoolSize(6);
		c3p0DataSource.setMaxIdleTime(1000);

		// ---> 从连接池对象中，获取连接对象
		Connection con;
		try {
			con = c3p0DataSource.getConnection();
			// 连接测试
			con.prepareStatement("select * from blog where id=7").executeQuery();
			// 关闭
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c3p0DataSource;
	}

	/*
	 * 从配置文件读取数据库连接池
	 */
	public static DataSource getDataSourceByConfig() {
		// 加载prop配置文件

		if (null != dataSource) {
			return dataSource;
		}

		Properties prop = new Properties();
		// 获取文件流
		InputStream inStream = BlogDataSourceFactory.class.getResourceAsStream("db.properties");
		// 加载属性配置文件
		try {
			prop.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 根据prop配置，直接创建数据源对象
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
			Connection con = dataSource.getConnection();
			con.prepareStatement("select * from blog where id=4").executeQuery();
			// 关闭
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取连接

		return dataSource;
	}

	static InputStream getResourceAsStream(String filePath) {
		try {
			return new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * 硬编码直接连接数据库池
	 */
	public static DataSource getBaseDataSource() {
		if (null != baseDataSource) {
			return baseDataSource;
		}
		baseDataSource = new BasicDataSource();
		baseDataSource.setUrl("jdbc:mysql://localhost:3306/blog"); // 数据库连接字符串
		baseDataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 数据库驱动
		baseDataSource.setUsername("root"); // 数据库连接用户
		baseDataSource.setPassword("123456"); // 数据库连接密码
		baseDataSource.setInitialSize(3); // 初始化连接
		baseDataSource.setMaxActive(6); // 最大连接
		// 获取连接
		Connection con;
		try {
			con = baseDataSource.getConnection();
			con.prepareStatement("select * from blog where id=3").executeQuery();
			// 关闭
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return baseDataSource;
	}

	/* DriverManager类实现JDBC连接 */
	public void DriverManager(String url, String user, String password) {
		Statement stmt = null;
		Connection conn = null;
		try {
			// 1.驱动注册程序 --内部执行了RegisterDriver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.获取连接对象
			conn = DriverManager.getConnection(url, user, password);

			// 3.创建Statement
			stmt = conn.createStatement();

			// 4.准备sql
			String sql = "CREATE TABLE student(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),gender VARCHAR(2))";

			// 5.发送sql语句，执行sql语句,得到返回结果
			int count = stmt.executeUpdate(sql);

			// 6.输出
			System.out.println("影响了" + count + "行！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 7.关闭连接(顺序:后打开的先关闭)
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
		}
	}

}
