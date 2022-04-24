package qkw;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

public class ConnectionPool {
	private final String url="jdbc:mysql://10.171.28.230:3307/"+"tzkw_oa_new"+"?useSSL=true&characterEncoding=utf-8";//mysql 连接串
    private final String user = "root"; //用户名
    private final String password = "admin"; //密码

    private static int initCount = 10; //初始化connection个数
    private static int maxCount = 20; //connection最大个数
    private static int currentCount = 0;
    
    
    private LinkedList<Connection> connectionPool = new LinkedList<>();

    //只让包内引用，下面会定义一个JDBCUtils去获取Connection连接
    protected ConnectionPool() {
        for(int i = 0; i < initCount; i++){
            try {
                this.connectionPool.addLast(this.createConnection());
                this.currentCount++;
            }catch (Exception e){
                throw new ExceptionInInitializerError(e);
            }
        }

    }

    private Connection createConnection1() throws SQLException{
        return (Connection) DriverManager.getConnection(this.url, this.user, this.password);
    }

    private Connection createConnection() throws SQLException{
        return (Connection) DriverManager.getConnection(this.url, this.user, this.password);
    }

    protected Connection getConnection() throws SQLException {
        synchronized(this.connectionPool){
            if(this.connectionPool.size() > 0){
                this.currentCount--;
                return this.connectionPool.removeFirst();
            }

            if(this.currentCount < this.maxCount){
                this.createConnection();
                this.currentCount++;
            }
            throw new SQLException("no connection");
        }
    }

    protected void free(Connection conn){
        synchronized (this.connectionPool){
            this.connectionPool.addLast(conn);
            this.currentCount++;
        }
    }
}
