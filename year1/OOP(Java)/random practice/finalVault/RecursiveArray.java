package finalVault;

import java.util.ArrayList;

class DimensionChecker<E>{
	
	public DimensionChecker(){}
	
	@SuppressWarnings("unchecked")
	public int dimension(E arr) throws IllegalAccessException{
		
		try {
			
			@SuppressWarnings("unused")
			int x = ((E[])arr).length;
		}
		
		catch(Exception e){
			return 0;
		}
	
		if(!arr.getClass().isArray()) {	
			throw new IllegalAccessException("IS NOT ARRAY");
		}	
		else {
			
		}
		
		return 1 + dimension((E)((E[])arr)[0]);
	}
	
}

class RuzFill{
	
	public RuzFill(){}
	
	public void fillArr( Object[] arr, int size,int round ) throws IndexOutOfBoundsException {
		
		if(round-1 <= 0) {
			
			if(round == 0) {
				throw new IndexOutOfBoundsException("Error");
			}
			//return;
		}
		else {
			for(int i = 0; i < arr.length; i++ ){
				arr[i] =  new Object[size];
				fillArr((Object[])arr[i],size,round-1);
			}
		}
			
	}	
	
}
	

class Visualizer{
	
	private Object[] arr;

	private int layer;
	private ArrayList<StringBuilder> lines = new ArrayList<>();
	public Visualizer(Object arr) {
		
		if(!arr.getClass().isArray()) {
			
			System.out.println("NOT ARRAY");
			
		}
		
		else{
			
			this.arr = (Object[])arr;
			
			try {
				layer = new DimensionChecker<Object>().dimension(arr);
			} 
			catch (IllegalAccessException e) { }

			}
		
			int count = layer;
			for(int i = 0; i < layer; i++) {
				StringBuilder x = new StringBuilder("");
				x.append((count--) +":");
				lines.add(x);
			}
		
	}
	
	
	public void printArr(Object[] arr){	
				
		for(int i = 0; i < arr.length; i++) {
			
			try {
				lines.get( new DimensionChecker<Object>().dimension(arr)-1 ).append("0");
			} catch (IllegalAccessException e1) {
				
			}
			if(i+1 == arr.length)
				try {
					lines.get( new DimensionChecker<Object>().dimension(arr)-1 ).append("|");
				} catch (IllegalAccessException e1) {
					
				}
			
			try {
				if(arr[i]!=null && arr[i].getClass().isArray()) {
					printArr((Object[])arr[i]);
				}
			}
			
			catch(Exception e) {
				
			}
			
		}

	}
		
	
	
	
	public void show( ) {
		
		//System.out.println(layer);
		
		printArr(this.arr);
		
		for(int i = lines.size()-1; i>=0;i-- ) {
			System.out.println(lines.get(i).toString());
		}		
		
	}
}
	

public class RecursiveArray {
	
	public static void visualizeTest( ){
		System.out.println("//--------TESTER FOR Visualizer-------//\n");
		Object[] arr = new Object[1]; 
				
		new RuzFill().fillArr(arr,2, 5);
	
		new Visualizer(arr).show();
		System.out.println("\n\n//--------END OF TESTING-------//\n");
		
	}
	
 	public static void RuzFillTest(int a) {
		
		RuzFill fill = new RuzFill();
		Object[] x = new Object[1];
			
		System.out.print("case[0]( increase to "+a+" layer(s): have ");
		try {
			fill.fillArr(x,1,a);
			System.out.print(new DimensionChecker<Object>().dimension(x)+" layers(check with dimension checker)\n");
		} 
		catch (IllegalAccessException e) {
			System.out.println("NOT EVEN IS ARRAY YOU DUMBSHIT");
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("Have 0 layers = cannot increase anything ");
		} 
		
		
	}
 	
	public static void MassFillTest(int x) {
		System.out.println("//--------TESTER FOR ArrFill-------//\n");
		for(int i = 0; i < x ; i ++) {
			RuzFillTest(i);
		}
		System.out.println("\n\n//--------END OF TESTING-------//");
	}
 	
	public static void DimensionCounterTest() {
		
		System.out.println("//--------TESTER FOR DimensionChecker-------//\n");
		
		DimensionChecker<Object> check = new DimensionChecker<Object>();
	
		
		Object[] arr = new Object[5];
		
		String[] disc = {
				("(1D array)"),
				("(array in array case)"),
				("(not array)"),
				("(Integer Array)"),
				("(Arrays in array (10 layers))")
		};
		
		arr[0] = new Object[10];
		
		arr[1] = new Object[10][10];
		
		arr[2] = new Object();
		
		arr[3] = new Integer[][]{{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10}};
		
		arr[4] = new Object[5];
		
		RuzFill fill = new RuzFill();
		try {
			fill.fillArr((Object[]) arr[4],4,10);
		} catch (Exception e1) { }
		
		
		for(int i = 0; i < arr.length; i ++) {
			
			System.out.print("Case["+(i+1)+"]"+ disc[i] +"have: ");
			
			try {			
				System.out.println(check.dimension((Object[]) arr[i])+" dimension(s)\n");
			}
			catch(Exception e){
				System.out.println("NOT ARRAY\n");
			}
			
		}
	System.out.println("\n\n//--------END OF TESTING-------//");
	}

	
	public static void main(String[] args) {
	
	visualizeTest( );
	MassFillTest(10);
	DimensionCounterTest();	
		
	}
		

	
}


