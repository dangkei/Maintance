package qkw;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class JDBCUtils {
	private static ConnectionPool dataSource = null;
    private final static String driver = "com.mysql.jdbc.Driver";//jdbc driver name

    static {
        try {
            Class.forName(driver);
            dataSource = new ConnectionPool();
        }catch (ClassNotFoundException e){
            throw new ExceptionInInitializerError(e);
        }
    }

    //对外提供的获取连接的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //对外提供的释放连接的方法
    public static void free(ResultSet rs, Statement st, Connection conn) throws SQLException {
        if(rs != null){
            rs.close();
        }

        if(st != null){
            st.close();
        }

        dataSource.free(conn);
    }
}
