// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

public class address extends membership{
	private static String addressLine1;
	private static String addressLine2;
	private static String suburb;
	private static state state;
	private static String postCode;
	private static Boolean inDeliveryRange;
	
	public static String getAddressLine1() {
		return addressLine1;
	}
	public static void setAddressLine1(String addressLine1) {
		address.addressLine1 = addressLine1;
	}
	public static String getAddressLine2() {
		return addressLine2;
	}
	public static void setAddressLine2(String addressLine2) {
		address.addressLine2 = addressLine2;
	}
	public static String getSuburb() {
		return suburb;
	}
	public static void setSuburb(String suburb) {
		address.suburb = suburb;
	}
	public static state getState() {
		return state;
	}
	public static void setState(state state) {
		address.state = state;
	}
	public static String getPostCode() {
		return postCode;
	}
	public static void setPostCode(String postCode) {
		address.postCode = postCode;
			Boolean inRange;
			if (postCode.length() > 0) {
				Integer convertedInt = Integer.parseInt(postCode);
				if (convertedInt >= 2000 && convertedInt <= 2200 && convertedInt != null) {
				inRange = true;
				}
				else {
				inRange = false;
				}
				address.inDeliveryRange = inRange;
				}
		}

	public static Boolean getInDeliveryRange() {
		return inDeliveryRange;
	}
}