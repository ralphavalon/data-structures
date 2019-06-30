package trees.binarysearch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
	
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}

}
