/**
	Main menu for the registration system.

	First provide an easy way for the student to log in.  Not much security,
	this is a very simple system.  The student just enters their id and they
	are in.

	Various menu items that are implemented here:
		- View the current registrations
			For the student that has logged in, list the courses this student
			is registered for.

		- View a listing of courses
			Simply list out the courses that are in the system.

		- Register for a course
			For the student that has logged in, register them for a course.

		- Unregister for a course
			For the studen that has logged in, unregister them for a course.

		- Exit
			Quit the registration system.

*/

import java.util.Scanner;

public class Menu {

	String studentLoggedIn;

	public Menu() {

	}

	public void loginScreen() {
		String message  = "\n"
						+ "Welcome to the student registration system.\n"
						+ "Please enter your student id:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		studentLoggedIn = reader.nextLine();

		this.mainMenu();
	}

	public void mainMenu() {
		String message  = "\n"
						+ "Menu:\n"
						+ "----------------------------------\n"
						+ "1. View your current registrations\n"
						+ "2. View a listng of courses\n"
						+ "3. Register for a course\n"
						+ "4. Unregister for a course\n"
						+ "5. Exit the System\n"
						+ "\n"
						+ "Please enter a selection:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		Integer input = reader.nextInt();

		switch(input) {
			case 1:	this.listCoursesEnrolled();
					break;

			case 2: this.courseListing();
					break;

			case 3: this.registerMenu();
					break;

			case 4: this.unregisterMenu();
					break;

			case 5: this.exitMenu();
					break;

			default: this.exitMenu();
					break;

		}



	}

	public void listCoursesEnrolled() {
		String message  = "\n"
						+ "Courses you are currently enrolled in:\n"
						+ "---------------------------------------";
		System.out.println(message);

		this.mainMenu();
	}

	public void courseListing() {
		String message  = "\n"
						+ "Course listing:\n"
						+ "-----------------------------------------------";
		System.out.println(message);

		this.mainMenu();
	}

	public void registerMenu() {
		String message  = "\n"
						+ "Register Menu\n"
						+ "----------------------------------------------------------\n"
						+ "Please enter the course ID you would like to register for:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		System.out.println(input);

		this.mainMenu();

	}

	public void unregisterMenu() {
		String message  = "\n"
						+ "Unregister Menu\n"
						+ "------------------------------------------------------------\n"
						+ "Please enter the course ID you would like to unregsiter for:";
		System.out.println(message);

		this.mainMenu();
	}

	public void errorRegistration(){
		String message  = "\n"
						+ "Sorry, you could not register for that class.";
		System.out.println(message);

		this.mainMenu();
	}

	public void exitMenu() {
		String message  = "\n"
						+ "Thanks for using the registration system.\n"
						+ "Peace out.";
		System.out.println(message);

		System.exit(0);
	}


}