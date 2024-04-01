package RecursiveArr_final;



public class RecursiveArray {
	
	public static void visualizeTest( ){
		Object[] arr = new Object[1]; 
				
		new ArrFill().fillArr(arr,2, 5);
	
		new Visualizer(arr).show();
		
	}
	
 	public static void FillTest(int a) {
		
		ArrFill fill = new ArrFill();
		Object[] x = new Object[1];
			
		System.out.print("case[0]( increase to "+a+" layer(s): have ");
		try {
			fill.fillArr(x,1,a);
			System.out.print(new DimensionChecker().dimension(x)+" layers(check with dimension checker)\n");
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("Have 0 layers = cannot increase anything ");
		} 
		
		
	}
 	
	public static void MassFillTest(int x) {
		System.out.println("//--------TESTER FOR DimensionChecker-------//\n");
		for(int i = 0; i < x ; i ++) {
			FillTest(i);
		}
		System.out.println("\n\n//--------END OF TESTING-------//");
	}
 	
	public static void DimensionCounterTest() {
		
		
		
		DimensionChecker check = new DimensionChecker();
	
		
		Object[] arr = new Object[5];
		
		String[] disc = {
				("(1D array)"),
				("(array in array case)"),
				("(not array)"),
				("(Integer Array)"),
				("(Arrays in array)")
		};
		
		arr[0] = new Object[10];
		
		arr[1] = new Object[10][10];
		
		arr[2] = new Object();
		
		arr[3] = new Integer[][]{{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10}};
		
		arr[4] = new Object[5];
		
		ArrFill fill = new ArrFill();
		try {
			fill.fillArr((Object[]) arr[4],2,10);
		} catch (Exception e1) { }
		
		
		for(int i = 0; i < arr.length; i ++) {
			System.out.print("Case["+(i+1)+"]"+ disc[i] +"have: "+
			check.dimension( arr[i])+" dimension(s)\n");
		}
	
	}

	
	public static void main(String[] args) {
	
			DimensionCounterTest();
				
				MassFillTest(10);
			
					visualizeTest();
		
	}
		
		
	
				
			
				
		
		
	
}


