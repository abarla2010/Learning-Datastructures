package lists;

import iterator.LinkedListIteratorInterface;

import java.util.LinkedList;

/**
 * Doubly LinkedList usage class
 */
public class DoublyLinkedListUsage {

	public static void main(String[] args){

		LinkedList linkedList = new LinkedList();

		linkedList.add(0,1);
		linkedList.add(1,2);
		linkedList.add(2,2);
		//linkedList.add(12,10);
		System.out.println(linkedList);

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		doublyLinkedList.add(1);
		doublyLinkedList.add(2);
		doublyLinkedList.removeLast();
		doublyLinkedList.add(3);
		doublyLinkedList.add(4);
		doublyLinkedList.add(5);
		doublyLinkedList.add(6);
		doublyLinkedList.add(7);
		//doublyLinkedList.add(11,100);
		doublyLinkedList.add(8);
		doublyLinkedList.add(9);
		doublyLinkedList.add(10);
		doublyLinkedList.insertAfter(10,11111);
		doublyLinkedList.removeFirst();
		doublyLinkedList.add(11);
		doublyLinkedList.addLast(12);
		doublyLinkedList.addFirst(0);
		doublyLinkedList.add(2,2);
		doublyLinkedList.add(0,-1);
		doublyLinkedList.insertBefore(12,1000);
		//doublyLinkedList.remove(1);
		doublyLinkedList.insertAfter(1000,1001);
		//doublyLinkedList.add(14,13);
		//doublyLinkedList.removeLast();*/

		System.out.println(doublyLinkedList.toString() + " Size : " + doublyLinkedList.getSize());



		DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();
		doublyLinkedList1.add(1);
		doublyLinkedList1.add(2);
		doublyLinkedList1.add(3);
		doublyLinkedList1.add(4);

		LinkedListIteratorInterface linkedListIterator = doublyLinkedList1.getIterator();
		System.out.println("Printing forward....");
		while(linkedListIterator.hasNext()){
			System.out.print(linkedListIterator.next() + " ");
		}
		System.out.println();
		System.out.println("Printing backward....");
		while(linkedListIterator.hasPrevious()){
			System.out.print(linkedListIterator.previous() + " ");
		}
	}
}
