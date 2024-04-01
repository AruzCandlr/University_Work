
public class TreeCalculator {

	// You may create any helper methods if needed
	

	public static int findMax(Node root)
	{	//****YOUR CODE HERE**
		
		if(root != null) {
			if(root.getLeft()!= null && root.getRight()!=null) {
				
				if(findMax(root.getLeft()) > findMax(root.getRight())) {
					return findMax(root.getLeft());
				}
				else{
					return findMax(root.getRight());	
				}
				
			}
			else if(root.getLeft()== null && root.getRight()!=null) {
				
				if(findMax(root.getRight()) > root.id) {
					return findMax(root.getRight());
				}
				else{
					return root.id;	
				}
			}
			else if(root.getLeft()!= null && root.getRight()==null) {
				
				if(findMax(root.getLeft()) > root.id) {
					return findMax(root.getLeft());
				}
				else{
					return root.id;	
				}
			}	
			else {
				return root.id;
			}
		}
			
		
		return -1;
		
		
		//*********************
	}
	
	
	public static int findMin(Node root)
	{	//****YOUR CODE HERE**
		if(root != null) {
			if(root.getLeft()!= null && root.getRight()!=null) {
				
				if( root.id < findMin(root.getLeft())&& root.id < findMin(root.getRight())) {
					return root.id;
				}
				else if(findMin(root.getLeft()) < findMin(root.getRight())) {
					return findMin(root.getLeft());
				}
				else{
					return findMin(root.getRight());	
				}
				
			}
			else if(root.getLeft()== null && root.getRight()!=null) {
				
				if(findMin(root.getRight()) < root.id) {
					return findMin(root.getRight());
				}
				else{
					return findMin(root);	
				}
			}
			else if(root.getLeft()!= null && root.getRight()==null) {
				
				if(findMin(root.getLeft()) < root.id) {
					return findMin(root.getLeft());
				}
				else{
					return findMin(root);	
				}
			}	
			else {
				return root.id;
			}
		}
			
	
		
		return -1;
		
		//*********************
	}
	
	
	
	//************* TASK A BONUS ****************//
	
	 private static double count(Node root) {
		 if (root == null) {
			 return 0;
		 }
		 return 1 + count(root.left) + count(root.right);
	    }
	// You may create any helper methods if needed
	
	
	public static double sumTree(Node root)
	{	
		//****YOUR CODE HERE**
		if (root== null) {
	            return 0;
	       }
		 return root.id+ sumTree(root.left) + sumTree(root.right);
	  
		//*********************
	}
	
	public static double avgTree(Node root)
	{
		//****YOUR CODE HERE**
		if (root == null) {
			 return 0;
		 }
		return sumTree(root)/count(root);
		//*********************
	}
	
	
	
	
	//************* TASK B BONUS ****************//
	// You may create any helper methods if needed
	
	public static boolean isFullBinaryTree(Node root)
	{	
		//****YOUR CODE HERE**
		return false;
		//*********************
		
	}
	
	public static boolean isBinarySearchTree(Node root)
	{
		//****YOUR CODE HERE**
		return false;
		//*********************
		
	}
	
}
