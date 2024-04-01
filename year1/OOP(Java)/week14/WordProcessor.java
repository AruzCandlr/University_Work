import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


@SuppressWarnings("unused")
public class WordProcessor {

  /**
   * this method will accept a file name as a parameter, read the textual content in a given file, and return these words in a list of strings. 
   */
	public static ArrayList<String> readFile (String file) throws FileNotFoundException {
    ArrayList<String> words = new ArrayList<String>();
		Scanner in = new Scanner(new File(file));
    while(in.hasNext()){
      String word = in.next();
      words.add(word);
    }
		return words;
	}

  /**
   * this method will accept a list of strings and print out all the words separated by commas in one line.  
   */
	public static void printWords(ArrayList<String> words){
    System.out.println(Arrays.toString(words.toArray()));
	}
	
	public static void sort (ArrayList<String>  a) {
    // TODO 1: implement sort method that accepts an array list of string, then sort it in descending order (b comes before a) using one of the sorting algorithms discusses in class. 
		int passCounter = 0;

		//aruSort (basically selection sort but i just get it from the toilet uwu )
		int counter = 0;
		for(int x = 0; x < a.size(); x++) {
			int max = x;
			for(int i = counter; i < a.size(); i++ ) {
				if(a.get(i).compareTo(a.get(max)) >= 0) {
					max = i;
				}
			}
			String temp = a.get(max);
			a.remove(max);
			counter++;
			a.add(0,temp);
			System.out.println("Pass " + (++passCounter) + ": "+a);
		}
		
		
		//Selection sort(copy directly from Teacher Ananta's notion ps
//		for (int i = 0; i < a.size() - 1; i++) {
//       
//            int minIndex = i;
//            for (int j = i + 1; j < a.size(); j++) {
//            											//change this thing to < to inverse it
//                if (a.get(j).compareTo(a.get(minIndex)) > 0) {
//                    minIndex = j;
//                }
//            }
//
//            
//            String temp = a.get(i);
//			a.set(i, a.get(minIndex));
//			a.set(minIndex,temp); 
//			System.out.println("Pass " + (++passCounter) + ": "+a);
//        }
    
		
		//Bubble sort because its the easiest, ikr
//		for(int i=0; i<a.size(); i++){
//			for(int j=1; j<a.size(); j++) {
//														//change this thing to < to inverse it
//					if(	a.get(j).compareTo(a.get(j-1)) > 0) {
//						String temp = a.get(j);
//						a.set(j, a.get(j-1));
//						a.set(j-1,temp); 
//		
//				}
//			}
//			System.out.println("Pass " + (++passCounter) + ": "+a);
//		}
		
		
	}


  public static void removeDuplicate(ArrayList<String>  a){
    // TODO 2: implement removeDuplicate method that accepts a list of string, then remove all duplicates from the list
    // e.g., if the list has "ink sort make ink sort ink", then the list should be changed to "sort make ink".
    // Note that the result list may not have the same ordering as the original one.
    Set<String> s = new HashSet<>(a);
    a.clear();
    a.addAll(s);
    sort(a);
    
  }
}