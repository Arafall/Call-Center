package edu.otc;

/**
 * Linked List class
 * @author Daniel Wade
 */
public class LinkedList<T> {
    private T t;
    // Latest node to be added into linked list.
    public LLNode<T> headNode = null;

    /**
     * Creates a new node and assigns its next node as the current head,
     * then set that new node as the head node.
     * @param value String that'll be assigned to the new node's data property.
     */
    public void add(T value) {
        // Instantiate new node.
        LLNode<T> temp = new LLNode<T>(value);
        // Assign its next node as the previous head.
        temp.next = headNode;
        if (headNode != null)
            headNode.previous = temp;

        // Set new head node to be the one created.
        headNode = temp;
    }

    /**
     * Nullifies the head node to delete it from the linked list, leaving it for garbage collection.
     */
    public void delete() {
        // Leave method when head is doesn't exist/list is empty.
        if (headNode == null) return;

        // Nullify node when it's the only node.
        if (headNode.next == null)
            headNode = null;
            // Set head node to the next one in the list, essentially ejecting the object.
        else {
            var headTicket = get();
            headTicket.data = null;
            headTicket.previous.next = null;
        }

    }

    public LLNode<T> get() {

        var head = headNode;

        while(head.next != null) {
            head = head.next;
        }

        return head;
    }
}
