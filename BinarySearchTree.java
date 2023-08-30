import java.util.ArrayList;

/**
 * BinarySearchTree class
 * 
 * The BinarySearchTree class holds the root
 * of the BST and a set of operations
 */
public class BinarySearchTree {
	
	// The root of the BST
	BSTNode root;

	/**
	 * BinarySearchTree constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * search(String value)
	 * Checks to see if the BST contains the value
	 * @param value, the String being searched for
	 * @return true if the tree contains the value
	 */
	public boolean search(String value) {
		// Sets boolean called 'found' equal to recursive search method
		boolean found = searchR(root, value);
		
		return found;
	}

	/**
	 * searchR(BSTNode cRoot, String value)
	 * Recursive search method to see if BST contains
	 * the value
	 * @param cRoot, the current root of the subtree
	 * @param value, String being searched for
	 * @return true if the tree contains the value
	 */
	private boolean searchR(BSTNode cRoot, String value) {
		// Set new boolean called 'found' to false
		boolean found = false;
		
		// Determines action depending if value is larger or smaller than root value
		if (cRoot == null) {
			return false;
		}
		else if (value.compareTo(cRoot.value) == 0) {
			return true;
		}
		else if (value.compareTo(cRoot.value) < 0) {
			found = searchR(cRoot.left, value);
		}
		else if (value.compareTo(cRoot.value) > 0) {
			found = searchR(cRoot.right, value);
		}
		
		return found;
	}

	/**
	 * insert(String value)
	 * Method to insert string into tree while
	 * maintaining lexicographical order
	 * @param value, the value to insert into tree
	 */
	public void insert(String value) {
		// Set root equal to recursive insert method
		root = insertR(root, value);
	}

	/**
	 * insertR(BSTNode cRoot, String value)
	 * Recursive method to insert string into tree
	 * while maintaining lexicographical order
	 * @param cRoot, the current root of the subtree
	 * @param value, the value to insert into tree
	 * @return cRoot, modified BSTNode after insertion
	 */
	private BSTNode insertR(BSTNode cRoot, String value) {
		// Determines action depending if value is larger or smaller than root value
		if (cRoot == null) {
			BSTNode newNode = new BSTNode(value);
			cRoot = newNode;
		}
		else if (value.compareTo(cRoot.value) < 0) {
			cRoot.left = insertR(cRoot.left, value);
		}
		else if (value.compareTo(cRoot.value) > 0) {
			cRoot.right = insertR(cRoot.right, value);
		}
		
		return cRoot;
	}

	/**
	 * remove(String value)
	 * Method to remove string from tree while
	 * maintaining lexicographical order
	 * @param value, the value to remove from tree
	 */
	public void remove(String value) {
		// Set root equal to recursive remove method
		root = removeR(root, value);
	}

	/**
	 * removeR(BSTNode cRoot, String value)
	 * Recursive method to remove string from tree
	 * while maintaining lexicographical order
	 * @param cRoot, current root of the subtree
	 * @param value, the value to insert into tree
	 * @return cRoot, modified BSTNode after deletion
	 */
	private BSTNode removeR(BSTNode cRoot, String value) {
		// Determines action depending if value is larger or smaller than root value
		if (cRoot != null) {
			if (value.compareTo(cRoot.value) < 0) {
				cRoot.left = removeR(cRoot.left, value);
			}
			else if (value.compareTo(cRoot.value) > 0) {
				cRoot.right = removeR(cRoot.right, value);
			}
			else if (value.compareTo(cRoot.value) ==  0){
				cRoot = deleteNode(cRoot);
			}
		}
		
		return cRoot;
	}

	/**
	 * dump()
	 * Method to print BST in an in-order traversal with
	 * each value on a seperate line
	 */
	public void dump() {
		// Calls recursive dump method
		dumpR(root);
	}

	/**
	 * dumpR(BSTNode cRoot)
	 * Method to print BST in an in-order traversal with
	 * each value on a seperate line
	 * @param cRoot, current root of the subtree
	 */
	private void dumpR(BSTNode cRoot) {
		// Returns if the root is null
		if (cRoot == null) {
			return;
		}
		
		// Operation order for in-order traversal
		dumpR(cRoot.left);
		System.out.print(cRoot.value + "\n");
		dumpR(cRoot.right);
	}

	/**
	 * height()
	 * Method to calculate height of BST
	 * @return recursive height method call (int)
	 */
	public int height() {
		// Returns recursive height method call which returns int
		return heightR(root);
	}

	/**
	 * heightR(BSTNode cRoot)
	 * Recursive method to calculate height of BST
	 * @param cRoot, current root of the subtree
	 * @return height of tree
	 */
	private int heightR(BSTNode cRoot) {
		// If current root is null, return -1
		if (cRoot == null) {
			return -1;
		}

		// Set left and right int height to recursive method calls
		int leftHeight = heightR(cRoot.left);
		int rightHeight = heightR(cRoot.right);

		// Determines what to return based on which subtree has a greater height
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
	}

	/**
	 * deleteNode(BSTNode cRoot)
	 * Method to delete node while keeping 
	 * lexicographical order
	 * @param cRoot, current root of the subtree
	 * @return BSTNode with altered value and children
	 */
	private BSTNode deleteNode(BSTNode cRoot) {
		// Determines how many children root has and what action to take
		if (cRoot.left == null && cRoot.right == null) {
			cRoot = null;
		}
		else if (cRoot.left == null && cRoot.right != null) {
			cRoot = cRoot.right;
		}
		else if (cRoot.right == null && cRoot.left != null) {
			cRoot = cRoot.left;
		}
		else {
			// Sets the current root value equal to lowest value from right subtree
			cRoot.value = getLowest(cRoot.right);
			// Sets right child to recursive removal of that node
			cRoot.right = removeR(cRoot.right, cRoot.value);
		}
		
		return cRoot;
	}

	/**
	 * getLowest(BSTNode cRoot)
	 * Method to find lowest value on the left subtree
	 * @param cRoot, current root of the subtree
	 * @return lowest String from left subtree
	 */
	private String getLowest(BSTNode cRoot) {
		// Set string to current root value
		String smallest = cRoot.value;
		
		// Get lowest value of left subtree
		while(cRoot.left != null) {
			smallest = cRoot.left.value;
			cRoot = cRoot.left;
		}

		return smallest;
	}

	/**
	 * hasPath(BSTNode cRoot, ArrayList<String> array, String value)
	 * Method to find if there is a path from root
	 * of the given node.
	 * @param cRoot, current root of the subtree
	 * @param array, ArrayList to populate with given path
	 * @param value, value to find path to
	 * @return true if there is a path to value
	 */
	public boolean hasPath(BSTNode cRoot, ArrayList<String> array, String value) {
		// If the current root is null, return false
		if (cRoot == null) {
			return false;
		}
		
		// Add the value from the current root to the array
		array.add(cRoot.value);
		
		// If the value is at the current node, return true
		if (cRoot.value.compareTo(value) ==  0) {
			return true;
		}

		// If there is a path to value from left AND right child, return true
		if (hasPath(cRoot.left, array, value) || hasPath(cRoot.right, array, value)) {
			return true;
		}
		
		// Remove value from array
		array.remove(array.size()-1);
		
		return false;
	}

	/**
	 * printPath(String value)
	 * Method to print path to given value
	 * @param value, value to print path to
	 */
	public void printPath(String value) {
		// Creates new array to store values
		ArrayList<String> array = new ArrayList<>();

		// Checks whether there is a path to value and prints values from array
		if (hasPath(root, array, value)) {
			for (int i = 0; i < array.size() - 1; i++) {
				System.out.print(array.get(i) + " ");
			}
			// Prints last value from array
			System.out.print(array.get(array.size() - 1));
		}
	}

}