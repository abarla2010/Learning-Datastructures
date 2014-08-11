package stacks;

/**
 *
 * Class that uses the StackImplUsingArray Class
 */
public class StackUsage {

	public static void main(String [] args) {

		int stackSize = 5;
		StackImplUsingArray stack = new StackImplUsingArray(stackSize);

		StackImplUsingLinkedList stackImplUsingLinkedList = new StackImplUsingLinkedList();

		stackImplUsingLinkedList.push(1);
		stackImplUsingLinkedList.push(2);
		stackImplUsingLinkedList.push(3);
		stackImplUsingLinkedList.push(4);
		stackImplUsingLinkedList.push(5);

		System.out.println(stackImplUsingLinkedList.isEmpty());

		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(2);
		stack.push(0);
		//stack.push(200);

		System.out.println(stack.findElement(0));
		System.out.println("Stack Using Array: ");
		//Printing the StackImplUsingArray
		for (int i=0; i<stackSize; i++) {
			if(i!=stackSize-1) {
				System.out.print(stack.pop() + " ");
			}
			else {
				System.out.print(stack.pop());
			}
		}
		System.out.println();
		System.out.println("Stack Using Linked List: " + stackImplUsingLinkedList.toString());

	}
}
