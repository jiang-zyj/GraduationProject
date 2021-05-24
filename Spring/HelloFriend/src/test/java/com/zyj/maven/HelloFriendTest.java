package com.zyj.maven;	
	import static junit.framework.Assert.assertEquals;
	import org.junit.Test;
	import com.zyj.maven.Hello;
	
	public class HelloFriendTest {
		@Test
		public void testHelloFriend(){
			HelloFriend helloFriend = new HelloFriend();
			String results = helloFriend.sayHelloToFriend("宋老师");
			assertEquals("Hello 宋老师! I am John",results);
		}
	}