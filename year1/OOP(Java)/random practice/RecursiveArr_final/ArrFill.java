package RecursiveArr_final;



public class ArrFill{
	/**
	 * This will fill each of the element of the arr ( one dimensional ) with
	 * an Object[] with 'size' length, do this until the input array reaches 'x' dimensions
	 * 
	 * 
	 */
	public ArrFill(){}
	
	public void fillArr( Object[] arr, int size, int x)  {
	//your code here//
		if(x-1 <= 0) {
			
			if(x == 0) {
				throw new IndexOutOfBoundsException("Error");
			}
			return;
		}
		
		else {
			for(int i = 0; i < arr.length; i++ ){
				arr[i] =  new Object[size];
				fillArr((Object[])arr[i],size,x-1);
			}
		}
		
	}	
	
}
	