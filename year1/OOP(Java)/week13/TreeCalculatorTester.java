// DO NOT MODIFY THIS FILE 
public class TreeCalculatorTester {
	public static Node[] ts = new Node[7];
	
	public static void initTrees()
	{
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(11, null, null), null);
		
		ts[count++] = new Node(1, new Node(6, new Node(9, null, null), new Node(7, null, null)), 
				new Node(4, new Node(11, null, null), new Node(18, null, null)));
		
		ts[count++] = new Node(4, new Node(3, null, null), 
				new Node(10, new Node(12, null, null), new Node(8, null, null)));
		
		ts[count++] = new Node(1, new Node(Integer.MAX_VALUE-1000000000, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(10, new Node(6, new Node(3), new Node(7)), 
				new Node(15, new Node(13), null));
	}
	
	
	public static void testRegular()
	{	System.out.println("-------------- Regular ----------------");
		for(int i = 0; i < ts.length; i++)
		{
			Node root = ts[i];
			TreePrinter.print(root);
			int max = TreeCalculator.findMax(root);
			int min = TreeCalculator.findMin(root);
			System.out.println("Tree["+i+"] Max: "+max+"\tMin: "+min+"\n\n");
			
		}
	}
	
	public static void testBonusA()
	{
		System.out.println("-------------- Task A BONUS ----------------");
		for(int i = 0; i < ts.length; i++)
		{
			Node root = ts[i];
			TreePrinter.print(root);
			double sum = TreeCalculator.sumTree(root);
			double avg = TreeCalculator.avgTree(root);
			System.out.println("Tree["+i+"] Sum: "+sum+"\tAverage: "+avg+"\n\n");
			
		}
	}
	
	public static void testBonusB()
	{
		System.out.println("-------------- Task B BONUS ----------------");
		for(int i = 0; i < ts.length; i++)
		{
			Node root = ts[i];
			TreePrinter.print(root);
			boolean full = TreeCalculator.isFullBinaryTree(root);
			boolean search = TreeCalculator.isBinarySearchTree(root);
			System.out.println("Tree["+i+"] Full: "+full+"\tSearch: "+search+"\n\n");
			
		}
	}
	
	
	
	public static void main(String[] args)
	{
		initTrees();
		testRegular();
		testBonusA();
		testBonusB();
		
	}

}
