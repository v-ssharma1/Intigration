package com.org.ResponseTimeValidation;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationForGetRequets extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Response Time validation for get Requests for posts.
	 */

	@Test
	public void getResponseTimeValidationForPostsWithSpecificID() {

		Assert.assertTrue(CommonResponceMethods.getResponseForSpecificID(8, endPoints.getSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 400L, "Response Time is within limit.");
		log.info("Response Time is within limit. SuccessfullyValidated");
	}

	@Test
	public void getResponseTimeValidationForPosts() {
		CommonResponceMethods.getResponse(endPoints.getPost).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).assertThat()
				.time(lessThan(400L));
		log.info("Response Time of get request of Posts is less than 400 MiliSeconds. SuccessfullyValidated");
	}

	/*
	 * Response Time validation for get Requests for Comments.
	 */

	@Test
	public void getCommentsResponseTimeValidationForSpecificID() {
		CommonResponceMethods.getResponseForSpecificID(4, endPoints.getSpecificComment).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).assertThat()
				.time(lessThan(400L));
		log.info("Response Time of get request for a Specific comment is validated successfully.");
	}

	@Test
	public void getCommentsResponseTimeValidation() {
		Assert.assertTrue(CommonResponceMethods.getResponse(endPoints.getComments).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 400L, "Response Time is within limit.");
		log.info("Response Time of get request for comments is validated successfully.");
	}

	/*
	 * Status code validation for get Requests for profile.
	 */

	@Test
	public void getProfileValidation() {
		CommonResponceMethods.getResponse(endPoints.getprofile).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).assertThat()
				.time(lessThan(400L));
		log.info("Response Time of get request for a Specific Post is validated successfully.");
	}

	/*
	 * Status code validation for get Requests for Details.
	 */

	@Test
	public void getDetailsValidation() {
		Assert.assertTrue(CommonResponceMethods.getResponse(endPoints.getDetails).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 400L, "Response Time is within limit.");
		log.info("Response Time of get request for details is validated successfully.");
	}

}
