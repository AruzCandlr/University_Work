package finalVault;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Classifier {

	
	public static void main(String[]args) {
		
		//create 26 elements int array (default null value of int is 0)
		int[] letterCounter = new int[26];
		
	
		Scanner in = new Scanner(System.in);
		
		String target = in.nextLine();
		
		in.close();
		
		for(Character i : target.toCharArray()) {
			
			if(Character.isAlphabetic(i)) {
				letterCounter[Character.getNumericValue(i)-10]++;
			}
			
		}
		
		HashMap<Character, Integer> LetterSet = new HashMap<>(); 
	
		for(char i = 'a'; i <= 'z'; i++) {	//this hashmap will map
		
			int counter = Character.getNumericValue(i)-10;
			LetterSet.put(i,letterCounter[counter]);
		}
		
		System.out.println("Letter in string counter (ignore case)");
		
		System.out.println("Target String: "+ target);
		
		
		String hashed = LetterSet.toString()
				.replaceAll("[a-z]=0","")
				.replaceAll(",","")
				.replaceAll("\\s+", "")
				.replace("{", "")
				.replace("}", "")
				;
		
		System.out.println("printed from hashmap: "+ hashed);
		
		int count = 0;
		for(int i : LetterSet.values()) {
			if(i != 0) {
				count++;
			}
		}
		
		StringBuilder regexBuilder = new StringBuilder("");
		
		String extractor = "([a-z]=\\d+)";
		while(count > 0) {
			regexBuilder.append(extractor);
			count--;
		}
		
		System.out.println(extractor);
		System.out.println(regexBuilder.toString());
		Matcher regEX = Pattern.compile(regexBuilder.toString()).matcher(hashed);
		
		regEX.find();
		
		for(int i = 0; i <regEX.groupCount(); i++) {
			System.out.println(regEX.group(i+1));
		}
		
		
		
		
		
		
	}
}
