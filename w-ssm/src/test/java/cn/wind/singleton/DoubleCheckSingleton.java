/**
*
*
*/
package cn.wind.singleton;

import java.lang.invoke.VolatileCallSite;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title:DoubleCheckSingleton.java </p>
 * <p>Description: DoubleCheckSingleton.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月9日下午12:59:32
 * @version 1.0
 */
public class DoubleCheckSingleton {
	private volatile static DoubleCheckSingleton instance = null;
	private DoubleCheckSingleton(){}
	public static DoubleCheckSingleton getInstance(){
		if (instance == null) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(DoubleCheckSingleton.getInstance().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(DoubleCheckSingleton.getInstance().hashCode());
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(DoubleCheckSingleton.getInstance().hashCode());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
