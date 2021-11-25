package assignments;

import java.util.*;

// exception to catch Invalid date
class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "InvalidDateException Caught";
	}
}

// exception to catch Invalid return date
class InvalidReturnDateException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "InvalidReturnDateException Caught";
	}
}

// main class
public class BookDate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get user input issue date
		System.out.println("Enter book issue date in dd/mm/yyyy format: ");
		String date1 = sc.next();
		// to check date is valid or not
		// first split string by / and then assign
		// each value to d1, m1, y1
		String[] data1 = date1.split("/");
		int d1 = Integer.parseInt(data1[0]);
		int m1 = Integer.parseInt(data1[1]);
		int y1 = Integer.parseInt(data1[2]);
		// create object of Calendar class
		Calendar bookIssueDate;
		try {
			// check date is valid or not
			checkDate(date1);
			// if date1 is valid then assign d1, m1, y1 to object of
			// Calender class bookIssueDate using GregorianCalendar() constructor
			bookIssueDate = new GregorianCalendar(y1, m1, d1);
			// get book return date
			System.out.println("Enter book return date in dd/mm/yyyy format: ");
			String date2 = sc.next();
			String[] data2 = date2.split("/");
			int d2 = Integer.parseInt(data2[0]);
			int m2 = Integer.parseInt(data2[1]);
			int y2 = Integer.parseInt(data2[2]);
			// create object of Calendar class
			Calendar bookReturnDate;
			try {
				// check date is valid or not
				checkDate(date2);
				// if date2 is valid then assign d2, m2, y2 to object of
				// Calender class bookIssueDate using GregorianCalendar() constructor
				bookReturnDate = new GregorianCalendar(y2, m2, d2);
				try {
					// now check return date is after issue date or not
					checkReturnDate(bookIssueDate, bookReturnDate);
					// if valid then print valid date
					System.out.println("Book issue date and Book return date are valid.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

	// method to check if date is valid or not
	// check for leap year, day, month
	public static void checkDate(String date) throws InvalidDateException {
		// split date by /
		// to get date, month and year from string
		// and check all separately
		String[] data = date.split("/");
		int d = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);
		int y = Integer.parseInt(data[2]);
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (y > 1900 && y <= 9999) {
			// check leap year
			if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
				days[1]++;
			}
			if (m > 0 && m <= 12) {
				if (d > 0 && d < days[m - 1]) {
					// valid date
				} else {
					throw new InvalidDateException();
				}
			} else {
				throw new InvalidDateException();
			}
		} else {
			throw new InvalidDateException();
		}
	}

	// if book issue date is after book return date then through
	// InvalidReturnDateException
	public static void checkReturnDate(Calendar bookIssueDate, Calendar bookReturnDate)
			throws InvalidReturnDateException {
		if (bookIssueDate.after(bookReturnDate)) {
			System.out.println("Book issue date is after book return date.");
			throw new InvalidReturnDateException();
		}
	}
}