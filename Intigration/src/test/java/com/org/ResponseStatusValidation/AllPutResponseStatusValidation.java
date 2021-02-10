package com.org.ResponseStatusValidation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;

public class AllPutResponseStatusValidation extends TestBase {
	public static final Logger log = Logger.getLogger(AllPutResponseStatusValidation.class.getName());
	public static int idTobeupdated = 24;
	
	public void setup() {
		init();
	}
	
	@Test
	public void putPostsValidation() {
		CommonResponceMethods
				.putPostsResponse(idTobeupdated, countryID, state, city, countryName, author, id, price, title,
						endPoints.putSpecificPosts)
				.then().spec(RequestAndResponseSpecificationBuilder.putResponseSpacification());
		log.info("Status Code and Status Line for a Specific delete is validated successfully.");
	}
}

