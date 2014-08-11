package queues;

/**
 * Priority Queue implementation using array
 *
 * In this class, the minimum element is stored at the end of the array
 */
public class PriorityQueueImplUsingArray {

	private int priorityQueueSize;
	int[] priorityQueueArray;
	int numberOfElements;

	/**
	 * Constructor
	 * @param size
	 */
	public PriorityQueueImplUsingArray(int size){
		this.priorityQueueSize = size;
		priorityQueueArray = new int[priorityQueueSize];
		numberOfElements = 0;
	}

	/**
	 * Method to add an element to the priority queue
	 * @param element
	 */
	public void offer(int element){

		int i;

		if(numberOfElements == 0){
			priorityQueueArray[numberOfElements++] = element;
		}
		else
		{
			//Finding the right spot for the element according to the correct sorting order
			for(i=numberOfElements-1; i>=0; i--){
				if(element > priorityQueueArray[i]){
					priorityQueueArray[i+1] = priorityQueueArray[i];
				}
				else {
					break;
				}
			}

			//Place the element in the correct spot
			priorityQueueArray[i+1] = element;
			numberOfElements++;
		}
	}

	/**
	 * Method to return the minimum element in the priority queue
	 * @return
	 */
	public int remove(){
		return priorityQueueArray[--numberOfElements];
	}

	/**
	 * Method to check if the priority queue is empty
	 * @return
	 */
	public boolean isEmpty(){
		return (numberOfElements == 0);
	}

	/**
	 * Method to check if the priority queue is full
	 * @return
	 */
	public boolean isFull(){
		return (numberOfElements == priorityQueueSize);
	}

	/**
	 * Method that returns the number of elements in the priority queue
	 * @return
	 */
	public int size(){
		return numberOfElements;
	}

	/**
	 * Method that writes the priority queue to a string
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		for(int i=0; i<numberOfElements; i++){
			if(i!=numberOfElements-1) {
				finalString = finalString + priorityQueueArray[i] + " ";
			}
			else{
				finalString = finalString + priorityQueueArray[i];
			}
		}

		return finalString;
	}

}
