package queues;

/**
 *
 * The Queue Class implemented using an array
 */
public class QueueImplUsingArray {

	private int queueSize;
	private int[] queueArray;
	private int frontIndex;
	private int rearIndex;

	/**
	 * Constructor
	 * @param size : size of the queue to be initialized
	 */
	public QueueImplUsingArray(int size){

		this.queueSize = size;
		queueArray = new int[queueSize];
		frontIndex = 0;
		rearIndex = -1;
	}

	/**
	 * Method to push an element into the Queue
	 * @param element
	 */
	public void offer(int element) {

		if(rearIndex == queueSize-1) {
			throw new IllegalStateException("Queue is Full");
		}

		queueArray[++rearIndex] = element;
	}

	/**
	 * Method to check if the queue is empty or not
	 * @return true or false
	 */
	public boolean isEmpty(){
		boolean isEmpty = false;

		if(frontIndex == 0 && rearIndex == -1)
		{
			isEmpty = true;
		}
		return isEmpty;
	}

	/**
	 * Method to check if the queue is full or not
	 * @return
	 */
	public boolean isFull() {
		boolean isFull = false;

		if (rearIndex - frontIndex + 1 == queueSize) {
			isFull = true;
		}

		return isFull;
	}

	/**
	 * Method to give the present size of the queue
	 * @return
	 */
	public int presentQueueSize(){

		return (rearIndex - frontIndex) +1;
	}

	/**
	 * Method that shows the element at the front index
	 * @return the element at the front index
	 */
	public int peek(){
		return queueArray[frontIndex];
	}

	/**
	 * Method that removes an element from the front of the queue
	 * @return
	 */
	public int remove(){
		return queueArray[frontIndex++];
	}

	/**
	 * Method that writes the queue to a string
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		for(int i=frontIndex; i<=rearIndex; i++){
			if(i!=rearIndex) {
				finalString = finalString + queueArray[i] + " ";
			}
			else{
				finalString = finalString + queueArray[i];
			}
		}

		return finalString;
	}
}
