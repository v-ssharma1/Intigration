package com.org.ResponseTimeValidation;

import static org.hamcrest.Matchers.lessThan;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.ResponseStatusValidation.AllPutResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class ResponseTimeValidationForPutRequets extends TestBase {
	public static final Logger log = Logger.getLogger(AllPutResponseStatusValidation.class.getName());
	public static int idTobeupdated = 8;

	public void setup() {
		init();
	}

	@Test
	public void putPostsValidation() {
		CommonResponceMethods
				.putPostsResponse(idTobeupdated, countryID, state, city, countryName, author, id, price, title,
						endPoints.putSpecificPosts)
				.then().spec(RequestAndResponseSpecificationBuilder.putResponseSpacification()).assertThat()
				.time(lessThan(800L));
		log.info("Response Time of put request for a Specific Post is validated successfully.");
	}
}
