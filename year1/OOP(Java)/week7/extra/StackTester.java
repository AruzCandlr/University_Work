package noPoint;

import java.util.Arrays;

public class StackTester {
	
	@SuppressWarnings("removal")
	public static void testCharacter()
	{
		char[] cs = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
		Stack<Character> myStack = new Stack<Character>(5);
		for(char c: cs)
		{	StringBuilder str = new StringBuilder();
			if(myStack.push(new Character(c)) == true)
			{
				str.append("Pushing ");
			}
			else
			{
				str.append("Stack Full:"+Arrays.toString(myStack.toArray())+" The top element is "+myStack.peek().toString()+". Cannot push ");
			}
			str.append(c+"\n"+myStack.toString());
			System.out.println(str.toString());
		}
		
		
		for(int i = 0; i < cs.length; i++)
		{	StringBuilder str = new StringBuilder();
			Character c = null;
			if((c = myStack.pop()) != null)
			{
				str.append("Popping "+c.toString());
			}
			else
			{
				str.append("Stack empty!");
			}
			str.append("\n"+myStack.toString());
			System.out.println(str.toString());
		}
	}
	
	public static void testString()
	{
		String[] ss = new String[]{"Think?", "You", "Don't", "Cool", "is", "Java", "Oops!"};
		Stack<String> myStack = new Stack<String>();
		for(String s: ss)
		{	StringBuilder str = new StringBuilder();
			if(myStack.push(s))
			{
				str.append("Pushing ");
			}
			else
			{
				str.append("Stack Full. The top element is "+myStack.peek().toString()+". Cannot push ");
			
			}
			str.append(s+"\n"+myStack.toString());
			System.out.println(str.toString());
		}
		
		for(int i = 0; i < ss.length+1; i++)
		{	StringBuilder str = new StringBuilder();
			String s = null;
			if((s = myStack.pop()) != null)
			{
				str.append("Popping "+s);
			}
			else
			{
				str.append("Stack empty!");
			}
			str.append("\n"+myStack.toString());
			System.out.println(str.toString());
		}
	}
	
	
	public static void main(String[] args)
	{
		testCharacter();
		
		System.out.println("--------------------------------");
		
		testString();
	
		
	}
}
