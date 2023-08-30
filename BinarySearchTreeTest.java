import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class BinarySearchTreeTest {

	 private final PrintStream standardOut = System.out;
	 private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	 @BeforeEach
	 public void setOut() {
	 	System.setOut(new PrintStream(outputStreamCaptor));
	 }

	 @Test
	 @DisplayName("Search test with value at root, expected true")
	 public void searchTestWithValueAtRoot() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	BSTNode node = new BSTNode("the");
	 	bst.root = node;
	 	boolean found = bst.search("the");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Search test with value down left subtree, expected true")
	 public void searchTestWithValueDownLeftSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	BSTNode node = new BSTNode("the");
	 	BSTNode node1 = new BSTNode("quick");
	 	bst.root = node;
	 	bst.root.left = node1;
	 	boolean found = bst.search("quick");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Search test with value down right subtree, expected true")
	 public void searchTestWithValueDownRightSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	BSTNode node = new BSTNode("the");
	 	BSTNode node1 = new BSTNode("zebra");
	 	bst.root = node;
	 	bst.root.right = node1;
	 	boolean found = bst.search("zebra");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Search test with value not in tree, expected false")
	 public void searchTestWithValueNotInTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	BSTNode node = new BSTNode("the");
	 	BSTNode node1 = new BSTNode("zebra");
	 	BSTNode node2 = new BSTNode("fox");
	 	bst.root = node;
	 	bst.root.left = node2;
	 	bst.root.right = node1;
	 	boolean found = bst.search("jumped");
	 	Assertions.assertEquals(found, false);
	 }

	 @Test
	 @DisplayName("Search test with empty tree, expected false")
	 public void searchTestWithEmptyTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	boolean found = bst.search("the");
	 	Assertions.assertEquals(found, false);
	 }

	 @Test
	 @DisplayName("Search test with large tree, dependant on insert, expected true")
	 public void searchTestWithLargeTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	
	 	bst.insert("the");
	 	bst.insert("zebra");
	 	bst.insert("fox");
	 	bst.insert("quick");
	 	bst.insert("brown");
	 	bst.insert("jumped");
	 	bst.insert("over");
	 	bst.insert("lazy");
	 	bst.insert("dog");
	 	bst.insert("under");
	 	bst.insert("very");
	 	bst.insert("winner");

	 	boolean found = bst.search("lazy");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Insert test with insertion at root, dependant on search, expected true")
	 public void insertTestWithInsertionAtRoot() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	boolean found = bst.search("the");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Insert test with insertion down left subtree, dependant on search, expected true")
	 public void insertTestWithInsertionDownLeftSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("brown");
	 	boolean found = bst.search("brown");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Insert test with insertion down right subtree, dependant on search, expected true")
	 public void insertTestWithInsertionDownRightSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("quick");
	 	boolean found = bst.search("quick");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Insert test with value already in tree, dependant on search, expected true")
	 public void insertTestWithInsertionWithIdenticalValue() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("the");
	 	boolean found = bst.search("the");
	 	Assertions.assertEquals(found, true);
	 }

	 @Test
	 @DisplayName("Remove test with only root node, dependant on insert, expected true")
	 public void removeTestWithValueAtRoot() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.remove("the");
	 	boolean removed = bst.root == null;
	 	Assertions.assertEquals(removed, true);
	 }

	 @Test
	 @DisplayName("Remove test down left subtree, dependant on insert, expected true")
	 public void removeTestWithValueDownLeftSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("brown");
	 	bst.remove("brown");
	 	boolean removed = bst.root.left == null;
	 	Assertions.assertEquals(removed, true);
	 }

	 @Test
	 @DisplayName("Remove test down right subtree, dependant on insert, expected true")
	 public void removeTestWithValueDownRightSubtree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("quick");
	 	bst.remove("quick");
	 	boolean removed = bst.root.right == null;
	 	Assertions.assertEquals(removed, true);
	 }

	 @Test
	 @DisplayName("Remove test when value isnt in tree, dependant on insert, expected true")
	 public void removeTestWithNotinTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("brown");
	 	bst.remove("fox");
	 	
	 	boolean same = bst.root.value == "the";
	 	Assertions.assertEquals(same, true);
	 }

	 @Test
	 @DisplayName("Remove test in large tree, dependant on insert and search, expected true")
	 public void removeTestWithLargeTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("zebra");
	 	bst.insert("fox");
	 	bst.insert("quick");
	 	bst.insert("brown");
	 	bst.insert("jumped");
	 	bst.insert("over");
	 	bst.insert("lazy");
	 	bst.insert("dog");
	 	bst.insert("under");
	 	bst.insert("very");
	 	bst.insert("winner");

	 	bst.remove("over");
	 	boolean found = bst.search("over");
	 	Assertions.assertEquals(found, false);
	 }

	 @Test
	 @DisplayName("Dump test with one node, dependant on insert, expected true")
	 public void dumpTestWithOneNode() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	
	 	bst.dump();
	 	String actual = outputStreamCaptor.toString();
	 	
	 	Assertions.assertEquals(actual, "the\n");
	 }

	 @Test
	 @DisplayName("Dump test with empty tree, dependant on insert, expected true")
	 public void dumpTestWithEmptyTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	
	 	bst.dump();
	 	String actual = outputStreamCaptor.toString();
	 	
	 	Assertions.assertEquals(actual, "");
	 }

	 @Test
	 @DisplayName("Dump test with large tree, expected true")
	 public void dumpTestWithLargeTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("the");
	 	bst.insert("zebra");
	 	bst.insert("fox");
	 	bst.insert("quick");
	 	bst.insert("brown");
	 	bst.insert("jumped");
	 	bst.insert("over");
	 	bst.insert("lazy");
	 	bst.insert("dog");
	 	bst.insert("under");
	 	bst.insert("very");
	 	bst.insert("winner");
	 	
	 	bst.dump();
	 	String actual = outputStreamCaptor.toString();
	 	
	 	Assertions.assertEquals(actual, "brown\ndog\nfox\njumped\nlazy\nover\nquick\nthe\nunder\nvery\nwinner\nzebra\n");
	 }

	 @Test
	 @DisplayName("Dump test with equal tree, dependant on insert, expected true")
	 public void dumpTestWithBalancedTree() {
	 	BinarySearchTree bst = new BinarySearchTree();

	 	bst.insert("e");
	 	bst.insert("f");
	 	bst.insert("d");

	 	
	 	bst.dump();
	 	String actual = outputStreamCaptor.toString();
	 	
	 	Assertions.assertEquals(actual, "d\ne\nf\n");
	 }

	 @Test
	 @DisplayName("Height test with empty tree, expected true")
	 public void heightTestWithEmptyTree() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	
	 	int height = bst.height();
	 	
	 	Assertions.assertEquals(height, -1);
	 }

	 @Test
	 @DisplayName("Height test with one node, dependant on insert, expected true")
	 public void heightTestWithOneNode() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("a");
	 	int height = bst.height();
	 	
	 	Assertions.assertEquals(height, 0);
	 }

	 @Test
	 @DisplayName("Height test with three nodes, dependant on insert, expected true")
	 public void heightTestWithThreeNodes() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("b");
	 	bst.insert("a");
	 	bst.insert("c");

	 	int height = bst.height();
	 	
	 	Assertions.assertEquals(height, 1);
	 }

	 @Test
	 @DisplayName("Height test with seven nodes, dependant on insert, expected true")
	 public void heightTestWithSevenNodes() {
	 	BinarySearchTree bst = new BinarySearchTree();
	 	bst.insert("f");
	 	bst.insert("g");
	 	bst.insert("h");
	 	bst.insert("i");
	 	bst.insert("e");
	 	bst.insert("d");
	 	bst.insert("c");

	 	int height = bst.height();
	 	
	 	Assertions.assertEquals(height, 3);
	 }


}