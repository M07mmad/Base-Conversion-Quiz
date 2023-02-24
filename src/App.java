/**
 * @author: Mohammad Almotaani
 * @since: 2023-02-23
 * @version: 1.0
 */

public class App {

	public static void main(String[] args) {
		int userChoice;
		
		while (true) {

			System.out.println("====|Choose an option|====");
			System.out.println("(1) Add user ");
			System.out.println("(2) Start Quiz");
			System.out.println("(3) Show leaderboard");
			System.out.println("(4) Use calculator");
			System.out.println("[5] Exit"); // The program will terminate if and only if userChoice = 5

			userChoice = Helper.inputInt("Enter your choice: ");

			switch (userChoice) {
			
			case 1:
				Pages.addUser();
				break;

			case 2:
				Pages.start();
				break;

			case 3:
				Pages.showLeaderboard();
				break;

			case 4:
				Pages.calculator();
				break;

			case 5:
				System.out.println("\n\n|===Thank you===|");
				System.out.println("|======END======|");
				System.exit(0);

			default:
				System.err.println("\nInvalid number!");
				System.out.println("Valid numbers: 1, 2, 3, 4 not " + userChoice + "!\n\n");
			}
		}

	}
}
