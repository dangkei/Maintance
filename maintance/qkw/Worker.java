package qkw;

import java.sql.SQLException;

import com.drew.metadata.photoshop.PsdHeaderDescriptor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Worker {
   
    static PreparedStatement ps;
    static ResultSet rs;
    public Worker(){}
    
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		processGw();

	}
	
	public static void processGw() {
		final Connection conn ;
		try {
			conn = JDBCUtils.getConnection();  //创建连接
			ps =  (PreparedStatement) conn.prepareStatement(Command.GETGWGL);
			rs = (ResultSet) ps.executeQuery(Command.GETGWGL);
			int i = 0;
			while(rs.next()) {
				i++;
				System.out.println(String.valueOf(i)+"==>"+rs.getString("work_name"));
			}
			
			JDBCUtils.free(rs, ps, conn); //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
