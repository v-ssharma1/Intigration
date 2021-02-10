package com.org.ResponseValidationByJSONpath;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.org.Common.CommonResponceMethods;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;
import io.restassured.response.Response;

public class GetRespnceValidations extends TestBase {
	public static final Logger log = Logger.getLogger(GetRespnceValidations.class.getName());
	public static Response resp;
	public static double sum = 0;
	public static double expenciveAmount;
	public static List<Double> expenciveAmountDouble;
	public static List<Map<String, String>> allLocationsList1;
	public static List<Map<String, String>> allLocationsList;

	public void setup() {
		init();
	}

	// @Test
	public void getPostsTitileValidation() {
		resp = CommonResponceMethods.getResponse(endPoints.getPost);
		String jPath = resp.asString();
		List<String> title = JsonPath.read(jPath, "$.[?(@.price==7.22)].title");
		System.out.println("Titles are:");
		for (String actaulTitle : title) {
			System.out.println(actaulTitle);
		}
		Assert.assertEquals(title.get(0), "My Name is Shriya");
		System.out.println("Title of the book whose price is 7.22, is validated successfully.");
	}

	// @Test
	public void getPostsLocationStateValidation() {
		resp = CommonResponceMethods.getResponse(endPoints.getPost);
		String jPath = resp.asString();
		// list of all locations-> List of Map type
		List<String> allStateList = JsonPath.read(jPath, "$..Location.state");
		System.out.println("States are:");
		for (int i = 0; i <= allStateList.size() - 1; i++) {
			System.out.println(allStateList.get(i));
		}
		List<String> allStateList1 = JsonPath.read(jPath, "$.[?(@.price==7.22)].Location.state");
		Assert.assertEquals(allStateList1.get(0), "Captown");
		System.out.println("State, where the book price is 7.22, is validated successfully.");
	}

	@Test
	public void getPostsLocationValidation() {
		// double expenciveAmountStringValue;
		resp = CommonResponceMethods.getResponse(endPoints.getPost);
		String jResp = resp.asString();
		System.out.println(jResp);
		// list of all locations-> List of Map type
		allLocationsList = JsonPath.read(jResp, "$..Location");
		System.out.println("çities are:");
		for (int i = 0; i <= allLocationsList.size() - 1; i++) {
			System.out.println(allLocationsList.get(i).get("city"));
		}
		expenciveAmountDouble = JsonPath.read(jResp, "$..price");
		for (int i = 0; i < expenciveAmountDouble.size(); i++) {
			sum = sum + expenciveAmountDouble.get(i);
		}
		expenciveAmount = sum / expenciveAmountDouble.size();
		allLocationsList1 = JsonPath.read(jResp, "$.[?(@.price < " + expenciveAmount + ")].Location");
		Assert.assertEquals(allLocationsList1.get(0).get("city"), "CA");
		System.out
				.println("City, where the book price is less then " + expenciveAmount + ", is validated successfully.");
	}
}