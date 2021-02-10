package com.org.ResponseStatusValidation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class AllPostResponseStatusValidation extends TestBase {
	public static final Logger log = Logger.getLogger(AllPostResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Post request status code and status line validation for posts.
	 */
	
	@Test
	public void postPostsValidation() {
		CommonResponceMethods
				.postPostsResponse(countryID, state, city, countryName, author, id, price, title,
						endPoints.postAllPosts)
				.then().spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Post request status code and status line validation for Comments.
	 */
	
	 //@Test
	public void postCommentsValidation() {
		CommonResponceMethods.postCommentsResponse(commentId, body, postId, endPoints.postAllcomments).then()
				.spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Post request status code and status line validation for Profiles.
	 */
	
	// @Test
	public void postProfileValidation() {
		CommonResponceMethods.postProfileResponse(name, endPoints.postAllProfiles).then()
				.spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Post request status code and status line validation for Details.
	 */
	
	//@Test
	public void postDetailsValidation() {
		CommonResponceMethods
				.postDetailsResponse(number, type, City, postalCode, streetAddress, age, firstName, lastName,
						endPoints.postAllDetails)
				.then().spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}
}
