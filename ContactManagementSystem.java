
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

public class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        viewContacts();
                        break;
                    case 3:
                        editContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        System.out.println("Exiting the Contact Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0;
            }

        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter the email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(newContact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContacts:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". Name: " + contact.name + ", Phone: " + contact.phoneNumber + ", Email: " + contact.emailAddress);
            }
        }
    }

    private static void editContact() {
        viewContacts();

        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the index of the contact you want to edit: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (index >= 1 && index <= contacts.size()) {
                Contact contact = contacts.get(index - 1);

                System.out.print("Enter the new name (press enter to keep the current name): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    contact.name = newName;
                }

                System.out.print("Enter the new phone number (press enter to keep the current phone number): ");
                String newPhoneNumber = scanner.nextLine();
                if (!newPhoneNumber.isEmpty()) {
                    contact.phoneNumber = newPhoneNumber;
                }

                System.out.print("Enter the new email address (press enter to keep the current email address): ");
                String newEmailAddress = scanner.nextLine();
                if (!newEmailAddress.isEmpty()) {
                    contact.emailAddress = newEmailAddress;
                }

                System.out.println("Contact edited successfully!");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void deleteContact() {
        viewContacts();

        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter the index of the contact you want to delete: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (index >= 1 && index <= contacts.size()) {
                Contact contact = contacts.remove(index - 1);
                System.out.println("Contact deleted successfully: " + contact.name);
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
}
