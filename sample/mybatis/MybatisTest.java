package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import domain.Blog;
import factory.BlogDataSourceFactory;
import mybatis.mapper.BlogMapper;

public class MybatisTest {

	private static SqlSessionFactory sqlSessionFactory1 = null;
	private static SqlSessionFactory sqlSessionFactory2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sqlSessionFactory1 = getSessionFactory();
		//sqlSessionFactory2 = getSessionFactoryBySxml();
		return;
	}

	static Blog getBlog() {
		try (SqlSession session = sqlSessionFactory1.openSession()) {
			BlogMapper mapper = getSqlSession().getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlog(1);
			return blog;
			}catch(Exception e) {
				e.getStackTrace();
			}
		return null;
	}
	
	static SqlSession getSqlSession() {
		try (SqlSession session = sqlSessionFactory2.openSession()) {
			  Blog blog = (Blog) session.selectOne("mybatis.mapper.BlogMapper.selectBlog", 1);
			  return session;
			}catch(Exception e) {
				e.getStackTrace();
			}
		return null;
	}
	
	
	
	static SqlSessionFactory getSessionFactory() {
		//DataSource dataSource = BlogDataSourceFactory.getBaseDataSource();
		//实现了DataSource接口的类 C3P0/ DBCP /druid
		DataSource dataSource = BlogDataSourceFactory.getDataSourceByConfig();
		//实现了TransationFactory接口的类 需要是用匹配DataSource的类
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//mybatis-config.xml里的Environment配置
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//mybatis-config.xml里的Configuration配置
		Configuration configuration = new Configuration(environment);
		//向配置中添加mapper对象
		//configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		
		return sqlSessionFactory;
	}

	static SqlSessionFactory getSessionFactoryBySxml() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream reader = null;
		try {
			reader = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//直接创建SqlSessionFactory对象多个环境使用默认环境配置
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过环境名称创建SqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
		SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(reader,"db1");
		SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(reader,"db2");
		//通过环境名称喝属性创建SqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development",prop);
		return sqlSessionFactory;
	}

}
