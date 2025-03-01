package classes;

import interfaces.I_List;

public class List <T> implements I_List <T> {
	private Node<T> head;
	private int size;

	public List(){
		head = null;
		size = 0;
	}

	public List(Node<T> head){
		this.head = head;
		this.size = 1;
	}

	@Override
	public Node<T> getHead() {
		return this.head;
	}

	@Override
	public Node<T> getTail() {
		if(this.head == null){
			return null;
		}else{
			Node<T> currentNode = this.head;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			return currentNode;
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean insert(int index, Node<T> node) {
		if(index < 0 || index > this.size || node == null){
			return false;
		}
		if(index == 0){
			node.setNext(this.head);
			this.head = node;
		}else{
			Node<T> currentNode = this.head;
			for(int i = 0; i < index - 1; i++){
				currentNode = currentNode.getNext();
			}
			Node<T> tempNext;
			tempNext = currentNode.getNext();
			currentNode.setNext(node);
			node.setNext(tempNext);
/*
			currentNode.setNext(node);
			node.setNext(currentNode);
*/
		}
		this.size++;
		return true;
	}

	@Override
	public boolean append(Node<T> node) {
		if(node == null){
			return false;
		}
		if(this.head == null){
			this.head = node;
		}else{
			Node<T> tail = getTail();
			tail.setNext(node);
		}
		this.size++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index > this.size - 1){
			return false;
		}
		if(index == 0){
			this.head = this.head.getNext();
		}else{
			Node<T> currentNode = this.head;
			for(int i = 0; i < index - 1; i++){
				currentNode = currentNode.getNext();
			}
		}
		this.size--;
		return true;
	}

	@Override
	public boolean remove(T content) {
		if(content == null || this.head == null){
			return false;
		}
		if(this.head.getContent() == content){
			this.head = this.head.getNext();
			this.size--;
			return true;
		}else{
			Node<T> currentNode = this.head;
			while(currentNode.getNext() != null && currentNode.getNext().getContent() == content){
				currentNode = currentNode.getNext();
			}

			if (currentNode.getNext() == null){
				return false;
			}else{
				currentNode.setNext(currentNode.getNext().getNext());
				this.size--;
				return true;
			}
		}


	}

	@Override
	public Node<T> get(int index) {
		if (index < 0 || index >= this.size) {
			return null;
		}
		Node<T> currentNode = this.head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	@Override
	public boolean swap(int indexOne, int indexTwo) {
		// Validate indices
		if (indexOne < 0 || indexOne >= this.size || indexTwo < 0 || indexTwo >= this.size) {
			return false;
		}


		if (indexOne == indexTwo) {
			return true;
		}

		// Ensure indexOne is smaller than indexTwo for simplicity
		if (indexOne > indexTwo) {
			int temp = indexOne;
			indexOne = indexTwo;
			indexTwo = temp;
		}

		// Retrieve nodes and their previous nodes
		Node<T> prevNodeOne = (indexOne == 0) ? null : get(indexOne - 1);
		Node<T> nodeOne = (prevNodeOne == null) ? this.head : prevNodeOne.getNext();

		Node<T> prevNodeTwo = get(indexTwo - 1);
		Node<T> nodeTwo = prevNodeTwo.getNext();

		// Swap nodes by adjusting pointers
		if (prevNodeOne != null) {
			prevNodeOne.setNext(nodeTwo);
		} else {
			this.head = nodeTwo; // Update head if indexOne is 0
		}

		prevNodeTwo.setNext(nodeOne);

		// Swap next pointers of nodeOne and nodeTwo
		Node<T> tempNext = nodeOne.getNext();
		nodeOne.setNext(nodeTwo.getNext());
		nodeTwo.setNext(tempNext);

		return true;
	}


}
