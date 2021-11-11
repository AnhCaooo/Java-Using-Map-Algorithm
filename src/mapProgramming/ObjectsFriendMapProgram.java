package mapProgramming;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ObjectsFriendMapProgram {

	public static void main(String[] args) {

		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {
				addFriend();
			} else if (choice == 2) {
				findFriend();
			} else if (choice == 3) {
				deleteFriend();
			} else if (choice == 4) {
				printFriends();
			} else {
				System.out.println("Please enter a number between 0 and 4");
			}

			choice = getChoice();
		}

		System.out.println("Bye!");
	}

	private static Map<String, Friend> friendData = new HashMap<String, Friend>();
	private static Scanner input = new Scanner(System.in);
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	// Get choice method
	// Only allow the value which is integer from 0-4
	public static int getChoice() {
		System.out.println("1 = Add friend | 2 = Find friend | 3 = Delete friend | 4 = Print friends | 0 = Quit");
		try {
			System.out.print("Enter choice: ");
			int choice = Integer.parseInt(input.nextLine());
			System.out.println();
			return choice;
		} catch (NumberFormatException nfe) { // Make exception if input is not an integer
			System.out.println("Please enter a number between 0 and 4");
			System.out.println();
			return getChoice();
		}
	}

	// Add friend method
	public static void addFriend() {

		boolean checkDuplicateNickname = false;

		// Ask user to give nicknam
		System.out.print("Enter nickname: ");
		String nickname = input.nextLine();

		String denyAddFriend = nickname + " is already in use!";

		// Check nickname if it exists or not
		// If nickname duplicate prints the deny
		// Otherwise ask for input
		for (Friend friendArray : friendData.values()) {
			if (friendArray.getNickName().equals(nickname)) {
				checkDuplicateNickname = true;
				System.out.println(denyAddFriend);
				System.out.println();
			}
		}
		if (checkDuplicateNickname == false) {
			System.out.print("Enter name: ");
			String name = input.nextLine();

			String birthdate;

			// Ask user to give birthdate
			System.out.print("Enter birthdate (dd.mm.yyyy): ");
			birthdate = input.nextLine();

			try {
				// Validate given date
				LocalDate localDate = LocalDate.parse(birthdate, formatter);

				// Add data to Map
				friendData.put(nickname, new Friend(nickname, name, birthdate));

			} catch (DateTimeException e) {
				System.out.println("Invalid date: " + birthdate);

			}

			System.out.println();
		}

	}

	// Find friend method
	public static void findFriend() {

		//Ask for input nickname
		System.out.print("Enter nickname: ");
		String foundNickName = input.nextLine();

		boolean checkName = false;
		
		//Find nickname in the data
		for (Friend friendArray : friendData.values()) {
			checkName = true; // if nickname exist then checkName will be assign to true value
			if (friendArray.getNickName().equals(foundNickName)) {
				System.out.println(friendArray.toString());
				System.out.println();
			}
		}
		if (checkName == false) { // otherwise, checkName is false
			System.out.println(foundNickName + " not found!");
			System.out.println();
		}
	}

	// Delete friend method
	public static void deleteFriend() {

		//Ask for input nickname
		System.out.println("Enter nickname: ");
		String deleteNickName = input.nextLine();

		String removeSuccess = deleteNickName + " deleted!";
		boolean checkName = false;

		for (Friend friendArray : friendData.values()) {
			checkName = true; // if nickname exist then checkName will assign to true value and then reomove it from the data
			if (friendArray.getNickName().equals(deleteNickName)) {
				String removeKey = friendArray.getNickName();
				friendData.remove(removeKey);
				System.out.println(removeSuccess);
			}

		}
		if (checkName == false) { // otherwise, checkName is false
			System.out.println(deleteNickName + " not found!");
			System.out.println();
		}

	}

	// Print all friend in the data
	public static void printFriends() {
		for (Friend friendArray : friendData.values()) {
			System.out.println(friendArray.toString());
		}
		System.out.println();
	}
}
