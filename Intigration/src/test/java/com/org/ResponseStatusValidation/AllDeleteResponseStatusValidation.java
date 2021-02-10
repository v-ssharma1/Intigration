package com.org.ResponseStatusValidation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class AllDeleteResponseStatusValidation extends TestBase {

	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	/*
	 * Delete Specific post.
	 */
	
	//@Test
	public void deleteASpecificPostValidation() {
		CommonResponceMethods.deletePostResponse(3, endPoints.deleteSpecificPost).then()
				.spec(RequestAndResponseSpecificationBuilder.deleteResponseSpacification());
		log.info("Status Code and Status Line for a Specific delete is validated successfully.");
	}
	
	/*
	 * Delete Specific comment.
	 */
	
	@Test
	public void deleteASpecificCommentValidation() {
		CommonResponceMethods.deletePostResponse(3, endPoints.deleteSpecificComment).then()
				.spec(RequestAndResponseSpecificationBuilder.deleteResponseSpacification());
		log.info("Status Code and Status Line for a Specific delete is validated successfully.");
	}
}
