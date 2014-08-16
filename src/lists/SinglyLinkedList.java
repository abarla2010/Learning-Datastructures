package lists;

import common.SinglyLinkedListNode;

/**
 * Singly Linked List Implementation Class
 */
public class SinglyLinkedList {

	private SinglyLinkedListNode head;
	private SinglyLinkedListNode current;
	private int count;

	/**
	 * Constructor for SinglyLinkedList
	 */
	public SinglyLinkedList(){
		head = null;
		current = null;
		count = 0;
	}

	/**
	 * Method to add an object into the linkedlist
	 * @param inputData
	 */
	public void add(Object inputData){
		SinglyLinkedListNode tempNode = new SinglyLinkedListNode(inputData);

		//If it is the first element
		if(head == null){
			head = tempNode;
			current = head;
		}
		else{
			current.next = tempNode;
			current = current.next;
		}

		count++;
	}

	/**
	 * Method that inserts an object into a specified index in the Linkedlist
	 * If an object exists at that specified index then, it would shift that object to the right
	 * and then add the new object at that index
	 * @param index
	 * @param inputData
	 */
	public void add(int index, Object inputData){

		SinglyLinkedListNode tempCurrent = head;
		SinglyLinkedListNode tempNode = new SinglyLinkedListNode(inputData);

		//Adding at the first index
		if(index == 0){
			addFirst(inputData);
		}
		//Adding at the last index
		else if(index == count-1){
			addLast(inputData);
		}
		else{
			//Find the place where to add the element
			for(int i=1; i<index; i++){
				tempCurrent = tempCurrent.next;
			}

			//Store the current node's next in the new node's next
			tempNode.next = tempCurrent.next;

			//Store the new node as the current node's next
			tempCurrent.next = tempNode;

			count++;
		}
	}

	/**
	 * Method that inserts an element before the first occurrence of a target element
	 * @param targetData
	 * @param inputData
	 */
	public void insertBefore(Object targetData, Object inputData){

		SinglyLinkedListNode targetNode = new SinglyLinkedListNode(targetData);
		SinglyLinkedListNode inputNode = new SinglyLinkedListNode(inputData);
		SinglyLinkedListNode tempCurrent = null;

		//Adding before the first element
		if(targetNode.data.equals(head.data)){
			inputNode.next = head;
			head = inputNode;
		}

		//Adding before the last element
		else if(targetNode.data.equals(current.data)){
			tempCurrent = head;
			while(true){
				if(tempCurrent.next.next == null){
					inputNode.next = current;
					tempCurrent.next = inputNode;
					break;
				}
				tempCurrent = tempCurrent.next;
			}
		}
		else{
			tempCurrent = head;
			//Navigate to the target node
			while(tempCurrent.next != null){

				if(tempCurrent.next.data.equals(targetNode.data)){
					inputNode.next = tempCurrent.next;
					tempCurrent.next = inputNode;
					break;
				}
				tempCurrent = tempCurrent.next;
			}
		}

		count++;
	}

	/**
	 * Method to insert an element after a particular element's first occurrence
	 * @param targetData
	 * @param inputData
	 */
	public void insertAfter(Object targetData, Object inputData){

		SinglyLinkedListNode inputNode = new SinglyLinkedListNode(inputData);
		SinglyLinkedListNode targetNode = new SinglyLinkedListNode(targetData);
		SinglyLinkedListNode tempCurrent = null;

		//Adding at the last node
		if(targetNode.data.equals(current.data)){
			current.next = inputNode;
			current = current.next;
		}
		else{
			tempCurrent = head;
			//Navigate to the target node
			while(true){
				if(tempCurrent.data.equals(targetNode.data)){
					//Add the node after this node
					inputNode.next = tempCurrent.next;
					tempCurrent.next = inputNode;
					break;
				}
				tempCurrent = tempCurrent.next;
			}
		}
		count++;
	}

	/**
	 * Method that returns the object at a specified index
	 * @param index
	 * @return
	 */
	public Object get(int index) {

		SinglyLinkedListNode tempNode = null;

		if(index < 0 ){
			return null;
		}

		if(head != null){
			tempNode = head;
			for(int i=0; i<index; i++){

				//If linkedList ends before the index itself
				if(tempNode.next == null){
					return null;
				}

				tempNode = tempNode.next;
			}
		}

		return tempNode.data;

	}

	/**
	 * Method adds an object to the head of the LinkedList
	 * @param inputData
	 */
	public void addFirst(Object inputData) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(inputData);

		if(head == null){
			head = node;
			current = head;
		}
		else{
			SinglyLinkedListNode temp = head;
			head = node;
			head.next = temp;
		}
		count++;
	}

	/**
	 * Method to remove the first element
	 */
	public void removeFirst(){
		head = head.next;
		count--;
	}

	/**
	 * Method adds an object to the end of the LinkedList
	 * @param inputData
	 */
	public void addLast(Object inputData) {

		SinglyLinkedListNode tempNode = new SinglyLinkedListNode(inputData);

		//Adding after the last element
		current.next = tempNode;
		current = current.next;

		count++;
	}

	/**
	 * Method to remove the last element of the Linked List
	 */
	public void removeLast(){

		SinglyLinkedListNode tempCurrent = head;

		//Navigate to the index
		while (true){
			//Penultimate node
			if(tempCurrent.next.next == null){
				tempCurrent.next = null;
				break;
			}
			tempCurrent = tempCurrent.next;
		}

		count--;
	}

	/**
	 * Method removes an element at a particular index
	 * @param index
	 */
	public void remove(int index) {

		SinglyLinkedListNode tempCurrent = head;

		//If index is the first index
		if(index == 0){
			removeFirst();
		}
		//If index is the last index
		else if(index == count-1){
			removeLast();
		}
		else{
			//Navigate to the index-2 element
			for(int i=0; i<index-1; i++){
				tempCurrent = tempCurrent.next;
			}

			tempCurrent.next = tempCurrent.next.next;

			count--;
		}
	}

	/**
	 * Method to find out if the LinkedList is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return (count == 0);
	}

	/**
	 * Method that returns the size of the Linkedlist
	 * @return
	 */
	public int getSize(){
		return count;
	}

	/**
	 * Method to write the LinkedList as a String
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

