package fileAndStr;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static int count ( ArrayList<Object> i ) {
		
		if(i.size()==0 ) {
			return 0;
		}
		
		ArrayList<Object> iClone = (ArrayList<Object>) i.clone();
		
		iClone.remove(0);
		
		System.out.println(i);
		
		return 1 + count(iClone);
	}
	// 1 + (1 + (1 + ....... (0))) == 7
	
	
	
	public static void looping(int n) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void recursive(int n) {
			
		if(n == 0) {
			return;
		}
		
		int c = 0 ;
		while( c < n) {
			System.out.print("X");
			c++;
		}
		System.out.println();
		
		recursive(n-1);
		
	
	}

	
	public static void main(String args[]) {
		
		ArrayList<Object> i = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		
		System.out.println("i size = " + i.size());
		
		System.out.println("recur = " + count(i));
		
	//looping(10);
	//recursive(10);
	}
}
