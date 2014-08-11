package queues;

/**
 *
 * The Generic Queue usage class
 */
public class QueueUsage {

	public static void main(String[] args){

		QueueImplUsingArray queueImplUsingArray = new QueueImplUsingArray(10);

		queueImplUsingArray.offer(1);
		queueImplUsingArray.offer(2);
		queueImplUsingArray.offer(3);
		queueImplUsingArray.offer(4);
		queueImplUsingArray.offer(5);
		queueImplUsingArray.offer(6);
		queueImplUsingArray.offer(7);
		queueImplUsingArray.offer(8);
		queueImplUsingArray.remove();
		queueImplUsingArray.remove();

		System.out.println("Queue Using Array Result: " + queueImplUsingArray.toString());

		QueueImplUsingStacks queueImplUsingStacks = new QueueImplUsingStacks();
		queueImplUsingStacks.enqueue(1);
		queueImplUsingStacks.enqueue(2);
		queueImplUsingStacks.enqueue(3);
		queueImplUsingStacks.enqueue(4);
		queueImplUsingStacks.enqueue(5);
		queueImplUsingStacks.dequeue();
		queueImplUsingStacks.dequeue();
		queueImplUsingStacks.enqueue(7);
		queueImplUsingStacks.dequeue();
		queueImplUsingStacks.enqueue(10);

		System.out.println("Queue Using Two Stacks Result: " + queueImplUsingStacks);

		QueueImplUsingStack queueImplUsingStack = new QueueImplUsingStack();

		queueImplUsingStack.enqueue(1);
		queueImplUsingStack.enqueue(2);
		queueImplUsingStack.enqueue(3);
		queueImplUsingStack.enqueue(4);
		queueImplUsingStack.enqueue(5);
		queueImplUsingStack.dequeue();
		queueImplUsingStack.enqueue(6);

		System.out.println("Queue Using Stack Result: " + queueImplUsingStack.toString());

		QueueImplUsingLinkedList queueImplUsingLinkedList = new QueueImplUsingLinkedList();

		queueImplUsingLinkedList.enqueue(1);
		queueImplUsingLinkedList.enqueue(2);
		queueImplUsingLinkedList.enqueue(3);
		queueImplUsingLinkedList.enqueue(4);
		queueImplUsingLinkedList.enqueue(5);
		queueImplUsingLinkedList.enqueue(6);
		queueImplUsingLinkedList.dequeue();

		System.out.println("Queue Using Linked List Result: " + queueImplUsingLinkedList.toString());
	}
}
