package com.org.Controlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "posts", "comments", "profile", "details" })
public class Example {

	@JsonProperty("posts")
	private List<Post> posts = null;
	@JsonProperty("comments")
	private List<Comment> comments = null;
	@JsonProperty("profile")
	private Profile profile;
	@JsonProperty("details")
	private Details details;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("posts")
	public List<Post> getPosts() {
		return posts;
	}

	@JsonProperty("posts")
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@JsonProperty("comments")
	public List<Comment> getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@JsonProperty("profile")
	public Profile getProfile() {
		return profile;
	}

	@JsonProperty("profile")
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@JsonProperty("details")
	public Details getDetails() {
		return details;
	}

	@JsonProperty("details")
	public void setDetails(Details details) {
		this.details = details;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
