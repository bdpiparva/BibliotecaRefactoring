package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {

    private static String savedLibraryNumber = "";

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LibraryManagment libraryManagment = new LibraryManagment();


        while (true) {
            libraryManagment.showWelcomeMessageAndMenu();

            System.out.println("Your Selection: ");

            int userMainMenuSelection = readUserChoice(reader);

            if (userMainMenuSelection == 1) {
                libraryManagment.showBookCatalogMenu();
            } else if (userMainMenuSelection == 2) {
                System.out.println(" Please enter the number of the book you wish to checkout: ");
                int userBookSelection = readUserChoice(reader);
                switch (userBookSelection) {
                    case 1:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 3:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 4:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Sorry we don't have that book yet.");
                }
            } else if (userMainMenuSelection == 3) {
                if (libraryManagment.loggedIn()) {
                    System.out.println("\n");
                    System.out.println("Your library number is " + savedLibraryNumber);
                } else {

                    System.out.println("\n");
                    System.out.println("Please talk to Librarian. Thank you.");
                }
            } else if (userMainMenuSelection == 4) {
                libraryManagment.showMovieList();
            } else if (userMainMenuSelection == 5) {
                libraryManagment.clearLogin();
                savedLibraryNumber = "";
                System.out.println("Enter your library number");
                try {
                    String libraryNumber = reader.readLine();
                    if (libraryManagment.isValidLibraryNumber(libraryNumber)) {
                        try {
                            System.out.println("Enter your Password: ");
                            String password = reader.readLine();
                            if (libraryManagment.validPassword(password)) {
                                libraryManagment.loggedIn = true;
                                savedLibraryNumber = libraryNumber;
                            }
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }

            } else if (userMainMenuSelection == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }

    private static int readUserChoice(BufferedReader reader) {

        try {
            String value = reader.readLine();
            return Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
            return readUserChoice(reader);
        }
    }

}

