package com.FaceBookLogin;

import org.testng.annotations.Test;

import com.BaseClass.WrapperClass;

public class MainClass1 {
	WrapperClass application = new WrapperClass();
	@Test
	protected void openApplication() throws InterruptedException {
		application.launchApplication();
	}
}
