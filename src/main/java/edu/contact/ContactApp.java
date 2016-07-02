/**
 * 
 */
package edu.contact;

import java.util.Scanner;

/**
 * @author Nazmul Hassan
 *
 */
public class ContactApp {

	private NameTrie nameSearchAlgo = new NameTrie();

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ContactApp app = new ContactApp();
		while (true) {
			app.mainMenu();
			int opt = new Scanner(System.in).nextInt();
			switch (opt) {
			case 1: {
				app.addContact();
				break;
			}
			case 2: {
				app.searchContact();
				break;
			}
			case 3: {
				System.exit(0);
			}
			default:
				System.out.print("Wrong Choice");
			}
		}
	}

	@SuppressWarnings("resource")
	private void addContact() {
		System.out.print("Enter Name:");
		String fullName = new Scanner(System.in).useDelimiter("\n").nextLine();
		validation(fullName);
		this.nameSearchAlgo.insert(fullName);

	}

	@SuppressWarnings("resource")
	private void searchContact() {
		System.out.print("Enter Search Name:");
		String searchName = new Scanner(System.in).nextLine();
		validation(searchName);
		if (this.nameSearchAlgo.startsWith(searchName)) {
			TrieNode tn = this.nameSearchAlgo.searchNode(searchName);
			this.nameSearchAlgo.nameMatchBuilder(tn, 0);
			this.nameSearchAlgo.displayFoundNames();
		} else {
			System.out.println("No matching name found!");
		}
	}

	private void mainMenu() {
		System.out.println("1: Add Contact, 2: Search, 3:Exit");
	}
	
	private void validation(String input){
		if(input == null || input.isEmpty())
			throw new RuntimeException("Invalid Name, Please correct!");
		if(input.length() > 50)
			throw new RuntimeException("Each name can be upto 50 characters.");
		if(input.split(" ").length > 2)
			throw new RuntimeException("Not more than 1 space is allowed.");
	}
}
