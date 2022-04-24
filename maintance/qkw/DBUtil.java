package qkw;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DBUtil {
    private String username = "root";
    private String password = "admin";
    private String driver = "com.mysql.jdbc.Driver";

    private String url="jdbc:mysql://10.171.28.230:3307/+"+"tzkw_oa_new"+"+?useSSL=true&characterEncoding=utf-8";
    /**
     * 1. 实现数据库连接的方法
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driver);

            conn = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("连接数据库成功.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 2. 释放数据库连接
     */
    public void closeConn(ResultSet rs, PreparedStatement pstm, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
