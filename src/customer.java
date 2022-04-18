// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.sql.Date;

public class customer{
	private static Date dateCreated;
	private static String name;
	private static Date dateOfBirth;
	private static gender gender;
	private static String phoneNumber;
	private static String emailAddress;
	private static Integer numberOfOrders;
	
	public static Date getDateCreated() {
		return dateCreated;
	}
	public static void setDateCreated(Date dateCreated) {
		customer.dateCreated = dateCreated;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		customer.name = name;
	}
	public static Date getDateOfBirth() {
		return dateOfBirth;
	}
	public static void setDateOfBirth(Date dateOfBirth) {
		customer.dateOfBirth = dateOfBirth;
	}
	public static gender getGender() {
		return gender;
	}
	public static void setGender(gender gender) {
		customer.gender = gender;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		customer.phoneNumber = phoneNumber;
	}
	public static String getEmailAddress() {
		return emailAddress;
	}
	public static void setEmailAddress(String emailAddress) {
		customer.emailAddress = emailAddress;
	}
	public static Integer getNumberOfOrders() {
		return numberOfOrders;
	}
	public static void setNumberOfOrders(Integer numberOfOrders) {
		customer.numberOfOrders = numberOfOrders;
	}
	
}
	