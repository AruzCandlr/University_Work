package mock_final;

// ID:
// Name:
// Section:

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursiveArray {
	
	// DO NOT MODIFY THIS CODE
	/**
	 * This method checks whether the given string matching with the regular expression pattern or not
	 * @param str	
	 * @param regex
	 * @return return true if string matches with the given regex pattern, otherwise return false
	 */
	public static boolean isMatch(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * You have to try to understand this method by yourself...
	 * @param words variable is an array of String
	 * @param regex variable is the regular expression pattern
	 * @return
	 */
	public static int loop(String[] words, String regex) {
		int c = 0;
		for(int i = 0; i < words.length; i++) {
			if(isMatch(words[i], regex)) {
				c++;
			}
		}
		return c;
	}
	// --------------------------------------------------------------------------------------------------------
	
	// TASK:
	// Implement a recursive method that performs the same task as the loop(...) method above
	// You may create a recursive helper method, if needed
	
	public static int recursion(String[] words, String regex) {
		// YOUR CODE GOES HERE
		String[] newWord = null;
		
		int x = 0;
		if(isMatch(words[0],regex)) {
			x = 1;
		}
		
		if(words.length > 1) {
			newWord = new String[words.length-1];
			
			for(int  i = 0 ; i < newWord.length; i++) {
				newWord[i] =words[i+1];
			}
			
			return  x + recursion(newWord,regex);
		}
		
		else {	
			return x;
		}
		
		// ------------------------------------------------------------
	}
	
	

	public static void main(String[] args) {
		ArrayList<String[]> strArray = new ArrayList<String[]>();
		strArray.add(new String[] {"hello!", "how are you"});
		strArray.add(new String[] {"~this", "is", "mock", "exam", "for", "oop", "class!", "cool!"});
		strArray.add(new String[] {"we", "hope", "~you", "can", "complete", "our", "task", "with", "*perfect", "score!"});
		String[] regex = {"\\w*", "[^a-z]\\w*", "[a-z]*!"};
		for(int i = 0; i < regex.length; i++) {
			for(int j = 0; j < strArray.size(); j++) {
				System.out.println("list: " + j + ", regex: " + regex[i] 
						+ ", result [loop:recursion] -> "+ loop(strArray.get(j), regex[i])+ ":"+ recursion(strArray.get(j), regex[i]));
			}
		}
		
	}

}
