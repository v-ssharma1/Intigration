package com.org.URIs;

public class endPoints {
	// All Get Request endpoints
	public static final String getSpecificPost = "/posts/{id}";
	public static final String getPost = "/posts";
	public static final String getComments = "/comments";
	public static final String getSpecificComment = "/comments/{id}";
	public static final String getprofile = "/profile";
	public static final String getDetails = "/details";
	// All post Request endpoints
	public static final String postAllPosts = "/posts";
	public static final String postAllProfiles = "/profile";
	public static final String postAllDetails = "/details";
	public static final String postAllcomments = "/comments";
	// All put Request endpoints
	public static final String putSpecificPosts = "/posts/{id}";
	public static final String putSpecificComment = "/comments/{id}";
	// All patch Request endpoints
	public static final String patchSpecificPost = "/posts/{id}";
	public static final String patchSpecificComment = "/comments/{id}";
	// All delete Request endpoints
	public static final String deleteSpecificPost = "/posts/{id}";
	public static final String deleteSpecificComment = "/comments/{id}";
}