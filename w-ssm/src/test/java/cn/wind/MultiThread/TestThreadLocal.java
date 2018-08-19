/**
 * Copyright 2018 TPRI. All Rights Reserved.
 */
package cn.wind.MultiThread;

import java.util.Random;

import com.sun.tools.javac.code.Lint;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author wind
 * @since 2018年8月15日
 */
public class TestThreadLocal {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" has put data:"
					    + data);
					threadLocal.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	static class A {
		void get(){
			int data = threadLocal.get();
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	static class B {
		void get(){
			int data = threadLocal.get();
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	
}

