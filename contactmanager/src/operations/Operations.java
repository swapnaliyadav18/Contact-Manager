package operations;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import entity.Contacts;

public class Operations {

	ArrayList<Contacts> contactsList = new ArrayList<>();
	public static final int F_NAME = 1;
	public static final int L_NAME = 2;
	public static final int Email = 3;
	public static final long Mobile_NUMBER = 4;
	public static final int Category = 5;

	public void addContact() {
		Scanner scanner = new Scanner(System.in);
		
		int id=getId();
	
		System.out.println("Enter first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name:");
		String lastName = scanner.nextLine();
		System.out.println("Enter email:");
		String email = scanner.nextLine();
		
		long mobileNumber = getMobileNumber();
		
		String category = selectCategory();
		Contacts contact = new Contacts(id, firstName, lastName, email, mobileNumber, category);
		contactsList.add(contact);
		System.out.println("Contact Added Succesfully...");
	}

	private long getMobileNumber() {
		int mobileNumber = 0;
		Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
            	System.out.println("Enter mobile number:");
            	boolean check=true;
            	while (check) {
            		
            		mobileNumber = scanner.nextInt();
            		String long1=String.valueOf(mobileNumber);
            		
            		if(long1.length()==10) {
            			check=false;
            			break;
            		}
            		System.err.println("Please Enter Valid Number");
				}
            	
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Please Enter Correct Id (it should be numeric)");
                scanner.nextLine();
            }
        }
		return mobileNumber;
	}

	private int getId() {
		int id = 0;
		Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter id:");
                id = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Please Enter Correct Id (it should be numeric)");
                scanner.nextLine();
            }
        }
		return id;
	}

	private String selectCategory() {
		System.out.println("Select your Category");
		System.out.println("select 1 for Family\n" + "Select 2 for Friend\n" + "Select 3 for Collegue");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		String category = null;
		if (choice == 1) {
			return "Family";
		} else if (choice == 2) {
			return "Friend";
		} else if (choice == 3) {
			return "Collegue";
		} else {
			System.err.println("Please enter valid category...");
			selectCategory();
		}
		return category;
	}

	public void deleteContact() {
		viewAllContacts();
		System.out.println("Enter the id: ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		Contacts contactToBeDeleted = null;
		for (Contacts contacts : contactsList) {
			if (contacts.getId() == id) {
				contactToBeDeleted = contacts;
				break;
			}
		}
		contactsList.remove(contactToBeDeleted);
		System.out.println("Contact Deleted Successfully...");

	}

	public void viewAllContacts() {
		for (Contacts contacts : contactsList) {
			System.out.println(contacts);
		}
	}

	public void searchContact() {
		if (contactsList.isEmpty()) {
			System.err.println("Contacts are empty...");
		} else {
			System.out.println("Search by:");
			System.out.println(
					"Select particular option\n" + "select 1 for Search by Id\n" + "select 2 for Search by first_Name\n"
							+ "select 3 for Search by last_Nmae\n" + "select 4 for Search by Email\n"
							+ "select 5 for Search by Mobile_Number\n" + "select 6 for Search by Category\n");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				int id = scanner.nextInt();
				for (Contacts contacts : contactsList) {
					if (contacts.getId() == id) {
						System.out.println(contacts);
						break;
					}
				}
				break;

			case 2:
				System.out.println("Enter firstName");
				String firstName = scanner.nextLine();
				for (Contacts contacts : contactsList) {
					if (contacts.getFirstName().equals(firstName)) {
						System.out.println(contacts);
						break;
					} else {
						System.err.println("Contact Not Found...");
					}

				}
				break;

			case 3:
				String lastName = scanner.nextLine();
				for (Contacts contacts : contactsList) {
					if (contacts.getLastName().equals(lastName)) {
						System.out.println(contacts);
						break;
					} else {
						System.err.println("Contact Not Found...");
					}
				}
				break;

			case 4:
				String email = scanner.nextLine();
				for (Contacts contacts : contactsList) {
					if (contacts.getEmail().equals(email)) {
						System.out.println(contacts);
						break;
					} else {
						System.err.println("Contact Not Found...");
					}
				}
				break;

			case 5:
				long mobileNumber = scanner.nextLong();
				for (Contacts contacts : contactsList) {
					if (contacts.getMobileNumber() == mobileNumber) {
						System.out.println(contacts);
						break;
					} else {
						System.err.println("Contact Not Found...");
					}
				}
				break;

			case 6:
				searchCategory();
				break;
			default:
				System.err.println("Invalid Input.....");
				break;
			}

		}
	}

	private void searchCategory() {
		System.out.println("Select Category ");
		System.out.println("1 for Family\n" + "2 for Friend\n" + "3 for Collegue");
		Scanner scanner =new Scanner(System.in);
		int choiceCategory = scanner.nextInt();

		switch (choiceCategory) {
		case 1:
			for (Contacts contacts : contactsList) {
				if (contacts.getCatagory().equals("Family")) {
					System.out.println(contacts);
					break;
				} else {
					System.err.println("Contact Not Found...");
				}
			}

			break;

		case 2:
			for (Contacts contacts : contactsList) {
				if (contacts.getCatagory().equals("Friend")) {
					System.out.println(contacts);
					break;
				} else {
					System.err.println("Contact Not Found...");
				}
			}

			break;

		case 3:
			for (Contacts contacts : contactsList) {
				if (contacts.getCatagory().equals("Collegue")) {
					System.out.println(contacts);
					break;
				} else {
					System.err.println("Contact Not Found...");
				}
			}

			break;

		default:
			System.err.println("Invalid Input...");
			searchCategory();
			break;
		}


		
	}

	public void editContact() {

		System.out.println("Enter the id to edit : ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		if (!contactsList.isEmpty()) {
			for (Contacts contacts1 : contactsList) {
				if (contacts1.getId() == id) {
					System.out.println("Select what you want to edit.");
					System.out.println("select 1 for first-name\n" + "Select 2 for last-name\n" + "Select 3 for email\n"
							+ "Select 4 for mobile-number\n" + "Select 5 for category");
					int choice = scanner.nextInt();
					scanner.nextLine();

					if (choice == F_NAME) {
						String firstName = null;
						System.out.println("Enter updated first name :");
						firstName = scanner.nextLine();
						if (contacts1.getFirstName() != firstName) {
							contacts1.setFirstName(firstName);
						}
						System.out.println(contacts1);
					}

					else if (choice == L_NAME) {
						String lastName = null;
						System.out.println("Enter updated last name :");
						lastName = scanner.nextLine();
						if (contacts1.getLastName() != lastName) {
							contacts1.setLastName(lastName);
						}
						System.out.println(contacts1);
					}
					else if (choice == Email) {
						String email = null;
						System.out.println("Enter updated email name :");
						email = scanner.nextLine();
						if (contacts1.getEmail() != email) {
							contacts1.setEmail(email);
						}
						System.out.println(contacts1);
					}
					else if (choice == Mobile_NUMBER) {
						long mobileNumber = 0;
						System.out.println("Enter updated mobile number :");
						mobileNumber = scanner.nextLong();
						if (contacts1.getMobileNumber() != mobileNumber) {
							contacts1.setMobileNumber(mobileNumber);
						}
						System.out.println(contacts1);
					}
					else if (choice == Category) {
						editCategory(contacts1);
					}

				} else {
					System.err.println("Id not found in contact list...");
				}

			}

		} else {
			System.err.println("Contact list is Empty.....");
		}
	}

	private void editCategory(Contacts contacts1) {
		Scanner scanner =new Scanner(System.in);
		String category = null;
		System.out.println("Enter updated category :");
		System.out.println("Select Category ");
		System.out.println("1 for Family\n" + "2 for Friend\n" + "3 for Collegue");
		int categoryChoice = scanner.nextInt();
		switch (categoryChoice) {
		case 1:
			category = scanner.nextLine();
			if (contacts1.getCatagory() != category) {
				contacts1.setCatagory("Family");
			}
			System.out.println(contacts1);

			break;
		case 2:
			category = scanner.nextLine();
			if (contacts1.getCatagory() != category) {
				contacts1.setCatagory("Friend");
			}
			System.out.println(contacts1);

			break;
		case 3:
			category = scanner.nextLine();
			if (contacts1.getCatagory() != category) {
				contacts1.setCatagory("Collegue");
			}
			System.out.println(contacts1);
			break;

		default:
			editCategory(contacts1);
			System.err.println("Please Enter the valid option.");
			break;
		}

			
	}
}