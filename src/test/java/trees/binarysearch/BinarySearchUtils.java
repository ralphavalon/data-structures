package trees.binarysearch;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import lombok.AllArgsConstructor;

public class BinarySearchUtils {

	@AllArgsConstructor
	static class Result {
		private BinarySearchTree tree;
		private String expectedPreOrder;
		private String expectedInOrder;
		private String expectedPostOrder;
		private String expectedPreOrderAfterDelete;
	}
	
	private static Stream<Result> results() {
		return Stream.of(
				new Result(
						createTree(50),
						"50 ",
						"50 ",
						"50 ",
						""),
				new Result(
						createTree(50, 30),
						"50 30 ",
						"30 50 ",
						"30 50 ",
						"30 "),
				new Result(
						createTree(50, 90),
						"50 90 ",
						"50 90 ",
						"90 50 ",
						"90 "),
				new Result(
						createTree(50, 30, 90),
						"50 30 90 ",
						"30 50 90 ",
						"30 90 50 ",
						"90 30 "),
				new Result(
						createTree(7, 4, 10, 1, 6, 50),
						"7 4 1 6 10 50 ",
						"1 4 6 7 10 50 ",
						"1 6 4 50 10 7 ",
						"7 4 1 6 10 "),
				new Result(
						createTree(10, 5, 50, 2, 7, 6, 9),
						"10 5 2 7 6 9 50 ",
						"2 5 6 7 9 10 50 ",
						"2 6 9 7 5 50 10 ",
						"10 5 2 7 6 9 "),
				new Result(
						createTree(25, 15, 50, 10, 35, 22, 70, 12, 4, 18, 24, 31, 44, 90, 66),
						"25 15 10 4 12 22 18 24 50 35 31 44 70 66 90 ",
						"4 10 12 15 18 22 24 25 31 35 44 50 66 70 90 ",
						"4 12 10 18 24 22 15 31 44 35 66 90 70 50 25 ",
						"25 15 10 4 12 22 18 24 66 35 31 44 70 90 ")
			);
	}

	private static BinarySearchTree createTree(int... values) {
		int rootValue = values[0];
		BinarySearchTree bst = new BinarySearchTree(rootValue);
		for (int i = 1; i < values.length; i++) {
			bst.insert(values[i]);
		}
		return bst;
	}

	public static Stream<Arguments> preOrderTrees() {
		return results().map(result -> {
			return Arguments.of(result.tree, result.expectedPreOrder);
		});
    }
	
	public static Stream<Arguments> inOrderTrees() {
		return results().map(result -> {
			return Arguments.of(result.tree, result.expectedInOrder);
		});
    }
	
	public static Stream<Arguments> deleteNodes() {
		return results().map(result -> {
			return Arguments.of(result.tree, result.expectedPreOrderAfterDelete);
		});
    }
	
	public static Stream<Arguments> postOrderTrees() {
		return results().map(result -> {
			return Arguments.of(result.tree, result.expectedPostOrder);
		});
    }

}
