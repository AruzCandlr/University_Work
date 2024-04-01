package RecursiveArr_final;


public class DimensionChecker{
	
	/**
	 * This class will check how many dimension the array is
	 * example if there's int[][] x , If we use dimension(x) it will return 2
	 * this will work with the case that there is an array in array too
	 * 
	 */
	

	public DimensionChecker(){}
	
	
	public int dimension(Object arr){
		//your code here
		
		if(arr == null||!arr.getClass().isArray()) {	
			return 0;
		}
		
		
		return 1 + dimension( ((Object[])arr)[0] );
		
	}
	
}  