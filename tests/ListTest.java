package tests;

import org.junit.jupiter.api.Test;
import classes.*;

public class ListTest {
	
	@Test
	public void constructorTest () {
		List<Integer> testList = new List<>();
		List<Integer> testList2 = new List<>(new Node<Integer>());
	}
	
	@Test
	public void getHeadTest () {
		List<Integer> testList = new List<>();
		assert testList.getHead() == null;
		Node<Integer> node = new Node<>();
		List<Integer> testList2 = new List<>(node);
		assert testList2.getHead() == node;
	}
	
	@Test
	public void getTailTest () {
		List<Integer> testList = new List<>();
		assert testList.getTail() == null;
		Node<Integer> node = new Node<>();
		List<Integer> testList2 = new List<>(node);
		assert testList2.getTail() == node;
	}
	
	@Test
	public void getSizeTest () {
		List<Integer> testList = new List<>();
		assert testList.getSize() == 0;
		Node<Integer> node = new Node<>();
		List<Integer> testList2 = new List<>(node);
		assert testList2.getSize() == 1;
	}
	
	@Test
	public void getTest () {
		List<Integer> testList = new List<>();
		assert testList.get(0) == null;
		Node<Integer> node = new Node<>();
		List<Integer> testList2 = new List<>(node);
		assert testList2.get(0) == node;
	}
	
	@Test
	public void insertTest () {
		List<Integer> testList = new List<>();
		Node<Integer> node = new Node<>();
		assert testList.insert(0,node) == true;
	}
	
	@Test
	public void appendTest () {
		List<Integer> testList = new List<>();
		Node<Integer> node = new Node<>();
		assert testList.append(node) == true;
	}
	
	@Test
	public void removeIndexTest () {
		List<Character> testList = new List<>();
		Node<Character> node = new Node<>();
		testList.append(node);
		assert testList.remove(0) == true;
	}
	
	@Test
	public void removeContentTest () {
		List<Character> testList = new List<>();
		Node<Character> node = new Node<>('a');
		testList.append(node);
		assert testList.remove((Character)'a') == true;
	}
	
	@Test
	public void swapTest () {
		List<Character> testList = new List<>();
		Node<Character> node = new Node<>('a');
		Node<Character> node2 = new Node<>('a');
		testList.append(node);
		testList.append(node2);
		assert testList.swap(0,1) == true;
		assert testList.get(0) == node2;
		assert testList.get(1) == node;
	}

}
