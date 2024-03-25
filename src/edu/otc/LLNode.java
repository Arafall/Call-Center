package edu.otc;

/**
 * Individual nodes that make up a linked list.
 * @param <T> Generic typing used to have dynamic data.
 * @author Daniel Wade
 */
public class LLNode<T> {
    public LLNode<T> next = null;
    public LLNode<T> previous = null;
    public T data;

    public LLNode(T value) {
        data = value;
    }
}
