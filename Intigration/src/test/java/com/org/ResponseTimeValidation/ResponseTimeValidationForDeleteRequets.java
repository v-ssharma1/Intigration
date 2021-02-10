package com.org.ResponseTimeValidation;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class ResponseTimeValidationForDeleteRequets extends TestBase {

	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Response time validation for Delete Specific post.
	 */
	
	@Test
	public void deleteASpecificPostValidation() {
		CommonResponceMethods.deletePostResponse(1, endPoints.deleteSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.deleteResponseSpacification()).assertThat()
				.time(lessThan(800L));
		log.info("Response Time of get request for a Specific Post is validated successfully.");
	}

	/*
	 * Response time validation for Delete Specific comment.
	 */
	
	//@Test
	public void deleteASpecificCommentValidation() {
		Assert.assertTrue(CommonResponceMethods.deletePostResponse(3, endPoints.deleteSpecificComment).then()
				.spec(RequestAndResponseSpecificationBuilder.deleteResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 800L, "Response Time is within limit.");
		log.info("Response Time of get request for details is validated successfully.");
		;
	}
}
