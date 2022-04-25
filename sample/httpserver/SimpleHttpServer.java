package httpserver;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
	private int port;	
	
	public SimpleHttpServer(int port) {
		this.port=port;
	}
	
	public static void main(String[] args) {
		new SimpleHttpServer(8000).start();
	}
	
	public void start(){
		System.out.println("server start");
			try {
				HttpServer server=null;
				server = HttpServer.create(new InetSocketAddress(port),0);
				server.createContext("/test",new CustomizeHandler());
				server.setExecutor(null);
				server.start();
				System.out.println("server started on port "+port);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public void stop() {
		/*
		 * if(server != null) { server.stop(100); }
		 */
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
