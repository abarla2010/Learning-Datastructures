package queues;

/**
 *
 * Class that uses the PriorityQueueImplUsingArray Class
 */
public class PriorityQueueUsage {

	public static PriorityQueueImplUsingArray pq;

	public static void main(String[] args){

		String finalString = "";

		pq = new PriorityQueueImplUsingArray(10);

		//Add elements to the priority queue

		pq.offer(22);
		pq.offer(23);
		pq.offer(11);
		pq.offer(34);
		pq.offer(31);
		pq.offer(40);
		pq.offer(20);
		pq.offer(10);
		pq.offer(50);
		pq.offer(30);

		//System.out.println(pq.toString());

		while(!pq.isEmpty()){

			if(pq.size() == 1){
				finalString = finalString + pq.remove();
			}
			else {
				finalString = finalString + pq.remove() + " ";
			}
		}

		System.out.println(finalString);



		PriorityQueueImplUsingLinkedList priorityQueueImplUsingLinkedList = new PriorityQueueImplUsingLinkedList();

		priorityQueueImplUsingLinkedList.offer(10);
		priorityQueueImplUsingLinkedList.offer(20);
		priorityQueueImplUsingLinkedList.offer(200);
		priorityQueueImplUsingLinkedList.offer(2223);
		priorityQueueImplUsingLinkedList.offer(11);
		priorityQueueImplUsingLinkedList.offer(210);
		//priorityQueueImplUsingLinkedList.remove();

		priorityQueueImplUsingLinkedList.display();
	}
}
