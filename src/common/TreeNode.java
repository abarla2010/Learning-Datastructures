package common;

/**
 * Created by abhishekbarla on 11/26/16.
 * Helper class of Node for all tree based data structures with data types of int
 */
public class TreeNode {

	public int key;
	public TreeNode left;
	public TreeNode right;

	/**
	 * Constructor for TreeNode Class
	 * @param key
	 * @return
	 */
	public TreeNode(int key){
		this.key = key;
	}
}
