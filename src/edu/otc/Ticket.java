package edu.otc;

/**
 * @author Daniel Wade
 */
public class Ticket {
    private String customerName;
    private String problemDescription;

    /**
     * Constructor.
     * @param customerName Name of customer who created the ticket.
     * @param problemDescription Customer description as to why the ticket was created.
     */
    public Ticket(String customerName, String problemDescription) {
        this.customerName = customerName;
        this.problemDescription = problemDescription;
    }

    public String getCustomer() {return customerName;}
    public String getProblem() {return problemDescription;}
}
