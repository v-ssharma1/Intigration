package com.org.Common;

import java.util.ArrayList;
import java.util.List;

import com.org.Controlers.Address;
import com.org.Controlers.Comment;
import com.org.Controlers.Details;
import com.org.Controlers.Location;
import com.org.Controlers.PhoneNumber;
import com.org.Controlers.Post;
import com.org.Controlers.Profile;

public class SetControlerValues {

	public static Post settingElementsOfPost;
	public static Location settingElementsOfLocation;
	public static Comment com;
	public static Profile profile;
	public static Details details;
	public static Address address;
	public static PhoneNumber phoneNumber1;
	public static PhoneNumber phoneNumber2;
	public static PhoneNumber phoneNumber3;
	public static List<PhoneNumber> phoneNumbers;

	/*
	 * Common Methods for setting params for Posts.
	 */
	public static Post setElementsForPosts(int countryID, String state, String city, String countryName, String author,
			int id, double price, String title) {
		settingElementsOfPost = new Post();
		settingElementsOfLocation = new Location();
		settingElementsOfLocation.setCountryId(countryID);
		settingElementsOfLocation.setState(state);
		settingElementsOfLocation.setCity(city);
		settingElementsOfLocation.setCountryName(countryName);
		settingElementsOfPost.setLocation(settingElementsOfLocation);
		settingElementsOfPost.setAuthor(author);
		settingElementsOfPost.setId(id);
		settingElementsOfPost.setPrice(price);
		settingElementsOfPost.setTitle(title);

		return settingElementsOfPost;
	}

	/*
	 * Common Methods for setting params for Comments.
	 */
	public static Profile setElementsForProfile(String name) {
		profile = new Profile();
		profile.setName(name);

		return profile;
	}

	/*
	 * Common Methods for setting params for profile.
	 */
	public static Comment setElementsForComments(int id, String body, int postId) {
		com = new Comment();
		com.setId(id);
		com.setBody(body);
		com.setPostId(postId);

		return com;
	}

	/*
	 * Common Methods for setting params for details.
	 */
	public static Details setElementsForDetails(String number, String type, String City, String postalCode,
			String streetAddress, int age, String firstName, String lastName) {
		details = new Details();
		address = new Address();
		// List<PhoneNumber> PhoneNumbers=null;
		phoneNumber1 = new PhoneNumber();
		phoneNumber2 = new PhoneNumber();
		phoneNumber3 = new PhoneNumber();
		phoneNumber1.setNumber(number);
		phoneNumber1.setType(type);
		phoneNumber2.setNumber(number + "1");
		phoneNumber2.setType(type + "1");
		phoneNumber3.setNumber(number + "11");
		phoneNumber3.setType(type + "11");
		phoneNumbers = new ArrayList<PhoneNumber>();
		phoneNumbers.add(phoneNumber1);
		phoneNumbers.add(phoneNumber2);

		address.setCity(City);
		address.setPostalCode(postalCode);
		address.setStreetAddress(streetAddress);
		details.setAddress(address);
		details.setPhoneNumbers(phoneNumbers);
		details.setAge(age);
		details.setFirstName(firstName);
		details.setFirstName(lastName);

		return details;
	}
}
