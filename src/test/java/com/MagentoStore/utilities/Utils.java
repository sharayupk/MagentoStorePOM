package com.MagentoStore.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.MagentoStore.testCases.BaseClass;

public class Utils extends BaseClass{

	public static long IMPLICIT_WAIT=20;
	public static long PAGE_LOAD_TIMEOUT=20;

	public static void takeScreenshotAtEndOfTest() throws IOException {


		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
