package activemq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProducer {
	public static final String ACTIVEMQ_URL = "tcp://10.192.15.125:61616/";
	// 目的地的名称
	public static final String QUEUE_NAME = "jdbc01";

	public static void main(String[] args) {
		// 1 按照给定的url创建连接工厂，这个构造器采用默认的用户名密码。该类的其他构造方法可以指定用户名和密码。
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工厂，获得连接 connection 并启动访问。
        Connection connection;
		try {
			connection = activeMQConnectionFactory.createConnection();
			connection.start();
	        // 3 创建会话session 。第一参数是是否开启事务， 第二参数是消息签收的方式
	        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
	        // 4 创建目的地（两种 ：队列/主题）。Destination是Queue和Topic的父类
	        Queue queue = session.createQueue(QUEUE_NAME);
	        // 5 创建消息的生产者
	        MessageProducer messageProducer = session.createProducer(queue);
	        // 6 通过messageProducer 生产 3 条 消息发送到消息队列中
	        for (int i = 1; i < 4 ; i++) {
	            // 7  创建消息
	            TextMessage textMessage = session.createTextMessage("msg--" + i);
	            // 8  通过messageProducer发送给mq
	            messageProducer.send(textMessage);
	        }
	        // 9 关闭资源
	        messageProducer.close();
	        session.close();
	        connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("  **** 消息发送到MQ完成 ****");

	}

	public static javax.jms.Connection getSession() {
		javax.jms.Connection connection = null;
		/*
		 * try { // 2 通过连接工厂，获得连接 connection 并启动访问。 connection =
		 * getConnectionFactory().createConnection(); connection.start(); } catch
		 * (JMSException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return connection;
	}

	/*
	 * static ActiveMQConnectionFactory getConnectionFactory() { // 1
	 * 按照给定的url创建连接工厂，这个构造器采用默认的用户名密码。该类的其他构造方法可以指定用户名和密码。 if (null ==
	 * activeMQConnectionFactory) { activeMQConnectionFactory = new
	 * ActiveMQConnectionFactory(ACTIVEMQ_URL); } return activeMQConnectionFactory;
	 * }
	 */

}
