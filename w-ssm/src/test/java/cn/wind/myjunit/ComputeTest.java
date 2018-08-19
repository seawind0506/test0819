/**
 * Copyright 2018 TPRI. All Rights Reserved.
 */
package cn.wind.myjunit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * @author lv
 * @date 2018/08/18
 */
public class ComputeTest {

	/**
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("beforeClass");
	}

	@Before
	/**
	 * 
	 * @throws Exception
	 */
	public void before() throws Exception {
		System.out.println("before");
	}

	/**
	 * Test method for {@link cn.wind.myjunit.Compute#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		int z = Compute.add(3, 5);
		assertEquals(8, z);
		String string = new String();
		assertEquals(5, z);
	}

	@Test
	public void testDiv() {
		double z = Compute.div(3.0, 1.0);
		TestCase.assertEquals(3.0, z);

	}

	@After
	public void after() throws Exception {
		System.out.println("after");
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("afterClass");
	}

}
