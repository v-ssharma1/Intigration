package com.org.SchemaValidations;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.org.Common.CommonResponceMethods;
import com.org.ResponseStatusValidation.AllGetResponseStatusValidation;
import com.org.TestBase.TestBase;
import com.org.URIs.endPoints;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

public class SchemaValidationForGetResponse extends TestBase {
	public static final Logger log = Logger.getLogger(AllGetResponseStatusValidation.class.getName());

	public void setup() {
		init();
	}
	// Refer below link for more details:
	// https://github.com/eugenp/tutorials/blob/master/testing-modules/rest-assured/src/test/java/com/baeldung/restassured/RestAssuredIntegrationTest.java
	// https://www.baeldung.com/rest-assured-json-schema

	// Schema Validation for Posts.
	@Test
	public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {
		CommonResponceMethods.getResponse(endPoints.getPost).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaPosts.json"));
		log.info("Json Schema for posts is validated succesfully.");
	}

	@Test
	public void givenUrlForPosts_whenValidatesResponseWithInstanceSettings_thenCorrect() {
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
				.freeze();

		CommonResponceMethods.getResponse(endPoints.getPost).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaPosts.json").using(jsonSchemaFactory));
		log.info("Json Schema for posts is validated succesfully.");
	}

	@Test
	public void givenUrl_whenValidatesResponseWithStaticSettings_thenCorrect() {

		CommonResponceMethods.getResponse(endPoints.getPost).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaPosts.json")
						.using(settings().with().checkedValidation(false)))
				.log().all();
		log.info("Json Schema for posts is validated succesfully.");
	}

	// Schema Validation for Comments.
	@Test
	public void givenUrlForComments_whenJsonResponseConformsToSchema_thenCorrect() {
		CommonResponceMethods.getResponse(endPoints.getComments).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/JsonShemaComments.json"));
		log.info("Json Schema for Comments is validated succesfully.");
	}

	@Test
	public void givenUrlForComments_whenValidatesResponseWithInstanceSettings_thenCorrect() {
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
				.freeze();

		CommonResponceMethods.getResponse(endPoints.getComments).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/JsonShemaComments.json").using(jsonSchemaFactory));
		log.info("Json Schema for Comments is validated succesfully.");
	}

	@Test
	public void givenUrlForComments_whenValidatesResponseWithStaticSettings_thenCorrect() {

		CommonResponceMethods.getResponse(endPoints.getComments).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/JsonShemaComments.json")
						.using(settings().with().checkedValidation(false)))
				.log().all();
		log.info("Json Schema for Comments is validated succesfully.");
	}

	// Schema Validation for profile.
	@Test
	public void givenUrlForProfiles_whenJsonResponseConformsToSchema_thenCorrect() {
		CommonResponceMethods.getResponse(endPoints.getprofile).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaProfiles.json"));
		log.info("Json Schema for Profile is validated succesfully.");
	}

	@Test
	public void givenUrlForProfiles_whenValidatesResponseWithInstanceSettings_thenCorrect() {
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
				.freeze();

		CommonResponceMethods.getResponse(endPoints.getprofile).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaProfiles.json").using(jsonSchemaFactory));
		log.info("Json Schema for Profile is validated succesfully.");
	}

	@Test
	public void givenUrlForProfiles_whenValidatesResponseWithStaticSettings_thenCorrect() {

		CommonResponceMethods.getResponse(endPoints.getprofile).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaProfiles.json")
						.using(settings().with().checkedValidation(false)))
				.log().all();
		log.info("Json Schema for Profile is validated succesfully.");
	}

	// Schema Validation for Details.
	@Test
	public void givenUrlForDetails_whenJsonResponseConformsToSchema_thenCorrect() {
		CommonResponceMethods.getResponse(endPoints.getDetails).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaDetails.json"));
		log.info("Json Schema for Details is validated succesfully.");
	}

	@Test
	public void givenUrlForDetails_whenValidatesResponseWithInstanceSettings_thenCorrect() {
		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
				.setValidationConfiguration(
						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
				.freeze();

		CommonResponceMethods.getResponse(endPoints.getDetails).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaDetails.json").using(jsonSchemaFactory));
		log.info("Json Schema for Details is validated succesfully.");
	}

	@Test
	public void givenUrlForDetails_whenValidatesResponseWithStaticSettings_thenCorrect() {

		CommonResponceMethods.getResponse(endPoints.getDetails).then().assertThat()
				.body(matchesJsonSchemaInClasspath("JsonSchemas/jsonSchemaDetails.json")
						.using(settings().with().checkedValidation(false)))
				.log().all();
		log.info("Json Schema for Details is validated succesfully.");
	}
}
