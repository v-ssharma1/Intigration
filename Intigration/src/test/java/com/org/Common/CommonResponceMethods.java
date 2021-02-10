package com.org.Common;

import static io.restassured.RestAssured.given;
import com.org.TestBase.TestBase;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonResponceMethods extends TestBase {

	/*
	 * Common Methods for both Types of Get requests
	 */

	public static Response getResponseForSpecificID(int id, String endpoint) {
		return given().header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
				.relaxedHTTPSValidation("TLS")
				.spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithId(id)).get(endpoint);
	}

	public static Response getResponse(String endpoint) {
		RequestSpecification reqSpec = given()
				.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
				.relaxedHTTPSValidation()
				.spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithOutId());
		Response response = reqSpec.get(endpoint);
		return response;
	}

	/*
	 * Common Methods for Post requests
	 */

	public static Response postPostsResponse(int countryID, String state, String city, String countryName,
			String author, int id, double price, String title, String endPoints) {
		return given()
				.spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithOutId()).body(SetControlerValues
						.setElementsForPosts(countryID, state, city, countryName, author, id, price, title))
				.when().post(endPoints);
	}

	public static Response postCommentsResponse(int commentId, String body, int postId, String endPoints) {
		return given().spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithOutId())
				.body(SetControlerValues.setElementsForComments(commentId, body, postId)).when().post(endPoints);
	}

	public static Response postProfileResponse(String name, String endPoints) {
		return given().spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithOutId())
				.body(SetControlerValues.setElementsForProfile(name)).when().post(endPoints);
	}

	public static Response postDetailsResponse(String number, String type, String City, String postalCode,
			String streetAddress, int age, String firstName, String lastName, String endPoints) {
		return given()
				.spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithOutId()).body(SetControlerValues
						.setElementsForDetails(number, type, City, postalCode, streetAddress, age, firstName, lastName))
				.when().post(endPoints);
	}

	/*
	 * Common method for Deleting a post.
	 */
	public static Response deletePostResponse(int id, String endPoint) {
		return given().spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithId(id)).when()
				.delete(endPoint);
	}

	/*
	 * Common method for updating a filed by Patch Request.
	 */
	public static Response patchPostResponse(int id, String filedString, String endPoint) {
		return given().spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithId(id)).body(filedString)
				.when().patch(endPoint);
	}

	/*
	 * Common method for updating a filed by put Request.
	 */
	public static Response putPostsResponse(int idTobeupdated, int countryID, String state, String city,
			String countryName, String author, int id, double price, String title, String endPoints) {
		return given().spec(RequestAndResponseSpecificationBuilder.GetRequestSpacificationWithId(idTobeupdated)).body(
				SetControlerValues.setElementsForPosts(countryID, state, city, countryName, author, id, price, title))
				.when().put(endPoints);
	}
}
