import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author: Mohammad Almotaani
 * @since: 2023-02-23
 * 
 */

public class Pages {

	/* Don't let anyone instantiate this class */
	private Pages() {
	}

	private static ArrayList<User> user = new ArrayList<>();

	// displayUsers is a helper method that displays every signed user.
	private static void displayUsers() {
		int index = 1;

		System.out.println("\n\n#----------------|Users List|-------------------#");

		for (User u : user) {
			System.out.println("|" + index++ + "- " + u.getName());
		}

		System.out.println("#-----------------------------------------------#");
	}

	// Add new user to the users list.
	public static void addUser() {
		System.out.println("\n---Add user---");
		String name = Helper.input("Enter your name: ");

		// if the string is empty or contains only white spaces then, print error
		// message and return.
		if (name.isBlank()) {
			System.err.println("Failed to add user!");
			System.out.println("You must enter at least one chracter.");
			return;
		}

		for (User u : user) {
			// If the user name is already taken then, print error message and return.
			if (u.getName().equals(name)) {
				System.err.println("Failed to add user!");
				System.out.println("This name is already taken.\n\n");
				return;
			}
		}

		user.add(new User(name));
		System.out.println("The user has been added successfully\n");
	}

	// Start the quiz
	public static void start() {

		// If the users list is empty then, redirect to addUser().
		if (user.isEmpty()) {
			System.err.println("\nThere is no user in the list!");
			System.out.println("Please add a user first.");
			addUser();
			return;
		}

		displayUsers(); // Helper method

		int userNumber = Helper.inputInt("Enter user number: ");

		while (userNumber > user.size() || userNumber <= 0) {
			System.err.println("Invalid number!");
			userNumber = Helper.inputInt("Please enter a valid user number from the above list: ");
		}

		// Subtract userNumber by 1 to get the exact index in the 'user' array list.
		Quiz.convertingBases(user.get(userNumber - 1));

	}

	// Show leaderboard list.
	public static void showLeaderboard() {

		// If there are no user in the list, then stop the execution.
		if (user.isEmpty()) {
			System.out.println("\n\033[33m |!-----Leaderboard is empty-----!| \033[0m \n");
			return;
		}

		/*
		 * Comparator interface can be used to sort a collection of objects by a
		 * specific data member(Instance variable). For example, to obtain a Comparator
		 * that compares Person objects by their last name, Comparator<Person>
		 * byLastName = Comparator.comparing(Person::getLastName);
		 * 
		 * Using the Comparator interface to sort users by points. The comparator will
		 * sort the points in ascending order by default. To sort the objects in
		 * descending order, the reversed() method is used.
		 * 
		 * For more information about Comparator interface refer to
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
		 */
		Comparator<User> byPoints = Comparator.comparing(User::getPoints).reversed();
		user.sort(byPoints);

		System.out.println("\n\n#----------------|Leaderboard List|-----------------------#");

		int index = 1;

		for (User u : user) {
			System.out.println("|" + index++ + "- " + u);
		}

		System.out.println("#---------------------------------------------------------#\n");

	}

	// Use calculator. It dosen't required a signed user.
	public static void calculator() {
		int choice;
		String s; // Receive hexadecimal String or binary String or decimal String.

		System.out.println("\n==|Calculator|===");

		while (true) {

			System.out.println("\n\nEnter a number to use calculator.\n");
			System.out.println("(1) Binary to Decimal and Hexadecimal");
			System.out.println("(2) Decimal to Binary and Hexadecimal ");
			System.out.println("(3) Hexadecimal to Binary and Decimal");
			System.out.println("[4] Exit");
			choice = Helper.inputInt("\nEnter your choice: ");

			switch (choice) {

			case 1:
				s = Helper.input("\nEnter Binary number: ");
				try {
					System.out.println("Decimal value: " + Integer.parseInt(s, 2));
					System.out.println("Hexadecimal value: " + Integer.toString(Integer.parseInt(s, 2), 16));
				} catch (NumberFormatException e) {
					System.err.println("Invalid input!");
					System.out.println("Only zeros and ones accepted.");
				}
				break;

			case 2:
				s = Helper.input("\nEnter decimal number: ");
				try {
					System.out.println("Binary value: " + Integer.toBinaryString(Integer.parseInt(s)));
					System.out.println("Hexadecimal value: " + Integer.toHexString(Integer.parseInt(s)));
				} catch (NumberFormatException e) {
					System.err.println("Invalid input!");

				}

				break;

			case 3:
				s = Helper.input("\nEnter Hexadecimal number: ");
				try {
					System.out.println("Binary value: " + Integer.toBinaryString(Integer.parseInt(s, 16)));
					System.out.println("Decimal value: " + Integer.parseInt(s, 16));
				}

				catch (NumberFormatException e) {
					System.err.println("Invalid input!");
					System.out.println("The allowed characters: 0-9 and A-F.");

				}
				break;

			case 4:
				System.out.println("\n");
				return;

			default:
				System.err.println("Invalid number!");
				System.out.println("You can only input 1, 2, 3, and 4 NOT " + choice);
			}

		}
	}

	// internal main method to test the methods.
	public static void main(String[] testPages) {
		addUser();
		start();

		addUser();
		start();

		showLeaderboard();
		calculator();
		System.out.println("End of program");
	}
}
