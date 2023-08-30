import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class OddWordsTest {

	private final PrintStream standardOut = System.out;
	 private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	 @BeforeEach
	 public void setOut() {
	 	System.setOut(new PrintStream(outputStreamCaptor));
	 }

	 @Test
	 @DisplayName("processFile test with empty tree, expected true")
	 public void processFileTestWithEmptyTree() {
	 	OddWords oddWords = new OddWords();
	 	oddWords.processFile("processFileWithEmptyTree.txt");
	 	String actual = outputStreamCaptor.toString().trim();
	 	Assertions.assertEquals(actual, "the INSERTED" + System.lineSeparator()
	 							+ System.lineSeparator() + "LEXICON:" 
	 							+ System.lineSeparator() + "the");
	 }

	 @Test
	 @DisplayName("processFile test with more words, expected true")
	 public void processFileTestWithMoreWords() {
	 	OddWords oddWords = new OddWords();
	 	oddWords.processFile("processFileTestWithMoreWords.txt");
	 	String actual = outputStreamCaptor.toString().trim();
	 	Assertions.assertEquals(actual, "the INSERTED" + System.lineSeparator()
	 							+ "the quick INSERTED" + System.lineSeparator()
	 							+ "the quick brown INSERTED" + System.lineSeparator() 
	 							+ System.lineSeparator() + "LEXICON:" + System.lineSeparator() 
	 							+ "brown\nquick\nthe");
	 }

	 @Test
	 @DisplayName("processFile removal test with one word, expected true")
	 public void processFileRemovalTestWithOneWord() {
	 	OddWords oddWords = new OddWords();
	 	oddWords.processFile("processFileRemovalTestWithOneWord.txt");
	 	String actual = outputStreamCaptor.toString().trim();
	 	Assertions.assertEquals(actual, "the INSERTED" + System.lineSeparator()
	 							+ "the DELETED\n"
	 							+ System.lineSeparator() + "LEXICON:");
	 }

	 @Test
	 @DisplayName("processFile test with more words, expected true")
	 public void processFileRemovalTestWithMoreWords() {
	 	OddWords oddWords = new OddWords();
	 	oddWords.processFile("processFileRemovalTestWithMoreWords.txt");
	 	String actual = outputStreamCaptor.toString().trim();
	 	Assertions.assertEquals(actual, "the INSERTED" + System.lineSeparator()
	 							+ "the DELETED\n"
	 							+ "quick INSERTED"
	 							+ System.lineSeparator() +"quick DELETED\n"
	 							+ "brown INSERTED" + System.lineSeparator()
	 							+ "brown DELETED\n" + System.lineSeparator()
	 							+ "LEXICON:");
	 }
}