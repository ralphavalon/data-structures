package trees.binarysearch;

import lombok.Getter;

@Getter
public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree(int value) {
		this.root = new Node(value);
	}
	
	public void insert(int value) {
		insert(root, value);
	}
	
	private Node insert(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}

		if(value < current.getValue()) {
			current.setLeft(insert(current.getLeft(), value));
		} else if(value > current.getValue()) {
			current.setRight(insert(current.getRight(), value));
		}

		return current;
	}
	
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if(node == null) {
			return;
		}

		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if(node == null) {
			return;
		}

		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}
	
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if(node == null) {
			return;
		}

		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}

}
