package com.org.ResponseStatusValidation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class AllPatchResponseStatusValidation extends TestBase {
	public static final Logger log = Logger.getLogger(AllPatchResponseStatusValidation.class.getName());
	public static String filedString;

	public void setup() {
		init();
	}

	@Test
	public void patchPostsValidationF() {
		filedString = "{\"price\": 14.22}";
		CommonResponceMethods.patchPostResponse(4, filedString, endPoints.patchSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.PatchResponseSpacification());
		log.info("Status Code and Status Line for a Specific patch is validated successfully.");
	}
}
