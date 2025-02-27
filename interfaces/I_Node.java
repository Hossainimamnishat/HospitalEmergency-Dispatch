package interfaces;

import classes.*;

public interface I_Node <T> {
	public T getContent();
	public void setContent(T content);
	public Node<T> getPrev();
	public void setPrev(Node<T> prev);
	public Node<T> getNext();
	public void setNext(Node<T> next);
}
