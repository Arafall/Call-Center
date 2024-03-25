package edu.otc;

/**
 * Linked List to store items by references to the previous and next nodes.
 * @param <T> Generic typing used to have dynamic data.
 * @author Daniel Wade
 */
public class LinkedList<T> {
    // Latest node to be added into linked list.
    public LLNode<T> headNode = null;

    /**
     * Creates a new node and assigns its next node as the current head,
     * then set that new node as the head node.
     * @param value String that'll be assigned to the new node's data property.
     */
    public void add(T value) {
        // Instantiate new node.
        LLNode<T> temp = new LLNode<>(value);
        // Assign its next node as the previous head.
        temp.next = headNode;
        // Head node previous reference is to the new node
        if (headNode != null)
            headNode.previous = temp;

        // Set new head node to be the one created.
        headNode = temp;
    }

    /**
     * Nullifies the first node in the list and the previous node's reference to it,
     * leaving it for garbage collection.
     */
    public void delete() {
        // Leave method when head is doesn't exist/list is empty.
        if (headNode == null) return;

        // Nullify node when it's the only node.
        if (headNode.next == null)
            headNode = null;
        else {  // Call method to get first node to void out its data and the previous node's reference to it.
            var headTicket = get();
            headTicket.data = null;
            headTicket.previous.next = null;
        }
    }

    /**
     * Using the head node progress to the first node through each node's 'next' property.
     * @return First node stored in list queue.
     */
    public LLNode<T> get() {
        // Leave method when head is doesn't exist/list is empty.
        if (headNode == null) return null;
        // Progresses through each node link.
        var head = headNode;
        while(head.next != null) {
            head = head.next;
        }

        return head;
    }
}
