package tests;

import classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

	@Test
	public void constructorTest () {
		Node<Integer> testNode = new Node<>(2);
		Node<Integer> testNode2 = new Node<>();
	}
	
	@Test
	public void getContentTest () {
		Node<Integer> testNode = new Node<>(2);
		assert testNode.getContent() == 2;
	}
	
	@Test
	public void setContentTest () {
		Node<Integer> testNode = new Node<>();
		testNode.setContent(3);
		assert testNode.getContent() == 3;
	}
	
	@Test
	public void getNextTest () {
		Node<Integer> testNode = new Node<>();
		assert testNode.getNext() == null;
	}
	
	@Test
	public void setNextTest () {
		Node<Integer> testNode = new Node<>();
		Node<Integer> testNode2 = new Node<>();
		testNode.setNext(testNode2);
		assert testNode.getNext() == testNode2;
	}
	
	@Test
	public void getPrevTest () {
		Node<Integer> testNode = new Node<>();
		assert testNode.getPrev() == null;
	}
	
	@Test
	public void setPrevTest () {
		Node<Integer> testNode = new Node<>();
		Node<Integer> testNode2 = new Node<>();
		testNode.setPrev(testNode2);
		assert testNode.getPrev() == testNode2;
	}
	
}
