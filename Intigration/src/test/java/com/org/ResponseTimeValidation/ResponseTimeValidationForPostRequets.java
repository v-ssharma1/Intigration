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

public class ResponseTimeValidationForPostRequets extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Response Time validation for get Requests for posts.
	 */

	//@Test
	public void postPostsValidation() {
		Assert.assertTrue(CommonResponceMethods
				.postPostsResponse(countryID, state, city, countryName, author, id, price, title,
						endPoints.postAllPosts)
				.then().spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 800L, "Response Time is within limit.");
		log.info("Response Time of post posts is within limit. SuccessfullyValidated");
	}

	/*
	 * Response Time validation for get Requests for Comments.
	 */

	@Test
	public void postCommentsValidation() {
		CommonResponceMethods.postCommentsResponse(commentId, body, postId, endPoints.postAllcomments).then()
				.spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification()).assertThat()
				.time(lessThan(800L));
		log.info("Response Time of post comments is within limit. SuccessfullyValidated");
	}

	/*
	 * Response Time validation for get Requests for Profiles.
	 */

	// @Test
	public void postProfileValidation() {
		Assert.assertTrue(CommonResponceMethods.postProfileResponse(name, endPoints.postAllProfiles).then()
				.spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification()).extract()
				.timeIn(TimeUnit.SECONDS) < 800L, "Response Time is within limit.");
		log.info("Response Time of post Profiles is within limit. SuccessfullyValidated");
	}

	/*
	 * Response Time validation for get Requests for Details.
	 */

	//@Test
	public void postDetailsValidation() {
		CommonResponceMethods
				.postDetailsResponse(number, type, City, postalCode, streetAddress, age, firstName, lastName,
						endPoints.postAllDetails)
				.then().spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification()).assertThat()
				.time(lessThan(800L));
		log.info("Response Time of post comments is within limit. SuccessfullyValidated");
	}
}
