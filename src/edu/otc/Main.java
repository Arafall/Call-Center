package edu.otc;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Daniel Wade
 */
public class Main {
    // Class level instance of a linked list to store tickets.
    static LinkedList<Ticket> ticketQueue = new LinkedList<>();

    public static void main(String[] args) {
        boolean loopMenu;
        Scanner sc = new Scanner(System.in);

        // Loop through menu until user wants to exit.
        do {
            // Clears the console to view terminal easier.
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Call method to display ticket menu options.
            showMenu();

            // Loop until valid integer input is received.
            System.out.print("Select an option: ");
            boolean menuInputLoop;
            int option = -1;
            int min = 0;    // First valid index.
            int max = 2;    // Last valid index.
            do {
                menuInputLoop = false;

                try {
                    option = Integer.parseInt(sc.nextLine()) - 1;
                    // Loop again when input is out of the range defined.
                    if (option < min || option > max) {
                        System.out.println("Input outside selection range. (1 - 3)\nPlease try again.");
                        menuInputLoop = true;
                    }
                    // Redo loop if exception was found; not a number or null input.
                } catch(NoSuchElementException | NumberFormatException e) {
                    System.out.println("Invalid Input " + e.getMessage());
                    menuInputLoop = true;
                }
            } while(menuInputLoop);

            System.out.println();
            // Manage ticket menu choice.
            switch (option) {
                // Open new ticket.
                case 0:
                    // Get customer name and problem description to create new ticket.
                    System.out.println("Enter your name.");
                    String name = sc.nextLine();
                    System.out.println("Describe the problem.");
                    String description = sc.nextLine();
                    // Add new ticket to end of queue.
                    enqueueTicket(new Ticket(name, description));
                    System.out.printf("Ticket for %s created!\n", name);
                    break;
                // Close open ticket.
                case 1:
                    // Display that queue is empty.
                    if (ticketQueue.headNode == null)
                        System.out.println("No open tickets.");
                    // Notify that the open ticket was closed with the customer name attached.
                    else
                        System.out.printf("%s's ticket closed.\n", dequeueTicket().getCustomer());
                    break;
                // Display all tickets in queue.
                case 2:
                    displayTickets();
                    break;
            }

            // Prompt user to return to menu or exit the program.
            System.out.println("Return to menu? y/n");
            String displayPerm;
            // Loop until valid input is given. y/n
            do
            {
                displayPerm = sc.nextLine();
                if (!displayPerm.equals("y") && !displayPerm.equals("n"))
                    System.out.println("Invalid input.\nPlease enter 'y' or 'n'.");
            }
            while (!displayPerm.equals("y") && !displayPerm.equals("n"));
            // Tells program to loop menu if "y" was entered, otherwise close program.
            loopMenu = displayPerm.equals("y");
        } while (loopMenu);
    }

    /**
     * Write out the menu navigating options.
     */
    public static void showMenu() {
        System.out.println("Ticketing System");
        System.out.println("-----------------");
        System.out.println("1 - Create Ticket");
        System.out.println("2 - Close Ticket");
        System.out.println("3 - Display All Open Tickets");
    }

    /**
     * Takes a specified ticket and adds it to queue by the linked list.
     * @param ticket Object of a new ticket to add to the queue.
     */
    public static void enqueueTicket(Ticket ticket) {
        ticketQueue.add(ticket);
    }

    /**
     * Deletes the open ticket from the queue and saves the ticket to be returned.
     * @return Ticket object that was just removed from the head of the queue.
     */
    public static Ticket dequeueTicket() {
        var ticketQueued = ticketQueue.get().data;
        ticketQueue.delete();
        return ticketQueued;
    }

    /**
     * Reads through the ticket linked list to write out ticket data to console.
     */
    public static void displayTickets() {
        var headTicket = ticketQueue.get();
        // Write out that queue has no tickets and exit method.
        if (headTicket == null) {
            System.out.println("Queue Empty");
            return;
        }
        // Loop through queue to display ticket with the customer name and problem described.
        System.out.println("Tickets Queued");
        System.out.println("--------------");
        // Loop until to last ticket entered since the first item is lowest in the list.
        while(headTicket != null) {
            System.out.printf("Customer: %s\n", headTicket.data.getCustomer());
            System.out.printf("Description: %s\n\n", headTicket.data.getProblem());
            headTicket = headTicket.previous;
        }

    }
}