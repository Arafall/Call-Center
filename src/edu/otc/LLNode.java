package edu.otc;

public class LLNode<T> {
    public LLNode<T> next = null;
    public LLNode<T> previous = null;
    public T data;


    public LLNode(T value) {
        data = value;
    }
}
