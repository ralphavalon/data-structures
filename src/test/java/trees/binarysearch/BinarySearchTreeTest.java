package trees.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BinarySearchTreeTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	@Test
	public void shouldHaveRoot() {
		BinarySearchTree bst = new BinarySearchTree(7);

		Node root = bst.getRoot();
		assertEquals(7, root.getValue());
		assertNull(root.getLeft());
		assertNull(root.getRight());
	}

	@Test
	public void shouldInsertNodes() {
		BinarySearchTree bst = new BinarySearchTree(7);
		bst.insert(4);
		bst.insert(10);
		bst.insert(1);
		bst.insert(6);
		bst.insert(35);

		Node root = bst.getRoot();
		assertEquals(7, root.getValue());
		assertEquals(4, root.getLeft().getValue());
		assertEquals(1, root.getLeft().getLeft().getValue());
		assertEquals(6, root.getLeft().getRight().getValue());
		assertEquals(10, root.getRight().getValue());
		assertEquals(35, root.getRight().getRight().getValue());
		
		assertNull(root.getLeft().getLeft().getLeft());
		assertNull(root.getLeft().getLeft().getRight());
		assertNull(root.getLeft().getRight().getLeft());
		assertNull(root.getLeft().getRight().getRight());
		assertNull(root.getRight().getLeft());
		assertNull(root.getRight().getRight().getLeft());
		assertNull(root.getRight().getRight().getRight());
	}
	
	@Test
	public void shouldGetMinimumValue() {
		BinarySearchTree bst = new BinarySearchTree(7);

		assertEquals(7, bst.getMinimumValue());
		
		bst.insert(4);
		bst.insert(6);
		
		assertEquals(4, bst.getMinimumValue());
		
		bst.insert(10);
		bst.insert(1);
		bst.insert(2);
		bst.insert(35);
		
		assertEquals(1, bst.getMinimumValue());
	}

	@ParameterizedTest
	@MethodSource("trees.binarysearch.BinarySearchUtils#preOrderTrees")
	public void shouldPrintPreOrder(BinarySearchTree bst, String expectedPreOrder) {
		bst.preOrder();
		assertEquals(expectedPreOrder, outContent.toString());
	}
	
	@ParameterizedTest
	@MethodSource("trees.binarysearch.BinarySearchUtils#inOrderTrees")
	public void shouldPrintInOrder(BinarySearchTree bst, String expectedInOrder) {
		bst.inOrder();
		assertEquals(expectedInOrder, outContent.toString());
	}
	
	@ParameterizedTest
	@MethodSource("trees.binarysearch.BinarySearchUtils#postOrderTrees")
	public void shouldPrintPostOrder(BinarySearchTree bst, String expectedPostOrder) {
		bst.postOrder();
		assertEquals(expectedPostOrder, outContent.toString());
	}

}
