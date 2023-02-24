/**
 * @author: Mohammad Almotaani
 * @since: 2023-02-23
 * 
 */

public class Quiz {

	/* Don't let anyone instantiate this class */
	private Quiz() {
	}

	/**
	 * This method will start the quiz. The method should receive an argument of the
	 * type User to add the points to the specified user at the end of the quiz.
	 */
	public static void convertingBases(User user) {

		/*
		 * Note that there are odd codes with these Strings like '\033[32m', for more
		 * information about these codes go to
		 * https://en.wikipedia.org/wiki/ANSI_escape_code
		 */
		final String GREEN_TRUE = "\033[32m True \033[0m";
		final String RED_FALSE = "\033[31m False \033[0m";

		System.out.println("\n===|Choose difficulty|===\n(1) Practice\n(2) Easy\n(3) Medium\n(4) Hard");

		// Variable 'diff' will store the user difficulty choice.
		int diff = Helper.inputInt("\nEnter difficulty number: ");

		/*
		 * Check if the user input is accepted using loop. Accepted inputs: 1, 2, 3, 4.
		 * If the input is not accepted, then the loop will repeat. If the input is
		 * accepted, then the loop will not be executed.
		 */
		while (diff < 1 || diff > 4) {
			System.err.println("\nInvalid difficulty number!");
			diff = Helper.inputInt("Enter a valid difficulty number: ");
		}

		/*
		 * Depending on user choice, the values of the variables below will be changed
		 * after entering the switch statement.
		 * 
		 * String difficulty: It could be Easy or any other difficulties. int min: Store
		 * the minimum value of the questions. int max: Store the maximum value of the
		 * questions. int maximumTime: Store the required time to get a bonus. int
		 * minimumGrade: Store the required points to get a bonus. int bonus: Store the
		 * bonus points. For example, it could be 1 or 5 depending on difficulty. int
		 * userGrade: Store the user grade. If the user writes a correct answer then,
		 * the points will increase. String[] answers: An array to store the correct
		 * answer to show at the end of the quiz.
		 * 
		 */
		String difficulty = "";
		int min = 0; // 16
		int max = 0; // 25
		int maximumTime = 0;
		int minimumGrade = 0;
		int bonus = 0;
		int userGrade = 0;
		String[] answers = new String[6];

		switch (diff) {
		case 1:
			difficulty = "Practice \n*Note: Since you are in practice mood, you will not earn any points.";
			min = 1;
			max = 17;
			maximumTime = 0;
			bonus = 0;
			minimumGrade = 0;
			break;

		case 2:
			difficulty = "Easy";
			min = 16;
			max = 25;
			maximumTime = 120; 
			bonus = 1;
			minimumGrade = 5;
			break;

		case 3:
			difficulty = "Medium";
			min = 64;
			max = 129;
			maximumTime = 200;
			bonus = 3;
			minimumGrade = 4;
			break;

		case 4:
			difficulty = "Hard";
			min = 128;
			max = 513;
			maximumTime = 480;
			bonus = 5;
			minimumGrade = 3;
			break; // the break statement is not necessary here :)

		}

		/*
		 * randomValue: random integer between the minimum value and maximum value
		 * depending on difficulty. userAnswer : the user answer will be stored here to
		 * compare it with the correct answer. correctAnswer: the correct answer will be
		 * stored here to check if the user input is correct. startTime: Store the time
		 * in nanoseconds.
		 *
		 * For more information about time in nanoseconds and 'System.nanoTime()' go to
		 * https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#nanoTime--
		 *
		 */

		int randomValue;
		String userAnswer;
		String correctAnswer;
		long startTime = System.nanoTime();

		/*
		 * The operation of questions will be: 1- Generate a random integer between the
		 * minimum value and maximum value 2- Store the correct answer 3- The question
		 * appears 4- The user asked to enter the answer 5- Check the answer 6- if the
		 * answer is correct then the user will get point
		 * 
		 * At the end of questions the program displays the quiz result and the correct
		 * answers.
		 * 
		 */

		// Question 1: convert from binary to decimal
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Integer.toString(randomValue);

		System.out.printf("\nConvert %s(base = 2) to Decimal number.\n", Helper.bin(randomValue));
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[0] = "1- " + GREEN_TRUE;
		} else {
			answers[0] = "1- " + RED_FALSE + "---> " + correctAnswer;
		}

		// Question 2: convert from binary to hexadecimal
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Helper.hex(randomValue);

		System.out.printf("\nConvert %s(base = 2) to Hexadecimal number.\n", Helper.bin(randomValue));
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[1] = "2- " + GREEN_TRUE;
		} else {
			answers[1] = "2- " + RED_FALSE + "---> " + correctAnswer;
		}

		// Question 3: convert from decimal to binary
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Helper.bin(randomValue);

		System.out.printf("\nConvert %d(base = 10) to Binary number.\n", randomValue);
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[2] = "3- " + GREEN_TRUE;
		} else {
			answers[2] = "3- " + RED_FALSE + "---> " + correctAnswer;
		}

		// Question 4: convert from decimal to hexadecimal
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Helper.hex(randomValue);

		System.out.printf("\nConvert %d(base = 10) to Hexadecimal number.\n", randomValue);
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[3] = "4- " + GREEN_TRUE;
		} else {
			answers[3] = "4- " + RED_FALSE + "---> " + correctAnswer;
		}

		// Question 5: convert from hexadecimal to binary
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Helper.bin(randomValue);

		System.out.printf("\nConvert %s(base = 16) to Binary number.\n", Helper.hex(randomValue));
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[4] = "5- " + GREEN_TRUE;
		} else {
			answers[4] = "5- " + RED_FALSE + "---> " + correctAnswer;
		}

		// Question 6: convert from hexadecimal to decimal
		randomValue = Helper.generateRandomInteger(min, max);
		correctAnswer = Integer.toString(randomValue);

		System.out.printf("\nConvert %s(base = 16) to Decimal number.\n", Helper.hex(randomValue));
		userAnswer = Helper.input("Enter your answer: ");

		if (Helper.checkAnswer(userAnswer, correctAnswer)) {
			userGrade++;
			answers[5] = "6- " + GREEN_TRUE;
		} else {
			answers[5] = "6- " + RED_FALSE + "---> " + correctAnswer;
		}

		/*
		 * elapsedTime: the variable will store the elapsed time in seconds. The formula
		 * for calculating elapsed time is elapsed time = end time – start time In our
		 * case end time = System.nanoTime() and start time = startTime The result is
		 * elapsed time in nanoseconds but we want to convert nanoseconds to seconds. To
		 * convert nanoseconds to seconds, divide nanoseconds by 1000000000 (one
		 * billion).
		 */
		long elapsedTime = (System.nanoTime() - startTime) / 1000000000;

		// Printing quiz result
		System.out.println("\n\n#_-_-_-_-_-_-_-_-_-_-_-_|QuizResult|-_-_-_-_-_-_-_-_-_-_-#");

		System.out.printf("|User: %s \n", user.getName());
		System.out.println("|Difficulty: " + difficulty);

		System.out.printf("|Your grade is %d out of 6 \n", userGrade);

		// If the difficulty level is practice then you will not earn any points.
		userGrade = diff == 1 ? 0 : userGrade;

		System.out.println("|Duration: " + elapsedTime + " second(s)");

		/*
		 * If the user grade is greater than or equal minimum grade and elapsed time is
		 * less than or equal maximumTime then the user will get a bonus depending on
		 * difficulty otherwise the user will not get a bonus
		 */
		bonus = userGrade >= minimumGrade && elapsedTime <= maximumTime ? bonus : 0;

		System.out.println("|Time Bonus: " + bonus);
		System.out.println("|Total points: " + (userGrade + bonus));
		user.addPoints(userGrade + bonus); // adding points to the field totalPoints.

		System.out.println("#_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-#\n\n");

		// Print all answers. True if the answer is correct, False if the answer is
		// wrong and show the correct answer.
		System.out.println("#=========Answers=========#");

		for (String a : answers) {
			System.out.println(a);
		}

		System.out.println("#=========--------========#");

		System.out.println("\n#---Quiz Complete---#\n\n");
	}

	public static void main(String[] testQuiz) {
		User user = new User("user");

		convertingBases(user);
		System.out.println("Points: " + user.getPoints());

		convertingBases(user);

		System.out.println("Points: " + user.getPoints());

		System.out.println("-_-_-_-END OF TEST QUIZ-_-_-_-");
	}
}
