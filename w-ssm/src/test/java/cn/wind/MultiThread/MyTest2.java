/**
 * Copyright 2018 TPRI. All Rights Reserved.
 */
package cn.wind.MultiThread;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author wind
 * @since 2018年8月15日
 */
public class MyTest2 {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		System.out.println(Instant.now());
		
	}
}
