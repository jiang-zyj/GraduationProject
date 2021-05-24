package com.zyj.maven;	
	import org.junit.Test;
	import static junit.framework.Assert.*;
	public class HelloTest {
		@Test
		public void testHello(){
			Hello hello = new Hello();
			String results = hello.sayHello("宋老师");
			// 断言
			assertEquals("Hello 宋老师!",results);
		}
	}