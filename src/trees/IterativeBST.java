package trees;

import common.TreeNode;

/**
 * Created by abhishekbarla on 12/5/16.
 * This class has methods of BST implementation using iteration
 */
public class IterativeBST {

	TreeNode root;

	public boolean remove(int key){
		TreeNode current = root;
		TreeNode parent;
		boolean isLeftChild = false;

		if(root == null){
			return false;
		}
		//Find the node to remove
		while(true){
			parent = current;

			if(key == current.key){
				break;
			}
			else if(key < current.key){
				current = current.left;
				isLeftChild = true;
				if(current == null){
					return false;
				}
			}
			else{
				current = current.right;
				isLeftChild = false;
				if(current == null){
					return false;
				}
			}
		}

		//The current node is the node to remove
		//Case 1: If the current node is a leaf
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			else{
				if(isLeftChild){
					parent.left = null;
				}
				else{
					parent.right = null;
				}
			}
			return true;
		}

		//Case 2: If the current node has one child
		if(current.left==null){
			if(current==root){
				root = current.right;
			}
			else if(isLeftChild){
				parent.left = current.right;
			}
			else{
				parent.right = current.right;
			}
			return true;
		}
		else if (current.right==null){
			if(current==root){
				root = current.left;
			}
			else if(isLeftChild){
				parent.left = current.left;
			}
			else {
				parent.right = current.left;
			}
			return true;
		}

		else if(current.left!=null && current.right!=null){
			//Case 3: If the current node has 2 children
			//Then find the minimum of the right subtree (successor) and replace that with the current node
			TreeNode successor = findAndGetSuccessor(current);
			int successorKey = successor.key;
			//Remove the successor node
			remove(successorKey);

			if(current==root){
				root.key = successorKey;
			}
			else if(isLeftChild){
				parent.left.key = successorKey;
			}
			else{
				parent.right.key = successorKey;
			}
			return true;
		}
		return  false;
	}

	/**
	 * Method to find the successor node in the subtree
	 * whose root is the input argument of this method
	 * Finding the successor can be implemented in two ways,
	 * 1. The largest node in the left subtree
	 * 2. The smallest node in the right subtree
	 * This implementation is of finding the smallest node in the right subtree
	 * @param input
	 * @return
	 */
	public TreeNode findAndGetSuccessor(TreeNode input){
		TreeNode temp = input.right;
		TreeNode parent = null;
		while (temp.left!=null){
			parent = temp;
			temp = temp.left;
		}

		/*//Now the temp node is the node (successor) which has no left child but may have a right child
		//If it has the right child, then attach it to the parent's left child
		if(temp.right!=null){
			parent.left = temp.right;
			temp.right = null;
		}*/
		return temp;
	}
}


