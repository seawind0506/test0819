/**
*
*
*/
package cn.wind.singleton;

/**
 * <p>Title:InnerSingleton.java </p>
 * <p>Description: InnerSingleton.java</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月9日下午12:56:45
 * @version 1.0
 */
public class InnerSingleton {
	private InnerSingleton(){}
	private static class Singleton{
		private static Singleton instance = new Singleton();
	}
	public static Singleton getInstance(){
		return Singleton.instance;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(InnerSingleton.getInstance().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(InnerSingleton.getInstance().hashCode());
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(InnerSingleton.getInstance().hashCode());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
