/**
 * @author: Mohammad Almotaani
 * @since: 2023-02-23
 * 
 */

public class User {

	private String name;
	private int totalPoints;

	// default constructor
	public User() {
		name = "No name yet.";
	}

	public User(String name) {
		this.name = name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void addPoints(int points) {
		// If the points are negative, then add 0 to the total points. Otherwise, add
		// the argument value to the total points.
		totalPoints += points < 0 ? 0 : points;
	}

	public int getPoints() {
		return totalPoints;
	}

	public String toString() {
		return name + " | Points: " + totalPoints;
	}

	public static void main(String[] testUser) {

		User user = new User("User Test");
		System.out.println("User name before: " + user.getName());

		user.setName("Mohammad");
		System.out.println("User name after : " + user.getName());

		System.out.println("User points before: " + user.getPoints());

		user.addPoints(20);

		System.out.println("User points after: " + user.getPoints());

		user.addPoints(-10);
		System.out.println("Try to add negative number to userPoints attribute.\nThe result should not be changed.");
		System.out.println("User points after: " + user.getPoints());

		System.out.println(user);

	}

}
