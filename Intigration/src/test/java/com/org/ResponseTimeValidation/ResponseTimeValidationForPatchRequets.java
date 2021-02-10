package com.org.ResponseTimeValidation;

import static org.hamcrest.Matchers.lessThan;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.ResponseStatusValidation.AllPatchResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class ResponseTimeValidationForPatchRequets extends TestBase {
	public static final Logger log = Logger.getLogger(AllPatchResponseStatusValidation.class.getName());
	public static String filedString;

	public void setup() {
		init();
	}

	@Test
	public void patchPostsValidationF() {
		filedString = "{\"price\": 14.22}";
		CommonResponceMethods.patchPostResponse(4, filedString, endPoints.patchSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.PatchResponseSpacification()).assertThat()
				.time(lessThan(800L));
		log.info("Response Time of Patch request for a Specific Post is validated successfully.");
	}
}
