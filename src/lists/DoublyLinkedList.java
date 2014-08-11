package lists;

import common.DoublyLinkedListNode;

import java.util.NoSuchElementException;

/**
 *
 * Doubly Linked List Impl Class
 */
public class DoublyLinkedList {

	private DoublyLinkedListNode next;
	private DoublyLinkedListNode previous;
	private DoublyLinkedListNode head;
	private DoublyLinkedListNode tail;
	private int count;

	/**
	 * Constructor
	 */
	public DoublyLinkedList(){
		next = null;
		previous = null;
		head = null;
		count = 0;
	}

	/**
	 * Method that adds an object to the Linked List
	 * @param inputData
	 */
	public void add(Object inputData){

		DoublyLinkedListNode inputNode = new DoublyLinkedListNode(inputData);
		DoublyLinkedListNode tempNode = null;

		//Adding the first element
		if(head==null){
			head = inputNode;
			tail = head;
		}
		//For the second element
		else if(count==1){
			tempNode = tail;
			tail.next = inputNode;
			inputNode.previous = tail;
			tail = inputNode;
			tail.previous = head;
		}
		else{
			tempNode = tail;
			tail.next = inputNode;
			inputNode.previous = tail;
			tail = inputNode;
		}
		count++;
	}

	/**
	 * Method to add an object at a specified index in the Linked List and shifts the remaining indices' elements to the right
	 * @param index
	 * @param inputData
	 */
	public void add(int index, Object inputData){

		DoublyLinkedListNode inputNode = new DoublyLinkedListNode(inputData);
		DoublyLinkedListNode tempNode = null;
		DoublyLinkedListNode oldIndexNode = null;

		if(index==0){
			addFirst(inputData);
		}
		else{

			tempNode = head;

			//Navigate to the index
			for(int i=0; i<index; i++){

				//If LinkedList ends before the index
				if(tempNode.next == null){
					throw new IndexOutOfBoundsException("Index " +index + " is out of bounds!");
				}

				tempNode = tempNode.next;
			}

			//Place the node at the index and shift the present node to right
			oldIndexNode = tempNode.previous;
			inputNode.previous = oldIndexNode;
			oldIndexNode.next = inputNode;
			inputNode.next = tempNode;
			tempNode.previous = inputNode;

			//Increase count only in this case as the methods called by other cases take care of this
			count++;
		}
	}

	/**
	 * Method to remove an object from the linked list
	 */
	public void removeLast(){

		DoublyLinkedListNode tempNode = null;

		if(count==0){
			throw new NoSuchElementException();
		}
		else{
			tempNode = tail.previous;
			tempNode.next = null;
			tail = tempNode;
		}
		count--;
	}

	/**
	 * Method to remove an object from a particular index in the Linked List
	 * @param index
	 */
	public void remove(int index){

		DoublyLinkedListNode tempNode = null;
		DoublyLinkedListNode previousIndexNode = null;

		if(index > count-1 || index < 0){
			throw new NoSuchElementException();
		}
		else if(index==0){
			removeFirst();
		}
		else if(index==count-1){
			removeLast();
		}
		else{

			tempNode = head;

			//Find the node with that index
			for(int i=0; i<index; i++){

				//If Linked List ends before the index
				if(tempNode.next == null){
					throw new IndexOutOfBoundsException("Index " +index + " is out of bounds!");
				}

				tempNode = tempNode.next;
			}

			previousIndexNode = tempNode.previous;
			previousIndexNode.next = tempNode.next;
			tempNode.next.previous = previousIndexNode;
			count--;
		}
	}

	/**
	 * Method to remove the first element of the Linked List
	 */
	public void removeFirst(){

		DoublyLinkedListNode tempNode = null;

		if(count == 0){
			throw new NoSuchElementException();
		}
		else if(count == 1){
			head = null;
			tail = null;
		}
		else{
			tempNode = head.next;
			tempNode.previous = null;
			head = tempNode;
		}
		count--;
	}

	/**
	 * Method to insert an object before a specified object in the Linked List
	 * @param targetData
	 * @param inputData
	 */
	public void insertBefore(Object targetData, Object inputData){

		int tempCount = 0;
		DoublyLinkedListNode tempNode = head;


		//Check if the last element is the target node
		if(tail.data == targetData){
			add(count-1,inputData);
		}

		//Navigate through the linked list to find the target node
		while (tempNode.next!=null){

			if(tempNode.data == targetData){
				add(tempCount, inputData);
				break;
			}
			tempNode = tempNode.next;
			tempCount++;
		}
	}

	/**
	 * Method to insert an object after a specified object in the Linked List
	 * @param targetData
	 * @param inputData
	 */
	public void insertAfter(Object targetData, Object inputData){
		int tempCount = 0;
		DoublyLinkedListNode tempNode = head;

		//Check if the last element is the target node
		if(tail.data == targetData){
			add(inputData);
		}
		else{

			//Navigate through the linked list to find the target node
			while (tempNode.next != null) {

				if (tempNode.data.equals(targetData)) {
					add(tempCount + 1, inputData);
					break;
				}
				tempNode = tempNode.next;
				tempCount++;
			}
		}
	}

	/**
	 * Method to add an element to the head of the Linked List
	 * @param inputData
	 */
	public void addFirst(Object inputData){
		DoublyLinkedListNode inputNode = new DoublyLinkedListNode(inputData);

		if(head==null){
			tail = inputNode;
		}
		else{
			head.previous = inputNode;
			inputNode.next = head;
			head = inputNode;
		}
		count++;
	}

	/**
	 * Method to add an element to the tail of the Linked List
	 * @param inputData
	 */
	public void addLast(Object inputData){

		DoublyLinkedListNode inputNode = new DoublyLinkedListNode(inputData);

		if(head==null){
			head = inputNode;
		}
		else{
			tail.next = inputNode;
			inputNode.previous = tail;
			tail = inputNode;
		}

		count++;
	}

	/**
	 * Method to get an element from a specified index
	 * @return
	 */
	public Object get(int index){

		DoublyLinkedListNode tempCurrent = null;

		if(index <0){
			return null;
		}
		else if(index == 0){
			return head.data;
		}
		else if(index == count-1){
			return tail.data;
		}
		else{
			tempCurrent = head;
			//Navigate to the point where the index lies
			for(int i=0; i<index; i++){

				//If Linked List ends before the index
				if(tempCurrent.next == null){
					return null;
				}

				tempCurrent = tempCurrent.next;
			}

			return tempCurrent.data;
		}
	}

	/**
	 * Method to get the size of the Doubly Linked List
	 * @return
	 */
	public int getSize(){
		return count;
	}

	/**
	 * Method to check if the doubly linked list is empty
	 * @return
	 */
	public boolean isEmpty(){
		return count == 0;
	}

	/**
	 * Method to print the linked list
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		for(int i=0; i<count; i++){

			if(i==0){
				finalString = "[" + get(i) + ", ";
			}
			else if(i==count-1){
				finalString = finalString + get(i) + "]";
			}
			else {
				finalString = finalString + get(i) + ", ";
			}
		}

		return finalString;
	}
}
