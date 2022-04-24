package httpserver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClassPathXmlApplicationContext("/spring/HttpServer.xml");
	}

}
