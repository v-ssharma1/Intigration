package com.org.Common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecificationBuilder {

	/*
	 * get with id, put, Patch and delete request specifications builder.
	 */
	public static RequestSpecification GetRequestSpacificationWithId(int inputid) {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.addPathParam("id", inputid);
		builder.addHeader("ApplicationName", "MyLocalDB");
		builder.addCookie("SauarbhCookies");
		// filter to log request and response
		builder.addFilter(new ResponseLoggingFilter());
		builder.addFilter(new RequestLoggingFilter());

		RequestSpecification resSpecification = builder.build();
		return resSpecification;
		// return new RequestSpecBuilder().addPathParam("id",
		// inputid).setContentType(ContentType.JSON)
		// .addHeader("ApplicationName", "MyLocalDB").addFilter(new
		// ResponseLoggingFilter())
		// .addFilter(new RequestLoggingFilter()).build();
	}

	/*
	 * get without id and post request specifications builder.
	 */
	public static RequestSpecification GetRequestSpacificationWithOutId() {
		return new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("ApplicationName", "MyLocalDB")
				.addFilter(new ResponseLoggingFilter()).addFilter(new RequestLoggingFilter()).build();
	}

	/*
	 * Response specifications builder for Get Request.
	 */
	public static ResponseSpecification GetResponseSpacification() {
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		resBuilder.expectStatusCode(200);
		resBuilder.expectStatusLine("HTTP/1.1 200 OK");
		ResponseSpecification resSpecification = resBuilder.build();
		return resSpecification;
		// return new
		// ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
		// .expectStatusLine("HTTP/1.1 200 OK").build();
	}

	/*
	 * Response specifications builder for post Request.
	 */
	public static ResponseSpecification PostResponseSpacification() {
		return new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.expectStatusLine("HTTP/1.1 201 Created").build();
	}

	/*
	 * Response specifications builder for patch Request.
	 */
	public static ResponseSpecification PatchResponseSpacification() {
		return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectStatusLine("HTTP/1.1 200 Created").build();
	}

	/*
	 * Response specifications builder for delete Request.
	 */
	public static ResponseSpecification deleteResponseSpacification() {
		return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectStatusLine("HTTP/1.1 200 OK").build();
	}

	/*
	 * Response specifications builder for put Request.
	 */
	public static ResponseSpecification putResponseSpacification() {
		return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectStatusLine("HTTP/1.1 200 OK").build();
	}

}