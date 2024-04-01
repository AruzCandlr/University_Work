package fileAndStr;

public class bitPattern {

	public bitPattern() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	String input = "01011011011001";
	int count = 0;
	
		for(int i = 0; i < input.length(); i++) {
			try {		
				if(input.toCharArray()[i] == '1') {
					if(input.toCharArray()[i+1] == '1') {
						if(input.toCharArray()[i+2] == '0') {
							if(input.toCharArray()[i+3] == '1') {
								count ++;
							}
						}
					}
				}
			}	
			catch(IndexOutOfBoundsException e) {
				break;
			}
		}
	System.out.println(count);
	

	}

}
