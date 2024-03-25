package edu.otc;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Daniel Wade
 */
public class Main {
    static LinkedList<Ticket> ticketQueue = new LinkedList<>();

    public static void main(String[] args) {
        boolean loopMenu;
        Scanner sc = new Scanner(System.in);

       do {
           System.out.print("\033[H\033[2J");
           System.out.flush();
           showMenu();
           System.out.print("Select an option: ");

           boolean menuInputLoop;
           int option = -1;
           int min = 0;
           int max = 2;
           do {
               menuInputLoop = false;

               try {
                   option = Integer.parseInt(sc.nextLine()) - 1;
                   if (option < min || option > max) {
                       System.out.println("Input outside selection range. (1 - 3)\nPlease try again.");
                       menuInputLoop = true;
                    }
               } catch(NoSuchElementException | NumberFormatException e) {
                   System.out.println("Invalid Input " + e.getMessage());
                   menuInputLoop = true;
               }
           } while(menuInputLoop);

           System.out.println();
           switch (option) {
               // Open new ticket.
               case 0:
                   System.out.println("Enter your name.");
                   String name = sc.nextLine();
                   System.out.println("Describe the problem.");
                   String description = sc.nextLine();
                   enqueueTicket(new Ticket(name, description));
                   System.out.printf("Ticket for %s created!\n", name);
                   break;
               // Close current ticket.
               case 1:
                   if (ticketQueue.headNode == null)
                       System.out.println("No open tickets.");
                   else
                       System.out.printf("%s's ticket closed.\n", dequeueTicket().getCustomer());
                   break;
               // Display all tickets in queue.
               case 2:
                   displayTickets();
                   break;
           }

           System.out.println("Return to menu? y/n");

           String displayPerm;
           do
           {
               displayPerm = sc.nextLine();
               if (!displayPerm.equals("y") && !displayPerm.equals("n"))
                   System.out.println("Invalid input.\nPlease enter 'y' or 'n'.");
           }
           while (!displayPerm.equals("y") && !displayPerm.equals("n"));
           loopMenu = displayPerm.equals("y");
       } while (loopMenu);
    }

    public static void showMenu() {
        System.out.println("Ticketing System");
        System.out.println("-----------------");
        System.out.println("1 - Create Ticket");
        System.out.println("2 - Close Ticket");
        System.out.println("3 - Display All Open Tickets");
    }

    public static void enqueueTicket(Ticket ticket) {
        ticketQueue.add(ticket);
    }

    public static Ticket dequeueTicket() {
        var ticketQueued = ticketQueue.get().data;
        ticketQueue.delete();
        return ticketQueued;
    }

    public static void displayTickets() {
        var headTicket = ticketQueue.get();

        if (headTicket == null) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Open Tickets");
        System.out.println("------------");
        while(headTicket != null) {
            System.out.printf("Customer: %s\n", headTicket.data.getCustomer());
            System.out.printf("Description: %s\n\n", headTicket.data.getProblem());
            headTicket = headTicket.previous;
        }

    }
}