package interfaces;

import classes.*;

public interface I_List<T> {

	public Node<T> getHead ();
	
	public Node<T> getTail ();
	
	public int getSize ();
	
	public boolean insert (int index, Node<T> node);
	
	public boolean append (Node<T> node);
	
	public boolean remove (int index);
	
	public boolean remove (T content);
	
	public Node<T> get (int index);
	
	public boolean swap (int indexOne, int indexTwo);
}
