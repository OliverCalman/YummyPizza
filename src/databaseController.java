// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseController {
	//messaging for dialogs
private static String msgText;
private static String searchParam;

public static String getMsgText() {
	return msgText;
}

public static void setMsgText(String msgText) {
	databaseController.msgText = msgText;
}

public static void setSearchParam(String searchParam) {
	databaseController.searchParam = searchParam;
}

// checks to see if member exists and returns member number only, based on name.
public static boolean checkMembership() throws Exception {
  Class.forName("com.mysql.cj.jdbc.Driver");
  final String url = "jdbc:mysql:///membershipdb";
  final String user = "root";
  final String password = "admin";

  Connection con = DriverManager.getConnection(url, user, password);

  Statement preparedStatement = con.createStatement();
  String query = "SELECT * FROM `membershipdb`.`customer` WHERE name = '" + customer.getName() + "'";
  ResultSet returnedResults = preparedStatement.executeQuery(query);
  boolean exists = false;

  while (returnedResults.next()) {
      exists = true;
      membership.setMemberNumber(returnedResults.getString( "memberNumber" ));
   }
  
  
  if(exists == true) {
     msgText = ("Existing membership found with member number " + membership.getMemberNumber());
     con.close();
     return true;
     
  } else {
     System.out.println("No existing membership found.");
     con.close();
    return false;
  			}
		}

//returns details on a member based on search parameters. Users can search by name or member number
public static void getMemberDetails() throws Exception {
  Class.forName("com.mysql.cj.jdbc.Driver");
  final String url = "jdbc:mysql:///membershipdb";
  final String user = "root";
  final String password = "admin";

  Connection con = DriverManager.getConnection(url, user, password);

  Statement preparedStatement5 = con.createStatement();
  String query = "select * from `membershipdb`.`customer` left join `address` on 	`address`.memberNumber = `customer`.memberNumber WHERE name = '" + searchParam + "' OR `customer`.memberNumber = '" + searchParam + "';";
  ResultSet returnedResults = preparedStatement5.executeQuery(query);
  while (returnedResults.next()) {
      membership.setMemberNumber(returnedResults.getString("memberNumber"));
      customer.setName(returnedResults.getString("name"));
      customer.setDateOfBirth(returnedResults.getDate("dateOfBirth"));
      
      if (returnedResults.getString("gender") != null) {
      customer.setGender(gender.valueOf(returnedResults.getString("gender")));
      }
      customer.setPhoneNumber(returnedResults.getString("phoneNumber"));
      customer.setEmailAddress(returnedResults.getString("emailAddress"));
      address.setAddressLine1(returnedResults.getString("addressLine1"));
      address.setAddressLine2(returnedResults.getString("addressLine2")); 
      address.setSuburb(returnedResults.getString("suburb")); 
      
      if (returnedResults.getString("state") != null) {
      address.setState(state.valueOf(returnedResults.getString("state")));
      }
      address.setPostCode(returnedResults.getString("postCode"));
  		}  
   }

//creates a new member
public static String setMemberNumber() throws Exception {
	
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      final String url = "jdbc:mysql:///membershipdb";
	      final String user = "root";
	      final String password = "admin";

	      Connection con = DriverManager.getConnection(url, user, password);

	      Statement preparedStatement1 = con.createStatement();
	      String insertCustomer = "INSERT INTO `membershipdb`.`customer` (name, dateCreated, dateOfBirth, gender, phoneNumber, "
	      		+ "emailAddress) VALUES ('"+ customer.getName() + "', '" + customer.getDateCreated() + "', '"+ customer.getDateOfBirth() + "', '" + customer.getGender() 
	      		+ "','" + customer.getPhoneNumber() + "', '" + customer.getEmailAddress() + "');";
	      preparedStatement1.executeUpdate(insertCustomer);
	      

	      
	      Statement preparedStatementCheck = con.createStatement();
	      String selectNum = "select `memberNumber` from `membershipdb`.`customer` where name = '" + customer.getName() + "';";
	      ResultSet numEnquiry = preparedStatementCheck.executeQuery(selectNum);
	      
	      while (numEnquiry.next()) {
	      membership.setMemberNumber(numEnquiry.getString( "memberNumber" ));
	      }
	      
		  Statement preparedStatement2 = con.createStatement();
		  String insertAddress = "INSERT INTO `membershipdb`.`address` (memberNumber, addressLine1, addressLine2, suburb, state, postCode, inDeliveryRange) "
				  + "VALUES ('"+ membership.getMemberNumber() + "','" + address.getAddressLine1() + "', '" + address.getAddressLine2() + "', '"+ address.getSuburb() + "', '" + address.getState() 
		      		+ "','" + address.getPostCode() + "','" + address.getInDeliveryRange() +"');";
		      preparedStatement2.executeUpdate(insertAddress);
	      
		return membership.getMemberNumber();

	      
	      }

//updates a member record
public static void  updateMemberDetails() throws Exception {
	
      Class.forName("com.mysql.cj.jdbc.Driver");
      final String url = "jdbc:mysql:///membershipdb";
      final String user = "root";
      final String password = "admin";

      Connection con = DriverManager.getConnection(url, user, password);

      Statement preparedStatement3 = con.createStatement();
      String updateCustomer = "UPDATE `membershipdb`.`customer` SET name = '"+ customer.getName() + "', "
      		+ "dateOfBirth = '"+ customer.getDateOfBirth() + "', gender = '" + customer.getGender() + "', phoneNumber = '" +  customer.getPhoneNumber() + "', emailAddress = '" 
    		  + customer.getEmailAddress() + "' WHERE memberNumber = '" + membership.getMemberNumber() + "';";
      		
      Statement preparedStatement4 = con.createStatement();
      String updateAddress = "UPDATE `membershipdb`.`address` SET addressLine1 = '"+ address.getAddressLine1() + "', addressLine2 = '" + address.getAddressLine2() + "', "
      		+ "suburb = '"+ address.getSuburb() + "', state = '" + address.getState() + "', postCode = '" +  address.getPostCode() +"', inDeliveryRange = '" +  address.getInDeliveryRange() +"' WHERE memberNumber = '" + membership.getMemberNumber() + "';";
            		
      preparedStatement3.executeUpdate(updateCustomer);
      preparedStatement4.executeUpdate(updateAddress);
      
      }

//deletes a member
public static void  deleteMember() throws Exception {
	
      Class.forName("com.mysql.cj.jdbc.Driver");
      final String url = "jdbc:mysql:///membershipdb";
      final String user = "root";
      final String password = "admin";

      Connection con = DriverManager.getConnection(url, user, password);

      Statement preparedStatement5 = con.createStatement();
      String deleteCustomer = "DELETE FROM `membershipdb`.`customer` WHERE memberNumber = '" + membership.getMemberNumber() + "';";
      		
      Statement preparedStatement6 = con.createStatement();
      String deleteAddress = "DELETE FROM `membershipdb`.`address` WHERE memberNumber = '" + membership.getMemberNumber() + "';";
            		
      preparedStatement5.executeUpdate(deleteCustomer);
      preparedStatement6.executeUpdate(deleteAddress);
   
      
      }

//sets all values to null, used when searching or refreshing as Java doesn't like manual garbage management
public static void voidQuery() {
	membership.setMemberNumber(null);
	customer.setName(null);
    customer.setDateOfBirth(null);	
    customer.setGender(null);
    customer.setPhoneNumber(null);
    customer.setEmailAddress(null);
    address.setAddressLine1(null);
    address.setAddressLine2(null); 
    address.setSuburb(null); 
    address.setState(null);
		}  
}
