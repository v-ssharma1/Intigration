package com.org.ResponseStatusValidation;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class AllGetResponseStatusValidation extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Status code validation for get Requests for posts.
	 */

	@Test
	public void getPostsValidationForSpecificID() {
		CommonResponceMethods.getResponseForSpecificID(8, endPoints.getSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	@Test
	public void getPostsValidation() {
		CommonResponceMethods.getResponse(endPoints.getPost).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Status code validation for get Requests for Comments.
	 */

	@Test
	public void getCommentsValidationForSpecificID() {
		CommonResponceMethods.getResponseForSpecificID(4, endPoints.getSpecificComment).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	@Test
	public void getCommentsValidation() {
		CommonResponceMethods.getResponse(endPoints.getComments).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Status code validation for get Requests for profile.
	 */

	@Test
	public void getProfileValidation() {
		CommonResponceMethods.getResponse(endPoints.getprofile).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

	/*
	 * Status code validation for get Requests for Details.
	 */

	@Test
	public void getDetailsValidation() {
		CommonResponceMethods.getResponse(endPoints.getDetails).then()
				.spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		log.info("Status Code and Status Line for a Specific Post is validated successfully.");
	}

}