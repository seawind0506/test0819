/**
*
*
*/
package cn.wind.activemq;

import java.awt.font.TextMeasurer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * <p>Title:ActiveMQTest.java </p>
 * <p>Description: ActiveMQTest.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月8日上午10:21:57
 * @version 1.0
 */
public class ActiveMQTest {
	@Test
	public void testQueueProducer() throws JMSException{
		//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.160:61616");
		//第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		//第三步：开启连接，调用Connection对象的start方法。
		connection.start();
		//第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		//第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
		Queue queue = session.createQueue("lv-queue");
		//第六步：使用Session对象创建一个Producer对象。
		MessageProducer producer = session.createProducer(queue);
		//第七步：创建一个Message对象，创建一个TextMessage对象。
		TextMessage textMessage = session.createTextMessage("hello lvActiveMQ!!!");
		//第八步：使用Producer对象发送消息。
		producer.send(textMessage);
		//第九步：关闭资源。
		producer.close();
		session.close();
		connection.close();
		
	}
	
	@Test
	public void testQueueConsumer() throws Exception{
		//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.160:61616");
		//第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		//第三步：开启连接，调用Connection对象的start方法。
		connection.start();
		//第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		//第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
		Queue queue = session.createQueue("lv-queue");
		//第六步：使用Session对象创建一个Producer对象。
		MessageConsumer consumer = session.createConsumer(queue);
		//第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					//取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					System.out.println(text);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		//等待键盘输入
		System.in.read();

		//第八步：关闭资源。
		consumer.close();
		session.close();
		connection.close();
		
	}
	
	@Test
	public void testTopicProducer()throws Exception{
		//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.160:61616");
		//第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		//第三步：开启连接，调用Connection对象的start方法。
		connection.start();
		//第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		//第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
		Topic topic = session.createTopic("lv-topic");
		//第六步：使用Session对象创建一个Producer对象。
		MessageProducer producer = session.createProducer(topic);
		//第七步：创建一个Message对象，创建一个TextMessage对象。
		TextMessage textMessage = session.createTextMessage("hello lvActiveMQ!!!");
		//第八步：使用Producer对象发送消息。
		producer.send(textMessage);
		//第九步：关闭资源。
		producer.close();
		session.close();
		connection.close();	
	}
	@Test
	public void testTopicConsumer()throws Exception{
		//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.160:61616");
		//第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		//第三步：开启连接，调用Connection对象的start方法。
		connection.start();
		//第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		//第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
		Topic topic = session.createTopic("lv-topic");
		//第六步：使用Session对象创建一个Producer对象。
		MessageConsumer consumer = session.createConsumer(topic);
		//第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					//取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					System.out.println(text);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		System.out.println("消费者3已启动...");
		//等待键盘输入
		System.in.read();

		//第八步：关闭资源。
		consumer.close();
		session.close();
		connection.close();	
	}
}
