package com.org.ResponseHeaderAndCookiesValidation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.org.Common.CommonResponceMethods;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class HeaderValidations extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	// Validate Header for Posts.
	@Test
	public void headerValidationForGetPost() {
		CommonResponceMethods.getResponse(endPoints.getPost).then().assertThat().header("Content-Type",
				"application/json; charset=utf-8");
		log.info("ContentType of response header is validated succesfully.");
	}

	@Test
	public void headersValidationForGetPost() {
		CommonResponceMethods.getResponse(endPoints.getPost).then().assertThat().headers(
				"Access-Control-Allow-Credentials", "true", "Cache-Control", "no-cache", "Connection", "keep-alive",
				"Content-Length", "988", "ETag", "W/\"3dc-/15Ea3syTF7QOekHxLkFPhOu12g\"", "Expires", "-1", "Pragma",
				"no-cache", "Vary", "Origin, Accept-Encoding", "X-Content-Type-Options", "nosniff", "X-Powered-By",
				"Express");
		log.info("All header valees of response header of get requests for Posts are Validated succesfully.");
	}

	// Schema Validation for Comments.
	@Test
	public void headersValidationForGetComments() {
		CommonResponceMethods.getResponse(endPoints.getComments).then().assertThat().headers(
				"Access-Control-Allow-Credentials", "true", "Cache-Control", "no-cache", "Connection", "keep-alive",
				"Content-Length", "154", "ETag", "W/\"9a-+iQguL6Gr5bR4q0SsVHQNOAhOOY\"", "Expires", "-1", "Pragma",
				"no-cache", "Vary", "Origin, Accept-Encoding", "X-Content-Type-Options", "nosniff", "X-Powered-By",
				"Express");
		log.info(
				"All header valees of response header of get requests for Comments are Validated succesfully.");
	}

	// Schema Validation for profile.
	@Test
	public void headersValidationForGetProfile() {
		CommonResponceMethods.getResponse(endPoints.getprofile).then().assertThat().headers(
				"Access-Control-Allow-Credentials", "true", "Cache-Control", "no-cache", "Connection", "keep-alive",
				"Content-Length", "30", "ETag", "W/\"1e-KZaXFO1Dpeqb+uGQ+qnR3Z2aBGg\"", "Expires", "-1", "Pragma",
				"no-cache", "Vary", "Origin, Accept-Encoding", "X-Content-Type-Options", "nosniff", "X-Powered-By",
				"Express");
		System.out
				.println("All header valees of response header of get requests for Profile are Validated succesfully.");
	}

	// Schema Validation for Details.
	@Test
	public void headersValidationForGetDetails() {
		CommonResponceMethods.getResponse(endPoints.getDetails).then().assertThat().headers(
				"Access-Control-Allow-Credentials", "true", "Cache-Control", "no-cache", "Connection", "keep-alive",
				"Content-Length", "290", "ETag", "W/\"122-nXlaaDbra0ucYabM6gyjXdwhUSM\"", "Expires", "-1", "Pragma",
				"no-cache", "Vary", "Origin, Accept-Encoding", "X-Content-Type-Options", "nosniff", "X-Powered-By",
				"Express");
		System.out
				.println("All header valees of response header of get requests for Details are Validated succesfully.");
	}
}
