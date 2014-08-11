package common;

/**
 * PriorityQueueNode
 */
public class PriorityQueueNode implements Comparable<Object> {

	public PriorityQueueNode next;
	public PriorityQueueNode previous;
	public Object data;

	/**
	 * Constructor
	 */
	public PriorityQueueNode(Object inputData){
		this.data = inputData;
		this.next = null;
	}

	/**
	 * Method that compares two objects when they are integers
	 * This method returns 0, when both objects are equal,
	 * returns 1 when the inputObject is lesser and -1 otherwise.
	 * @param inputObject
	 * @return
	 */
	@Override
	public int compareTo(Object inputObject){

		Integer inputInteger;
		Integer thisInteger;

		//If the object is an integer
		if( inputObject instanceof  Integer){

			inputInteger = (Integer) inputObject;
			thisInteger = (Integer) this.data;

			if(inputInteger == thisInteger){
				return 0;
			}
			else if(inputInteger < thisInteger){
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Method that prints the node
	 */
	public void printNode(){
		System.out.print(this.data + " ");
	}
}
