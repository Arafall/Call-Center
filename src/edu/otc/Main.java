package edu.otc;

/**
 *
 * @author Daniel Wade
 */
public class Main {
    public static LinkedList<Ticket> ticketQueue = new LinkedList<>();
    public static void main(String[] args) {

        enqueueTicket(new Ticket("Joe Miller", "First"));
        enqueueTicket(new Ticket("Robert Patterson", "Second"));
        enqueueTicket(new Ticket("Norman Javers", "Third"));


    }

    public static void showMenu() {

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
        var headTicket = ticketQueue.headNode;

        if (headTicket == null) {
            System.out.println("Queue Empty");
            return;
        }

        while(headTicket != null) {
            System.out.println(headTicket.data.getProblem());
            headTicket = headTicket.next;
        }

    }
}