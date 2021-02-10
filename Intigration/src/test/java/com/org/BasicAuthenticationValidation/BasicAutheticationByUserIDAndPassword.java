package com.org.BasicAuthenticationValidation;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.ResponseValidationByJSONpath.GetRespnceValidations;
import com.org.TestBase.TestBase;

import io.restassured.RestAssured;

public class BasicAutheticationByUserIDAndPassword extends TestBase {
	public static final Logger log = Logger.getLogger(GetRespnceValidations.class.getName());

	//Check the status code
	@Test
	public void autheticationByUserIDAndPassword() {
		//ceck the second line of @before class method of testBase to set the user id and password.
		//Status code validation.
		int statusCode = RestAssured.given().get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		log.info("Authetication is succesfull and status code is: " + statusCode);
		
		//Response validation
	}
}
