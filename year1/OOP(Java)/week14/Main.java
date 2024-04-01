import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // Testing sort method
    ArrayList<String> test = new ArrayList<String>();
    test.add("ink");
    test.add("data");
    test.add("ink");
    test.add("data");
    test.add("test");
    test.add("run");
    test.add("world");
    test.add("tech");
    test.add("mango");
    System.out.println("Original List: ");
    WordProcessor.printWords(test);
    System.out.println("-------------------------------------\n");
    
    WordProcessor.sort(test);
    System.out.println("\nSorted List: ");
    WordProcessor.printWords(test);
    System.out.println("-------------------------------------\n");

  //  Testing removeDuplicate
    test.add("mango");
    test.add("rice");
    System.out.println("Original List: ");
    WordProcessor.printWords(test);
    WordProcessor.removeDuplicate(test);
    System.out.println("\nNo Duplicate List: ");
    WordProcessor.printWords(test);
    System.out.println("-------------------------------------\n");

    // Full Testing
    try{
      ArrayList<String> words = WordProcessor.readFile("book.txt");
      System.out.println("\n\nOriginal List: ");
      WordProcessor.printWords(words);
      System.out.println("-------------------------------------\n");

      WordProcessor.sort(words);
      System.out.println("\nSorted List: ");
      WordProcessor.printWords(words);
      System.out.println("-------------------------------------\n");

      WordProcessor.removeDuplicate(words);
      System.out.println("\nNo Duplicate List: ");
      WordProcessor.printWords(words);
      System.out.println("-------------------------------------\n");

    } catch(Exception e){
      e.printStackTrace();
    }
    
  }
  
}