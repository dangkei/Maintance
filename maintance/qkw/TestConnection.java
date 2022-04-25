package qkw;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class TestConnection {

//	    驱动类名
	    String driver="com.mysql.jdbc.Driver";
//	    URL格式,最后为数据库名
	    String url="jdbc:mysql://10.171.28.230:3307/tzkw_oa_new?useUnicode=true&characterEncoding=UTF8";  //JavaTest为你的数据库名称
	    String user="root";
	    String password="admin";
	    Connection  coon=null;
	    public TestConnection(){
	        try{
//	            加载驱动程序
	            Class.forName(driver);
	            coon=(Connection) DriverManager.getConnection(url,user,password);
	            if(!coon.isClosed()){
	                System.out.println("成功连接数据库！");
	            }
	        }catch (Exception e){
	                e.printStackTrace();
	            }
	    }
	    public void close(){
	        try{
	            this.coon.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
//	    增加数据
	    public void add(String name,int age,String gender){
//	        String sql="insert into usrInfo(username,gender,age) values(?,?,?)";　　//向usrInfo表中插入数据
	        String sql="insert into usrInfo(age,gender,username) values('"+age+"','"+gender+"','"+name+"')";
	        try{
	            PreparedStatement preStmt=(PreparedStatement)this.coon.prepareStatement(sql);
//	            preStmt.setString(1, name);
//	            preStmt.setInt(3, age);
//	            preStmt.setString(2, gender);　　//和上面的注释的一块组成另外一种插入方法
	            preStmt.executeUpdate();
	            System.out.println("插入数据成功！");
	            preStmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

//	    查询
	    public void select(){
	        String sql="select * from usrInfo";  //查询usrInfo表中的信息

	        try{
	            Statement stmt=(Statement)this.coon.createStatement();
	            ResultSet rs=(ResultSet)stmt.executeQuery(sql);   //得到的是结果的集合
	            System.out.println("--------------------------------");
	            System.out.println("姓名"+"\t"+"年龄"+"\t"+"性别");
	            System.out.println("--------------------------------");
	            while(rs.next()){
	                String name=rs.getString("username");
	                int age=rs.getInt("age");
	                String gender=rs.getString("gender");
	                System.out.println(name+"\t"+age+"\t"+gender);
	            }
	            stmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

//	    更改数据

	    public void update(String name,int age){
	        String sql="update usrInfo set age=? where username=?";   //推荐使用这种方式，下面的那种注释方式不知道为啥有时候不好使
//	        String sql="update usrInfo set age="+age+" where username='"+name+"'";
	        try{
	            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
	            prestmt.setInt(1, age);
	            prestmt.setString(2,name);
	            prestmt.executeUpdate();


//	            Statement stmt=(Statement)this.coon.createStatement();
//	            stmt.executeUpdate(sql);
	            System.out.println("更改数据成功！");
	            prestmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

//	    删除数据
	    public void del(String name){
	        String sql="delete from usrInfo where username=?";
	        try{
	            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
	            prestmt.setString(1, name);
	            prestmt.executeUpdate();
	            System.out.println("删除数据成功！");
	            prestmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

}
