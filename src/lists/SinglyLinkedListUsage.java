package lists;

import iterator.LinkedListIteratorInterface;
import iterator.SinglyLinkedListIterator;

/**
 * Singly Linked list usage class
 */
public class SinglyLinkedListUsage {

	public static void main(String[] args){

		LinkedList lk1 = new LinkedList();

		LinkedList lk = new LinkedList();

		/*lk1.add(10);
		lk1.add(20);
		lk1.add(30);
		lk1.add(40);
		lk1.add(50);
		lk1.add(0,-1);
		lk1.addFirst(-10);
		lk1.addLast(0);
		lk1.add(0,-2);
		lk1.remove(1);
		lk1.addLast(95);
		lk1.insertAfter(20, 100);
		lk1.insertAfter(50, 52);
		lk1.insertBefore(-2, -3);
		lk1.insertBefore(52, 51);
		lk1.insertBefore(100,99);
		lk1.insertBefore(99,98);
		lk1.addFirst(200);
		lk1.addFirst(100);
		lk1.addLast(100);
		lk1.removeLast();
		lk1.remove(0);
		lk1.removeFirst();*/
		//lk1.remove(2);



		//System.out.println(lk1.toString() + " size " + lk1.size());

		lk.add(5);
		lk.add(4);
		//lk.add(1,2);
		lk.add(3);
		lk.add(10);
		System.out.println(lk.getLast());
		LinkedListIteratorInterface iterator = new SinglyLinkedListIterator(lk);

		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}



	}
}
