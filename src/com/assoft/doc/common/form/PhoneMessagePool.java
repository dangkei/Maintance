package com.assoft.doc.common.form;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;



public class PhoneMessagePool {
	
	private List<PhoneMessage> messageList = new LinkedList<PhoneMessage>();
	
	public synchronized PhoneMessage  loadMessage() {
		try {
			while (messageList.size()<=0) {
				String time=new Date().toString();
				System.out.println(time+":手机客户端消息池中没有消息!");
				this.wait();
				time=new Date().toString();
				System.out.println(time+":手机客户端消息池中有消息了!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return messageList.remove(0);
	}

	public synchronized void saveMessage(PhoneMessage message) {
		messageList.add(message);
		System.out.println(new Date()+":手机客户端增加消息需要处理");
		this.notifyAll();
	}
	

}
