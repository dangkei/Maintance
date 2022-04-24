package httpserver;

import org.springframework.beans.factory.annotation.Autowired;

public class TestServer {
	private int port;
	
	@Autowired
	public void start() {
		System.out.println("server is started!!");
	}
	
	public void stop() {
		System.out.println("server is stoped!!");
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
