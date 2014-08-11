package stacks;

/**
 *
 * StackImplUsingArray Class with basic stack methods
 */
public class StackImplUsingArray {

	private int stackSize;
	private int[] stackArray;
	private int topIndex;


	/**
	 * Constructor
	 */
	public StackImplUsingArray(int size){

		this.stackSize = size;
		stackArray = new int[stackSize];
		this.topIndex = -1;
	}

	/**
	 * Method to find if an element exists in the StackImplUsingArray
	 * @param element
	 * @return
	 */
	public int findElement(int element) {

		int index = -1;

		//Linear Search
		for(int i=0; i<stackArray.length; i++) {
			if(stackArray[i]== element){
				index = i;
			}
		}
		return index;
	}

	/**
	 * Method to add an element into the StackImplUsingArray
	 * @param element
	 */
	public void push(int element) {

		stackArray[++topIndex] = element;
	}

	/**
	 * Method to pop an element out of the stack
	 * @return
	 */
	public int pop(){
		int popElement;

		popElement = stackArray[topIndex--];

		return popElement;
	}

	/**
	 * Method to check if the StackImplUsingArray is empty
	 * @return
	 */
	public boolean isEmpty(){

		boolean isEmpty = false;

		if(topIndex==-1){
			isEmpty = true;
		}

		return isEmpty;
	}
}
