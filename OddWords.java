import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * OddWords class
 * 
 * The OddWords class holds the processFile method
 */
public class OddWords {

	/**
	 * processFile(String fileName)
	 * Method that processes strings from a file and inserts
	 * it into BST while holding to certain specifications
	 * @param fileName, name of the file to read text from
	 */
	public void processFile(String fileName) {
		// Create new BinarySearchTree
		BinarySearchTree bst = new BinarySearchTree();
		
		// File reading try and catch block
    	try {
      		// Creates objects required to read from file
      		File file = new File(fileName);
      		Scanner sc = new Scanner(file);
      		
      		// While file has another word
      		while (sc.hasNext()) {
        		String word = sc.next();
        		// If the word isn't already in the BST
        		if (!bst.search(word)) {
        			// Insert word and print the path to that value
        			bst.insert(word);
        			bst.printPath(word);
        			System.out.print(" INSERTED");
        			System.out.println();
        		}
        		else {
        			// Print path to value to be deleted and then remove
        			bst.printPath(word);
        			System.out.print(" DELETED\n");
        			bst.remove(word);
        		}
      		}

      		sc.close();

    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}

    	// Print all values from BST in an in-order traversal
    	System.out.println();
    	System.out.println("LEXICON:");
    	bst.dump();
	}
}