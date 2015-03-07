/**
 *	Main menu for the registration system.
 *
 *	First provide an easy way for the student to log in.  Not much security,
 *	this is a very simple system.  The student just enters their id and they
 *	are in.
 *
 *	Various menu items that are implemented here:
 *		- View the current registrations
 *			For the student that has logged in, list the courses this student
 *			is registered for.
 *
 *		- View a listing of courses
 *			Simply list out the courses that are in the system.
 *
 *		- Register for a course
 *			For the student that has logged in, register them for a course.
 *
 *		- Unregister for a course
 *			For the studen that has logged in, unregister them for a course.
 *
 *		- Exit
 *			Quit the registration system.
 *
 */

import java.util.Scanner;

public class Menu {

	String studentLoggedIn;

	public Menu() {

	}


	/**
	 * Show the login screen, have student login before showing menu.
	 */
	public void loginScreen() {

		String message  = "\n"
						+ "Welcome to the student registration system.\n"
						+ "Please enter your student id:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		studentLoggedIn = reader.nextLine();


		message = "\n"
				+ "              WELCOME TO THE TEAM E COURSE REGISTRATION SYSTEM\n"
				+ "  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
				+ "\n"
				+ "         (`.  : \\               __..----..__\n"
				+ "          `.`.| |:          _,-':::''' '  `:`-._\n"
				+ "            `.:\\||       _,':::::'         `::::`-.\n"
				+ "              \\\\`|    _,':::::::'     `:.     `':::`.\n"
				+ "               ;` `-''  `::::::.                  `::\\\n"
				+ "            ,-'      .::'  `:::::.         `::..    `:\\\n"
				+ "          ,' /_) -.            `::.           `:.     |\n"
				+ "        ,'.:     `    `:.        `:.     .::.          \\\n"
				+ "   __,-'   ___,..-''-.  `:.        `.   /::::.         |\n"
				+ "  |):'_,--'           `.    `::..       |::::::.      ::\\\n"
				+ "   `-'                 |`--.:_::::|_____\\::::::::.__  ::|\n"
				+ "                       |   _/|::::|      \\::::::|::/\\  :|\n"
				+ "                       /:./  |:::/        \\__:::):/  \\  :\\\n"
				+ "                     ,'::'  /:::|        ,'::::/_/    `. ``-.__\n"
				+ "                    ''''   (//|/\\      ,';':,-'         `-.__  `'--..__\n"
                + "                                                             `''---::::'\n"
				+ "  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
				+ "\n"
				+ "You are logged in with student id: " + studentLoggedIn;
        System.out.println(message);
		this.mainMenu();
	}


	/**
	 * Show the main menu for the registration system.
	 */
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


	/**
	 * List the courses that the student is enrolled in.
	 */
	public void listCoursesEnrolled() {

		String message  = "\n"
						+ "Courses you are currently enrolled in:\n"
						+ "-----------------------------------------------";
		System.out.println(message);

		// ***********************************************************************************
		// -----------------------------------------------------------------------------------
		// MAKE CALL TO SASI'S CODE TO GET THE COURSES FROM STUDENT
		// studentLoggedIn
		// -----------------------------------------------------------------------------------
		// ***********************************************************************************

		this.mainMenu();
	}


	/**
	 * List the courses available in the registration system.
	 */
	public void courseListing() {

		String message  = "\n"
						+ "Course listing:\n"
						+ "---------------------------------------";
		System.out.println(message);

		// ***********************************************************************************
		// -----------------------------------------------------------------------------------
		// MAKE CALL TO SASI'S CODE TO GET THE COURSES
		// studentLoggedIn
		// -----------------------------------------------------------------------------------
		// ***********************************************************************************

		this.mainMenu();
	}


	/**
	 * Registration menu for a student.
	 * Asks student for the course ID.
	 */
	public void registerMenu() {

		String message  = "\n"
						+ "Register Menu\n"
						+ "----------------------------------------------------------\n"
						+ "Please enter the course ID you would like to register for:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		System.out.println(input);

		Boolean registered = false;
		// ***********************************************************************************
		// -----------------------------------------------------------------------------------
		// MAKE CALL TO SASI'S CODE TO ALTER THE STUDENT REGISTRATION
		// studentLoggedIn
		// -----------------------------------------------------------------------------------
		// ***********************************************************************************

		if(registered) {
			// if successful resgistration
			message = "\n"
					+ "You have successfully register for: " + input + "\n";
			System.out.println(message);
			this.mainMenu();
		}

		else {
			message = "\n"
					+ "You could not register for: " + input + "\n";
		}

		System.out.println(message);
		this.mainMenu();
	}


	/**
	 * Unregistration menu for a student.
	 * Asks student for the course ID.
	 */
	public void unregisterMenu() {

		String message  = "\n"
						+ "Unregister Menu\n"
						+ "------------------------------------------------------------\n"
						+ "Please enter the course ID you would like to unregsiter for:";
		System.out.println(message);

		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();

		Boolean unregistered = false;
		// ***********************************************************************************
		// -----------------------------------------------------------------------------------
		// MAKE CALL TO SASI'S CODE TO ALTER THE TEXT FILES
		// studentLoggedIn
		// -----------------------------------------------------------------------------------
		// ***********************************************************************************

		if(unregistered) {
			message = "\n"
					+ "You have successfully unregistered from: " + input + "\n";
		}

		else {
			message = "\n"
					+ "You could not unregister from: " + input + "\n";
		}

		System.out.println(message);
		this.mainMenu();
	}


	/**
	 * Show exit screen.
	 */
	public void exitMenu() {

		String message  = "\n"
						+ "          YOU ARE NOW LOGGED OUT\n"
						+ "  * * * * * * * * * * * * * * * * * * * *\n"
						+ "               _.---._    /\\\\\n"
					    + "            ./'       \"--'\\/\n"
					    + "          ./              o \\\n"
					    + "         /./\\  )______   \\__ \"\n"
					    + "        ./  / /\\ \\   | \\ \\  \\ \\\n"
					    + "           / /  \\ \\  | |\\ \\  \\7\n"
						+ "  * * * * * * * * * * * * * * * * * * * *\n"
						+ " Thanks for using the registration system.\n"
						+ " Peace out.";
		System.out.println(message);

		System.exit(0);
	}


}