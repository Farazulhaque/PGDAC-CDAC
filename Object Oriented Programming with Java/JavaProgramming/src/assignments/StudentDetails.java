package assignments;

import java.util.*;

class Student {
	String rollNo;
	String name;

	// setter to set roll no and name
	public void setRollNoName(String rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
}

// Exception class for invalid data format
class InvalidDataFormat extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "InvalidDataFormatException Caught";
	}
}

// main class
public class StudentDetails {
	public static void main(String[] args) throws InvalidDataFormat {
		// To check null pointer exception
		String details = null;
		System.out.println("You entered-> " + details);
		printDetails(details);
		// To check invalid data format exception
		details = "123";
		System.out.println("\nYou entered-> " + details);
		printDetails(details);
		// To check valid data format exception
		details = "0078:Faraz";
		System.out.println("\nYou entered-> " + details);
		printDetails(details);
	}

	private static void printDetails(String details) {
		// create object of Student class
		Student st = new Student();
		try {
			// first split string by :
			String[] data = details.split(":");
			// if there are more than two words
			if (data.length != 2) {
				try {
					throw new InvalidDataFormat();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// if there is exact 2 words
			else {
				// then assign first data to rollno
				// and second data to name
				String rollNo = data[0];
				String name = data[1];
				// and then set fields in Student class
				st.setRollNoName(rollNo, name);
				// Create ArrayList to store data
				ArrayList<String> studentDetails = new ArrayList<String>();
				studentDetails.add(st.rollNo);
				studentDetails.add(st.name);
				// printing data
				System.out.println("Roll No: " + studentDetails.get(0));
				System.out.println("Name : " + studentDetails.get(1));
			}
		}
		// if null value then through this exception
		catch (NullPointerException e) {
			System.out.println("NullPointerException Caught");
		}
	}
}
