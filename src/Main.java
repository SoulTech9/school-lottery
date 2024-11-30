import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] winningNumbers = generateWinningNumbers();

        Scanner scanner = new Scanner(System.in);

        //Ask user for name
        System.out.print("\nPlease enter your name: ");
        String name = scanner.nextLine();

        // Ask for number of tickets
        System.out.print("How many tickets would you like to purchase? ");
        int numTickets = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                numTickets = scanner.nextInt();
                if (numTickets > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number of tickets: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }

        // Generate tickets based on argument
        int[][] tickets = generateTickets(numTickets, name);

        // Check tickets against the winning numbers
        checkTickets(tickets, winningNumbers, name);

        scanner.close();
    }

    // Generate winning numbers
    public static int[] generateWinningNumbers() {
        int[] winningNumbers = new int[5];
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            winningNumbers[i] = rand.nextInt(56); // Generates numbers between 0 and 55 inclusive
        }

        System.out.println("\nToday's winning numbers are: " + Arrays.toString(winningNumbers));

        return winningNumbers;
    }

    // Generate tickets with random numbers
    public static int[][] generateTickets(int numTickets, String name) {
        int[][] tickets = new int[numTickets][5];
        Random rand = new Random();

        System.out.println("\nThank you " + name + " for your purchase. Here are your ticket numbers:");

        for (int i = 0; i < numTickets; i++) {
            for (int j = 0; j < 5; j++) {
                tickets[i][j] = rand.nextInt(56); // Generates numbers between 0 and 55 inclusive
            }
            System.out.println("Ticket " + (i + 1) + ": " + Arrays.toString(tickets[i]));
        }

        return tickets;
    }

    // Check tickets against winning numbers
    public static void checkTickets(int[][] tickets, int[] winningNumbers, String name) {
        for (int i = 0; i < tickets.length; i++) {
            System.out.println("\nChecking numbers for ticket " + (i + 1) + "...");
            if (isWinner(tickets[i], winningNumbers)) {
                System.out.println("Congratulations! You win a hot dog!");
            } else {
                System.out.println("Sorry " + name + ", this ticket did not win.");
            }
        }
    }

    // Check if a ticket matches the winning numbers
    public static boolean isWinner(int[] ticket, int[] winningNumbers) {
        // Sort both arrays in ascending Order by default by using sort method
        int[] ticketCopy = ticket.clone();
        int[] winningNumbersCopy = winningNumbers.clone();
        Arrays.sort(ticketCopy);
        Arrays.sort(winningNumbersCopy);
        return Arrays.equals(ticketCopy, winningNumbersCopy);
    }
}
