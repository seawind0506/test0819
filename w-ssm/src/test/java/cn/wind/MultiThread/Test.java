/**
*
*
*/
package cn.wind.MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleMultiInsertStatement.InsertIntoClause;
import com.sun.tools.hat.internal.util.Comparer;

/**
 * <p>Title:Test.java </p>
 * <p>Description: 不定义临时变量，交换已有的两个变量的值</p>
 * <p>Company: www.lv.com</p> 
 * @author	吕
 * @date	2018年8月7日上午9:56:11
 * @version 1.0
 */
public class Test {
	public int compare(int a, int b){
		return a > b ? 1 : a < b ? -1 : 0;
	}
	
	public  void fun(){
		while(true){
			try{
				System.out.println("测试开始");
				int i = 1/0;
				break;
			}catch (Exception e) {
				e.printStackTrace();
				continue;
			}finally {
				continue;
			}
		}
	}
	@org.junit.Test
	public  void exchangeValue() {
//		int a = 3, b = 5;
//		int result = this.compare(a, b);
//		System.out.println(result);
//		System.out.println("start：\t a = "+a+",b = "+b);
		//法一：利用加减法
		/*a = a + b;
		b = a - b;
		a = a - b;*/
		
		//法二：利用异或运算
//		a = a ^ b;
//		b = a ^ b;
//		a = a ^ b;
//		System.out.println("end：\t a = "+a+",b = "+b);
//		
//		Lock lock1 = new ReentrantLock();
//		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//		ReadLock readLock = reentrantReadWriteLock.readLock();
//		WriteLock writeLock = reentrantReadWriteLock.writeLock();
		fun();
	}
}
