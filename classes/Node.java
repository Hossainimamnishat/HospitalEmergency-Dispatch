package classes;

import interfaces.I_Node;

public class Node <T> implements I_Node <T> {

	private T content;
	private Node<T> next;
	private Node<T> prev;

	public Node(){
		this.content = null;
		this.next = null;
		this.prev = null;
	}

	public Node(T content){
		this.content = content;
		this.next = null;
		this.prev = null;
	}

	@Override
	public T getContent() {
		return this.content;
	}

	@Override
	public void setContent(T content) {
		this.content = content;

	}

	@Override
	public Node<T> getPrev() {
		return this.prev;
	}

	@Override
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	@Override
	public Node<T> getNext() {

		return this.next;
	}

	@Override
	public void setNext(Node<T> next) {
		this.next = next;

	}

}
