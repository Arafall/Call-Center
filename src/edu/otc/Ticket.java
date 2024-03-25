package edu.otc;

/**
 * Class to contain the name of a person and the problem they are having as part of a queue system.
 * @author Daniel Wade
 */
public class Ticket {
    private final String customerName;
    private final String problemDescription;

    /**
     * Constructor.
     * @param customerName Name of customer who created the ticket.
     * @param problemDescription Customer description as to why the ticket was created.
     */
    public Ticket(String customerName, String problemDescription) {
        this.customerName = customerName;
        this.problemDescription = problemDescription;
    }

    /**
     * @return Name of customer on ticket.
     */
    public String getCustomer() {return customerName;}

    /**
     * @return Description of problem the ticket was opened for.
     */
    public String getProblem() {return problemDescription;}
}
