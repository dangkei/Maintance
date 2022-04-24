package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsConsumer {
	public static final String ACTIVEMQ_URL = "tcp://10.192.15.125:6166/";
    public static final String QUEUE_NAME = "jdbc01";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

	}

}
