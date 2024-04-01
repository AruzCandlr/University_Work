

// Make this class implement PrintableNode interface

public class Node implements PrintableNode {
	public int id = -1;
	public Node left = null;
	public Node right = null;
	
	public Node(int _id, Node _left, Node _right)
	{	id = _id;
		left = _left;
		right = _right;
	}
	
	public Node(int _id)
	{	id = _id;
		left = null;
		right = null;
	}


	@Override
	public Node getLeft() {
		
		return left;
	}

	@Override
	public Node getRight() {
		
		return right;
	}

	@Override
	public String getText() {
		
		return Integer.toString(id);
	}

}