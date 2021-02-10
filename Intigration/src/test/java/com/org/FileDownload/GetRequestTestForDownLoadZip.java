package com.org.FileDownload;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;

public class GetRequestTestForDownLoadZip {
	@Test
	public void verifyFileDownload() {

		int fileSize;
		File filePath = new File(System.getProperty("user.dir") + "/src/main/java/com/org/Resources/Downloads/rest-assured-3.0.5-dist.zip");

		fileSize = (int) filePath.length();

		System.out.println("The actual value is " + fileSize);

		byte[] expectedValue = given().get("http://dl.bintray.com/johanhaleby/generic/rest-assured-3.0.5-dist.zip")
				.asByteArray();

		System.out.println("The expected value is " + expectedValue.length);

		Assert.assertEquals(fileSize, expectedValue.length);
	}
}
