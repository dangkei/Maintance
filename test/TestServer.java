

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TestServer {
	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8083);
		tomcat.addWebapp("/chapter", "D:\\workspace\\Tongzhou\\chapter\\files\\web");
		tomcat.addWebapp("/leave","D:\\workspace\\Tongzhou\\leave\\files\\web");
		tomcat.start();
		tomcat.getServer().await();
	}
}
