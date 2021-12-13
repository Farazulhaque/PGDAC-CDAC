//By using the collection classes in the collections framework, write a program which will display all Student class objects
//in either the order of name, or roll number, or percentage of marks, as per the choice given by the user for ordering
//objects

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
	String name;
	int rollno;
	double marks;

	public Student(String name, int rollno, double marks) {
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}

	public String toString() {
		String roll = String.valueOf(rollno);
		String mark = String.valueOf(marks);
		name = String.format("%-10s", name);
		roll = String.format("%-10s", roll);
		mark = String.format("%6s", mark);
		return name + "" + roll + "" + mark;
	}
}

class SortByRoll implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.rollno > o2.rollno) {
			return 1;
		} else if (o1.rollno < o2.rollno) {
			return -1;
		} else {
			return 0;
		}
	}

}

class SortByMarks implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.marks > o2.marks) {
			return 1;
		} else if (o1.marks < o2.marks) {
			return -1;
		} else {
			return 0;
		}
	}

}

class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.name.compareTo(o2.name);
	}

}

public class StudentClass {

	public static void main(String[] args) {

		ArrayList<Student> st = new ArrayList<Student>();
		st.add(new Student("faraz", 201, 80));
		st.add(new Student("arisha", 301, 70));
		st.add(new Student("parwez", 20, 75));
		st.add(new Student("rahul", 50, 100));
		int choice = getChoice();
		while (choice != 4) {
			System.out.printf("\n%-10s%-10s%6s\n", "Name", "RollNo", "Marks");
			System.out.println("--------------------------");
			if (choice == 1) {
				Collections.sort(st, new SortByName());
				for (int i = 0; i < st.size(); i++) {
					System.out.println(st.get(i));
				}
			} else if (choice == 2) {
				Collections.sort(st, new SortByRoll());
				for (int i = 0; i < st.size(); i++) {
					System.out.println(st.get(i));
				}
			} else if (choice == 3) {
				Collections.sort(st, new SortByMarks());
				for (int i = 0; i < st.size(); i++) {
					System.out.println(st.get(i));
				}
			} else {
				System.out.println("Invalid choice.");
			}
			choice = getChoice();
		}

	}

	public static int getChoice() {
		System.out.println("\nEnter 1 to sort by name.");
		System.out.println("Enter 2 to sort by rollno.");
		System.out.println("Enter 3 to sort by marks.");
		System.out.println("Enter 4 to quit.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;
	}

}
