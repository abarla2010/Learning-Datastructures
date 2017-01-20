package trees;

import java.util.Scanner;

/**
 * Created by abhishekbarla on 11/26/16.
 * This class uses the Binary Search Tree
 */
public class BinarySearchTreeUsage {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();

		do{
			System.out.println("Operations in this BST program: (Please select an option)");
			System.out.println("1. Insert a key");
			System.out.println("2. Find a key");
			System.out.println("3. Check if BST is empty");
			System.out.println("4. Delete a key in the BST");
			System.out.println("5. Print In-order traversal of BST");
			System.out.println("6. Print Pre-order traversal of BST");
			System.out.println("7. Print Post-order traversal of BST");
			System.out.println("8. Print Tree");
			int userChoice = Integer.parseInt(sc.nextLine());
			switch(userChoice){
			case 1:
				System.out.println("Enter the numbers followed by spaces to insert.");
				String numbersString = sc.nextLine();
				String[] numbers = numbersString.split(" ");
				for(String num : numbers){
					bst.insert(Integer.parseInt(num));
				}
				break;
			case 2:
				System.out.println("Enter the key to find:");
				int key = Integer.parseInt(sc.nextLine());
				if(bst.contains(key)){
					System.out.println("The Node with key " +key+ " was found!");
				}
				else{
					System.out.println("The Node with key " +key+ " is not there in the BST!");
				}
				break;
			case 3:
				if(bst.isEmpty()){
					System.out.println("BST is empty!");
				}
				else{
					System.out.println("BST is not empty");
				}
				break;
			case 4:
				System.out.println("Enter the key of the BST to remove:");
				int removeKey = sc.nextInt();
				sc.nextLine();
				if(bst.remove(removeKey)==false){
					System.out.println("The key: " +removeKey + " was not found in the BST");
				}else{
					System.out.println("The key: " + removeKey + " was successfully removed from the BST");
				}
				break;
			case 5:
				bst.inOrderTraversal();
				System.out.println();
				break;
			case 8:
				bst.printTree();
				break;
			default:
				System.out.println("Please enter a valid entry");
				break;
			}
			System.out.println("Do you want to perform more operations on the BST? (yes/no)");
		}
		while(sc.nextLine().equals("yes"));
		System.out.println("Binary Search Tree program exited");
		System.exit(1);
	}
}
