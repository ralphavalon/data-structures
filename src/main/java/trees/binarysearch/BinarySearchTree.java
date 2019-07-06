package trees.binarysearch;

import lombok.Getter;

@Getter
public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree(int value) {
		this.root = new Node(value);
	}
	
	public void insert(int value) {
		root = insert(root, value);
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
	
	public void delete(int value) {
		root = delete(root, value);
	}
	
	private Node delete(Node node, int value) {
		if(node == null) {
			return node;
		}

		if(value < node.getValue()) {
			node.setLeft(delete(node.getLeft(), value));
		} else if(value > node.getValue()) {
			node.setRight(delete(node.getRight(), value));
		} else {
			if(node.getLeft() == null) {
				return node.getRight();
			} else if(node.getRight() == null) {
				return node.getLeft();
			}

			Node minimumValueFromRightSubtree = getMinimumValue(node.getRight());

			node.setValue(minimumValueFromRightSubtree.getValue());

			node.setRight(delete(node.getRight(), minimumValueFromRightSubtree.getValue()));
		}
		return node;
		
	}
	
	public int getMinimumValue() {
		return getMinimumValue(root).getValue();
	}
	
	private Node getMinimumValue(Node current) {
		while(current.getLeft() != null) {
			current = current.getLeft();
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
