package redis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.assoft.asopUtil.common.tool.util.jedis.RedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 政府办移动端签批统计
 * @author zhangmengqi
 *
 */
public class AsopdcTest {

	// *****************需要修改的参数 start********************************************
	private static String startDate ="20210701";
	private static String endDate ="20210731";
	private static String filePath ="e://doc/移动端签批统计"+startDate+"-"+endDate+".xls";
	// *****************需要修改的参数 end********************************************
	
	
	private static String startTime =startDate+"000000";
	private static String endTime =endDate+"240000";

	private static String[] recvAccout = {"zl","lgm","yangbo","wangyanshi","zh","zyj","dmh","sgb","ndc","ljf","lw","yl","zhuzhigao","weiguo","zhangyang","wangchunhua","maqin","huchengping","zhangyuanyue","gaofudong","gaoqingping"};
	private static String[] recvAccoutName = {"赵磊","刘贵明","阳波","王岩石","郑皓","朱益军","董明慧","苏国斌","倪德才","楼俊峰","林巍","杨磊","朱志高","魏国","张阳","王春华","马骎","胡成平","张远月","高福东","高清平"};
	
	static Connection conn=null;
	static Statement stmt =null;
	static ResultSet rs =null;
	
	public static void main(String[] args) throws SQLException, IOException {
		
		/*
		 
		 
		#已办公文
		SELECT receiveAccount,count(receiveAccount) FROM `dc_doc_approval` where modifyDate>'20210820000000' and modifyDate<'20210826240000' and opType= '2' group by receiveAccount order by receiveAccount;
		#已办会议
		SELECT receiveAccount,count(receiveAccount) FROM `dc_doc_approval` where modifyDate>'20210820000000' and modifyDate<'20210826240000' and opType= '6' group by receiveAccount order by receiveAccount;
		#已办简报
		SELECT receiveAccount,count(receiveAccount) FROM `dc_doc_pieces` where modifyDate>'20210820000000' and modifyDate<'20210826240000' and opType= '10' group by receiveAccount order by receiveAccount;

*/
		
		initConnect();
		String[] title = { "用户账号", "用户名称", "公文数量","会议数量","简报数量"};
		
		String[][] content = new String[recvAccout.length][title.length];
		
		for(int i=0;i<recvAccout.length; i++){
			content[i][0] = recvAccout[i];
			content[i][1] = recvAccoutName[i];
			
			//3.操作数据库，实现增删改查
			
			rs = stmt.executeQuery(buildDocSql( recvAccout[i]));
			//如果有数据，rs.next()返回true
			while(rs.next()){
				content[i][2] =String.valueOf(rs.getInt("count"));
			}
			
			rs = stmt.executeQuery(buildMeetingSql( recvAccout[i]));
			//如果有数据，rs.next()返回true
			while(rs.next()){
				content[i][3] =String.valueOf(rs.getInt("count"));
			}
			
			rs = stmt.executeQuery(buildBriefinggSql( recvAccout[i]));
			//如果有数据，rs.next()返回true
			while(rs.next()){
				content[i][4] =String.valueOf(rs.getInt("count"));
			}
			
		}
		closeConnect();
		// 创建HSSFWorkbook
		
		StringBuilder accouts = new StringBuilder("[");
		StringBuilder names = new StringBuilder("[");
		StringBuilder docs = new StringBuilder("[");
		StringBuilder meetings = new StringBuilder("[");
		StringBuilder briefings = new StringBuilder("[");
		
		for(int i=0;i<recvAccout.length;i++) {
			if(i==recvAccout.length-1) {
				accouts.append("'").append(content[i][0]).append("']");	
				names.append("'").append(content[i][1]).append("']");	
				docs.append("'").append(content[i][2]).append("']");	
				meetings.append("'").append(content[i][3]).append("']");	
				briefings.append("'").append(content[i][4]).append("']");	
			}else {
				accouts.append("'").append(content[i][0]).append("',");	
				names.append("'").append(content[i][1]).append("',");	
				docs.append("'").append(content[i][2]).append("',");	
				meetings.append("'").append(content[i][3]).append("',");	
				briefings.append("'").append(content[i][4]).append("',");	
			}	
		}

		System.out.println(meetings.toString());
		Jedis jedis = null;
		initPool();
		
		jedis= pool.getResource();
		set("mobile:accouts",accouts.toString());
		set("mobile:names",names.toString());
		set("mobile:docs",docs.toString());
		set("mobile:meetings",meetings.toString());
		set("mobile:briefings",briefings.toString());
		
		pool.close();
	}
	

	private static String URL ="jdbc:mysql://192.12.200.123:3307/asopdc";
	private static String USER ="root";
	private static String PASSWORD ="P@ssw0rd";
	
	
	public static void initConnect(){
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2. 获得数据库连接
			conn =  DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnect(){
		if(null != rs){
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != stmt){
						
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					}
		if(null != conn){
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class ExcelUtil {
		
		 public boolean isUnique(String astr) {
		        boolean flag = true;
		        for(int i=0;i<astr.length();i++){
		            String temp = astr.substring(i,i+1);
		            String other = astr.substring(0,i)+astr.substring(i+1,astr.length());
		            if(other.indexOf(temp)>-1){
		                flag = false;
		                break;
		            }
		        }
		        return flag;
		    }
		
	   /**
	    * 导出Excel
	    * @param sheetName sheet名称
	    * @param title 标题
	    * @param values 内容
	    * @param wb HSSFWorkbook对象
	    * @return
	    */
	   public HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb){
	
	       // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
	       if(wb == null){
	           wb = new HSSFWorkbook();
	       }
	
	       // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
	       HSSFSheet sheet = wb.createSheet(sheetName);
	
	       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
	       HSSFRow row = sheet.createRow(0);
	
	       // 第四步，创建单元格，并设置值表头 设置表头居中
	       HSSFCellStyle style = wb.createCellStyle();
	       style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
	
	       //声明列对象
	       HSSFCell cell = null;
	
	       //创建标题
	       for(int i=0;i<title.length;i++){
	           cell = row.createCell(i);
	           cell.setCellValue(title[i]);
	           cell.setCellStyle(style);
	       }
	
	       //创建内容
	       for(int i=0;i<values.length;i++){
	           row = sheet.createRow(i + 1);
	           for(int j=0;j<values[i].length;j++){
	               //将内容按顺序赋给对应的列对象
	               row.createCell(j).setCellValue(values[i][j]);
	           }
	       }
	       return wb;
	   }
	}
	public static String buildDocSql(String receiveAccount){
		return "SELECT count(receiveAccount) count FROM `dc_doc_approval` "
				+ " where modifyDate>'"+startTime+"' "
						+ "and modifyDate<'"+endTime+"' "
								+ "and opType= '2' "
								+ "and receiveAccount= '"+receiveAccount+"' ";
	}
	public static String buildMeetingSql(String receiveAccount){
		return "SELECT count(receiveAccount) count FROM `dc_doc_approval` "
				+ " where modifyDate>'"+startTime+"' "
						+ "and modifyDate<'"+endTime+"' "
								+ "and opType= '6' "
								+ "and receiveAccount= '"+receiveAccount+"' ";
	}
	public static String buildBriefinggSql(String receiveAccount){
		return "SELECT count(receiveAccount) count FROM `dc_doc_pieces` "
				+ " where modifyDate>'"+startTime+"' "
						+ "and modifyDate<'"+endTime+"' "
								+ "and opType= '10' "
								+ "and receiveAccount= '"+receiveAccount+"' ";
	}
	
	
	
	private static int timeOut = 5000;
	private static int dataBase = 0;
	private static JedisPool pool = null;
	
	public static void initPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			config.setMaxIdle(1024);
			config.setMaxTotal(1024);
			config.setMinIdle(20);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(1000 * 10);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			/*
			 * String masterUrl = configMap.get("redis.host"); String masterPort
			 * = configMap.get("redis.port"); String password =
			 * configMap.get("redis.password");
			 */
	
			String masterUrl = "localhost";
			String masterPort = "6379";
			String password = "assoft";

			// System.out.println("masterUrl=" + masterUrl + "***masterPort=" +
			// masterPort + "****password=" + password);
			pool = new JedisPool(config, masterUrl,
					Integer.parseInt(masterPort), timeOut, password, dataBase);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	@SuppressWarnings("deprecation")
	public static void set(String key, String value) {
		//JedisPool pool = null;
		Jedis jedis = null;
		try {
			//pool = RedisUtil.getPool();
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			// 释放redis对象
			if (pool != null) {
				pool.returnBrokenResource(jedis);
			}
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}
	@SuppressWarnings("deprecation")
	public static void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null && pool != null) {
			pool.returnResource(redis);
		}
	}
	
}
