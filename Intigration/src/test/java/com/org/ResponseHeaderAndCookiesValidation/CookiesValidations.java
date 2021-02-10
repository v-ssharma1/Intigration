package com.org.ResponseHeaderAndCookiesValidation;

import org.apache.log4j.Logger;

import com.org.Common.CommonResponceMethods;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;
import java.util.Map;

import org.testng.annotations.Test;

public class CookiesValidations extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}

	 @Test
	public void whenUseCookie_thenOK() {
		// given().cookie("session_id",
		// "1234").when().get("/users/eugenp").then().statusCode(200);
		Map<String, String> cookies=CommonResponceMethods.getResponse(endPoints.getPost).getCookies();
		for(Map.Entry<String, String> entry : cookies.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		log.info("Cookies of response is validated succesfully.");
	}

	// @Test
	public void whenUseCookieBuilder_thenOK() {
		// Cookie myCookie = new Cookie.Builder("session_id",
		// "1234").setSecured(true).setComment("session id cookie").build();
		// given().cookie(myCookie).when().get("/users/eugenp").then().statusCode(200);
	}
}
