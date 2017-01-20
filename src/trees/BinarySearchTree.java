package trees;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhishekbarla on 11/26/16.
 */
public class BinarySearchTree {

	TreeNode root;

	/**
	 * Function to add a key to the Binary Search Tree
	 * @param key
	 */
	public void insert(int key){
		TreeNode inputNode = new TreeNode(key);

		if(root == null){
			root = inputNode;
		}
		else{
			TreeNode temp = root;
			TreeNode parent;
			while(true){
				parent = temp;

				if(key < temp.key){
					temp = temp.left;
					if(temp == null){
						parent.left = inputNode;
						return;
					}
				}
				else{
					temp = temp.right;
					if(temp == null){
						parent.right = inputNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * Method to check if a key exists or not in the BST
	 * @param key
	 * @return
	 */
	public boolean contains(int key){
		TreeNode current = root;
		while(current!=null){
			if(key == current.key){
				return true;
			}
			else if(key < current.key){
				current = current.left;
			}
			else{
				current = current.right;
			}
		}
		return false;
	}

	/**
	 * Method to remove a particular key from the BST TODO
	 * @param key
	 * @return
	 */
	public boolean remove(int key){
		TreeNode target = new TreeNode(key);
		return remove(key, root, root, false);
	}

	private boolean remove(int key, TreeNode node, TreeNode parent, boolean isLeft){
		if(node==null || parent==null){
			return false;
		}

		if(key == node.key){

			//If target node has no children
			if(node.left==null && node.right==null){
				if(node == root){
					root = null;
				}
				else if(isLeft){
					parent.left = null;
				}
				else{
					parent.right = null;
				}
			}
			//If target node has one child
			else if(node.left ==null){
				if(node == root){
					root = node.right;
				}
				else if(isLeft){
					parent.left = node.right;
				}
				else{
					parent.right = node.right;
				}
			}
			else if(node.right == null){
				if(node == root){
					root = node.left;
				}
				else if(isLeft){
					parent.left = node.left;
				}
				else{
					parent.right = node.left;
				}
			}

			//If target node has two children
			//Find successor (least element) in the right child and replace
			else{
				Successor successor = findSuccessor(node);
				remove(successor.key, successor.node, successor.parent, successor.isLeft);

				if(node == root){
					root.key = successor.key;
				}
				else {
					node.key = successor.key;
				}
			}
			return true;
		}
		else if(key < node.key){
			parent = node;
			return remove(key, node.left, node, true);
		}
		else{
			parent = node;
			return remove(key, node.right, node, false);
		}
	}

	private Successor findSuccessor(TreeNode node){
		if(node==null){
			return null;
		}

		TreeNode current = node.right;
		TreeNode parent = current;
		while(current.left!=null){
			parent = current;
			current = current.left;
		}

		if(current.right!=null){
			parent.left = current.right;
		}

		return new Successor(current.key, current, parent, true);
	}



	/**
	 * Method to call the printInOrderTraversal Method
	 */
	public void inOrderTraversal(){
		printInOrderTraversal(root);
	}

	/**
	 * Helper method to print the In-Order Traversal
	 * @param node
	 */
	private void printInOrderTraversal(TreeNode node){
		if(node!=null){
			printInOrderTraversal(node.left);
			System.out.print(node.key + " ");
			printInOrderTraversal(node.right);
		}
	}

	/**
	 * Method to check if the BST is empty
	 * @return
	 */
	public boolean isEmpty(){
		return root==null;
	}

	/**
	 * Method to print the tree
	 */
	public void printTree(){
		printVisualTree(root);
	}

	/**
	 * Method to print the visual representation of the tree
	 * @param root
	 */
	private void printVisualTree(TreeNode root){

		if(root==null){
			return;
		}

		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.add(root);

		while(!queue1.isEmpty()){
			TreeNode temp = queue1.remove();
			System.out.print(temp.key + " ");

			//Add temp node's children to queue2
			queue2 = addChildren(temp, queue2);

			//Swap the queues if queue1 is empty
			if(queue1.isEmpty()){
				System.out.println();
				Queue<TreeNode> tempQueue = queue2;
				queue2 = queue1;
				queue1 = tempQueue;
			}
		}
	}

	/**
	 * Helper method to get the unvisited children for a given TreeNode
	 * @param temp
	 * @return
	 */
	private Queue<TreeNode> addChildren(TreeNode temp, Queue<TreeNode> queue){
		if(temp.left!=null){
			queue.add(temp.left);
		}
		if(temp.right!=null){
			queue.add(temp.right);
		}
		return queue;
	}

}

class Successor{
	int key;
	TreeNode parent;
	TreeNode node;
	boolean isLeft;

	Successor(int key, TreeNode node, TreeNode parent, boolean isLeft){
		this.key = key;
		this.parent = parent;
		this.node = node;
		this.isLeft = isLeft;
	}
}
