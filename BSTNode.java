/**
 * BSTNode class
 *
 * The BSTNode class holds the value of the node
 * and the left and right children
 */
public class BSTNode {

	// Value of BSTNode
	public String value;
	
	// Left child of BSTNode
	public BSTNode left;

	// Right child of BSTNode
	public BSTNode right;

	/**
	 * BSTNode constructor
	 */
	public BSTNode(String s) {
		value = s;
		left = null;
		right = null;
	}

}