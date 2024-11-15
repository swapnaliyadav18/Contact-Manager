package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import operations.Operations;

public class ContactsMain {
	
	public static Operations operations =new Operations();
	static boolean loop = true;
	public static void main(String[] args) {
		while(loop) {
		menu();
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		}

	}

	public static void menu() {
		System.out.println("Welcome to contact Manager.....");
		System.out.println("Enter 1 for add contact.\n" + "Enter 2 for edit contact.\n" + "Enter 3 for show contacts.\n"
				+ "Enter 4 for delete contact\n" + "Enter 5 for search contact\n" + "Enter 6 for exit.");
		int choice = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter Choice.");
                choice = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Please Enter Valid Choice)");
                scanner.nextLine();
            }
        }
		
		switch (choice) {
		case 1:
			operations.addContact();
			break;
		case 2:
			operations.editContact();
			break;
		case 3:
			operations.viewAllContacts();
			break;
		case 4:
			operations.deleteContact();
			break;
		case 5:
			operations.searchContact();
			break;
		case 6:
			loop=false;
			break;
		default:
			System.err.println("Invalid Input...");
		}
	}
}