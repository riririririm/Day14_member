package com.rim.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rim.control.MemberController;

public class MemberControllerTest {

	@Test
	public void test() throws Exception {
		MemberController controller = new MemberController();
		controller.start();
	}

}
