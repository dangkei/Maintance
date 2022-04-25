package httpserver;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CustomizeHandler implements HttpHandler, ApplicationContextAware{

	@Override
	public void handle(HttpExchange arg0) throws IOException {
		// TODO Auto-generated method stub
		String res = "Welcome visit this server!";
		arg0.sendResponseHeaders(200,res.length());
		OutputStream os = arg0.getResponseBody();
		os.write(res.getBytes());
		os.close();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

}
