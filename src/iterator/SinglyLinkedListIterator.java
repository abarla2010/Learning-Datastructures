package iterator;

import lists.LinkedList;

/**
 * Created by abhishekbarla on 11/23/16.
 */
public class SinglyLinkedListIterator implements LinkedListIteratorInterface{


	public LinkedList list;
	public Node head;
	public Node current;

	public SinglyLinkedListIterator(LinkedList list){
		this.list = list;
		this.head = list.head;
		this.current = head;
	}


	public boolean hasNext(){
		return (!list.isEmpty() && current !=null);
	}

	public Object next(){
		Node temp = current;
		current = current.next;
		return temp.data;
	}

	@Override public boolean hasPrevious() {
		return false;
	}

	@Override public Object previous() {
		return null;
	}

}

