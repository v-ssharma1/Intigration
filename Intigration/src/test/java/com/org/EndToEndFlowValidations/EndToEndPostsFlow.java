package com.org.EndToEndFlowValidations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.org.Common.CommonResponceMethods;
import com.org.Common.RequestAndResponseSpecificationBuilder;
import com.org.Controlers.Post;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EndToEndPostsFlow extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());
	Response resp;
	Post post;
	public static int ID;
	public static int Country_Id;
	public static String Title;
	public static String Author;
	public static float Price;
	public static String StateName;
	public static String country_Name;
	public static String jPath;
	public static JsonNode root;
	public static JsonNode rootArray;
	public static JsonNode LocationNode;
	public static ObjectMapper mapper;

	public void setup() {
		init();
	}

	/*
	 * Create a Post by post Request.
	 */
	@Test(priority=1)
	public void createAPost() {

		resp = CommonResponceMethods.postPostsResponse(countryID, state, city, countryName, author, id, price, title,
				endPoints.postAllPosts);
		resp.then().spec(RequestAndResponseSpecificationBuilder.PostResponseSpacification());
		jPath = resp.asString();
		mapper = new ObjectMapper();

		try {
			root = mapper.readTree(jPath);
			// Get id
			ID = root.path("id").asInt();
			Assert.assertEquals(id, ID);
			log.info("Login id is succesfully validated for Post reqest: " + ID);
			// Get title
			Title = root.path("title").asText();
			Assert.assertEquals(title, Title);
			log.info("Tittle is succesfully validated for Post reqest: " + ID);
			// Get author
			Author = root.path("author").asText();
			Assert.assertEquals(author, Author);
			log.info("Author is succesfully validated for Post reqest : " + Author);
			// Get price
			Price = root.path("price").floatValue();
			Assert.assertEquals(author, Author);
			log.info("Price is succesfully validated for Post reqest: " + Price);

			// Get Location
			LocationNode = root.path("Location");
			if (LocationNode.isMissingNode()) {
				log.info("Location Node is missing.");
			} else {

				Country_Id = LocationNode.path("country_id").asInt();
				// missing node, just return empty string
				StateName = LocationNode.path("state").asText();
				country_Name = LocationNode.path("country_name").asText();
				log.info("Location Info :");
				Assert.assertEquals(countryID, Country_Id);
				log.info("Country Id is succesfully validated for Post reqest : " + Country_Id);
				Assert.assertEquals(state, StateName);
				log.info("State Name is succesfully validated for Post reqest : " + StateName);
				Assert.assertEquals(countryName, country_Name);
				log.info("country Name is succesfully validated for Post reqest : " + country_Name);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Update a field of Created Post by put Request.
	 */
	@Test(priority=2)
	public void putPostsValidation() {
		resp = CommonResponceMethods.putPostsResponse(ID, countryID, state, city, "Canada", author, id, price, title,
				endPoints.putSpecificPosts);
		resp.then().spec(RequestAndResponseSpecificationBuilder.putResponseSpacification());
		jPath = resp.asString();
		mapper = new ObjectMapper();
		try {
			root = mapper.readTree(jPath);
			// Get id
			ID = root.path("id").asInt();
			Assert.assertEquals(id, ID);
			log.info("Login id is succesfully validated for Post reqest: " + ID);
			LocationNode = root.path("Location");
			if (LocationNode.isMissingNode()) {
				log.info("Location Node is missing.");
			} else {
				country_Name = LocationNode.path("country_name").asText();
				Assert.assertEquals("Canada", country_Name);
				log.info("Updated country Name is succesfully validated for Post reqest : " + country_Name);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Delete Specific post.
	 */

	@Test(priority=3)
	public void deleteASpecificPostValidation() {
		resp = CommonResponceMethods.deletePostResponse(id, endPoints.deleteSpecificPost);
		resp.then().spec(RequestAndResponseSpecificationBuilder.deleteResponseSpacification());
		log.info("Post of id," + id + "has been deleted succesfully.");
	}

	/*
	 * Check the deleted Post Should not exist in DB by Get Request.
	 */
	
	@Test(priority=4)
	public void getPostsValidation() {
		int flag = 0;
		resp = CommonResponceMethods.getResponse(endPoints.getPost);
		resp.then().spec(RequestAndResponseSpecificationBuilder.GetResponseSpacification());
		jPath = resp.asString();
		mapper = new ObjectMapper();
		try {
			rootArray = mapper.readTree(jPath);
			// Get id
			for (JsonNode root : rootArray) {
				if (root.path("id").asInt() == ID) {
					flag = 1;
				}
			}
			if (flag == 1) {
				Assert.assertFalse(true, "ID is not deleted properly.");
				log.info("ID " + id + " still exist.");
			} else {
				Assert.assertFalse(false, "ID has been deleted deleted properly.");
				log.info("ID " + id + " does not exist any more.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
