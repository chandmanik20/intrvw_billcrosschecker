package com.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	private Main  main = null;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		main = null;
	}

	@Test
	public void testCall() {	
		Main.SOURCE_LOCATION = "D:\\data\\input";
		Main.DESTINATION_LOCATION = "D:\\data\\output";
		main = new Main();
		main.call();
	}

}
