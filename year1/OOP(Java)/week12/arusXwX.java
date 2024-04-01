
// File: ZoomStockFileValidator.java
// Description: validate the zoom stock price csv and (optionally)
//return statistic stock data in the interval of time given
// Lab: 12
// Task: 1

// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * my own configged method for accessing csv file in form of string and ArrayList<Object>[]
 */
@SuppressWarnings("unused")
class RuzFunctionX {
	public RuzFunctionX() {}
	
	/**
	 * enter filepath as an input to get the csv file as a pile of text
	 
	 * @param input
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	protected static String csvToStr(String input) throws IOException,FileNotFoundException{
			
		FileInputStream  reader = new FileInputStream(input);
		InputStreamReader readerStream = new InputStreamReader(reader,StandardCharsets.UTF_8);
		try (BufferedReader readerX = new BufferedReader(readerStream)) {
			StringBuilder output = new StringBuilder();
			String line;
			while((line = readerX.readLine()) != null) {
				output.append(line+"\n");
			}
		reader.close();
		return output.toString();
		}	
	} 

	/**
	 * getArrayList of String by extracting strings(1 element per line)
	 * @param input
	 * @return
	 */
	protected static ArrayList<String> GetLinePerArray (String input){
		StringTokenizer tok = new StringTokenizer(input,"\n");
    	ArrayList<String> command = new ArrayList<String>();
    	while(tok.hasMoreTokens()) {
    		command.add(tok.nextToken().replace("\n","").replace("\r",""));
    	}
		return command;
	}

	/**
	 * parse the csv which is in form of ArrayList<String> that store 1 line per element(removed the heading)
	 * if its index 0: at the column "Date": check if it matches the mm/dd/yyyy format and parse it to LocalDate
	 * the others should be stored in double type
	 * the last element in the array, located in Volume column, should be parsed to long
	 * if the element cannot be parsed, stored in the form of string "error"
	 * @param input
	 * @return
	 * @throws IOException
	 * @throws IndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	protected static ArrayList<Object>[] csvToArr(String input) throws IOException, IndexOutOfBoundsException {
		
		ArrayList<String> file = GetLinePerArray(csvToStr(input));
		//remove the column label at index 0
		file.remove(0);
		
		ArrayList<Object>[] output = new ArrayList[file.size()];
		
		
		for(int i = 0; i < file.size(); i++) {
			output[i] = new ArrayList<Object>();
			StringTokenizer line = new StringTokenizer(file.get(i), ",");

			while(line.hasMoreTokens()) {
				
				String target = line.nextToken();
				if(output[i].size() == 6) {
					output[i].add(Long.parseLong(target));
				}
				else if(target.matches("(\\d+).(\\d+)")|| target.matches("\\d+")) {
					output[i].add(Double.parseDouble(target));
				}
				
				else if(target.matches("(\\d{1,2})/(\\d{1,2})/(\\d{4})")) {
					output[i].add(LocalDate.parse(target, DateTimeFormatter.ofPattern("M/d/yyyy")));
				}
				else {
					output[i].add("error");
				}
			}
			
				
		}
		
		
		return output;
	}
	
	//to get something from csv: csvArr[i].get(mapFromCsv.get(-column name-))
}


public class arusXwX {
	
	private static final int INDEX = 7; //tells how many column needed
	
	public arusXwX() {
		
	}
	/**
	 * enter filepath string to the parameter input in order to check if this csv file valid
	 * (I actually have my own way to access the csv file, but the guideline imply that I should use buffered reader)
	 *  citeria for checking
	 *  1. csv isn't empty(todo, check the first line that it ain't equals to null)
	 *  2. check header column if it equal to how much column the csv is
	 *  3. check that other line also have the same amout of element to column's
	 *  4. since the element at index 0 is date, so other elements should be double-parseable
	 * 
	 * @param input
	 * @return true if csv is valid, else return false
	 * @throws IOException
	 */
	public static boolean validate(String input) throws IOException {
		
		FileInputStream  reader = new FileInputStream(input);
		InputStreamReader readerStream = new InputStreamReader(reader,StandardCharsets.UTF_8);
		try (BufferedReader readerX = new BufferedReader(readerStream)) {
			
			String line = readerX.readLine();
			ArrayList<String> header = new ArrayList<>();
			if(line == null) {
				//validation point 1: csv isn't empty
				System.out.println("error: csv is empty");
				return false;
			}
			else {
				StringTokenizer koolkids = new StringTokenizer(line,","); 
				while(koolkids.hasMoreTokens()) {
					header.add(koolkids.nextToken());
				}
			}
			
			
			String[] headers = header.toArray(new String[header.size()]);
			if(headers.length!=INDEX) {
				//validation point 2: header = 7
				System.out.println("error: invalid header(must have 7 header but here we have only "+headers.length+")");
				return false;
			}
			
			
			int counter = 1;
			while((line = readerX.readLine()) != null){
				
				ArrayList<String> subline = new ArrayList<>();
				StringTokenizer koolkids = new StringTokenizer(line,","); 
				while(koolkids.hasMoreTokens()) {
					subline.add(koolkids.nextToken());
				}
				String[] sublines = subline.toArray(new String[subline.size()]);
				if(sublines.length!=headers.length) {
					//validation point 3: other lines have 
					System.out.println("error: amount of element is unequel to the header");
					return false;
				}
				
				
				for(String i : sublines) {
					if(i != sublines[0]) {
						try {
		
							Double.parseDouble(i);
						}
						catch(NumberFormatException e){
							//validation point 4: elements at index 1-6 are double-parseable
							System.out.println("element at index "+subline.indexOf(i)+" which is " +i+" of line "+counter +"cannot be parsed to double");
							return false;
						}
					}
				}
				
				
				counter++;
			}
			
		readerX.close();
		}
		System.out.println("Your csv is validated");
		return true;
	}
	
	
	public static void main(String[]args) throws FileNotFoundException, IOException {
		
	
		String filepath = "zoom_stock_price_all_time.csv";
		
		if(validate(filepath)) {
			
			//here goes the challenge
			
			
			ArrayList<Object>[] data = RuzFunctionX.csvToArr(filepath);//RuzFunction class is present above this public class
		
			Scanner in = new Scanner(System.in);
			
			String datePattern = "(\\d{1,2})/(\\d{1,2})/(\\d{4})";//format dd/mm/yyyy or d/m/yyyy
			String dIn = ""; 
			LocalDate dateIn = null;
			
			do {
				System.out.print("enter start date:");
				dIn =in.next();
				if(!dIn.matches(datePattern)) {
					System.out.println("Date input error, try again");
					continue;
				}
				
				//implement try catch to make sure that input is parsable
				try {
					dateIn = LocalDate.parse(dIn, DateTimeFormatter.ofPattern("M/d/yyyy"));
				}
				catch(DateTimeParseException e) {
					System.out.println("Date input cannot be parsed, try again");
					dIn = "";
				}
				
			}while(!dIn.matches(datePattern));
			
			
			
			String dOut = ""; 
			LocalDate dateOut = null;
			do {
				System.out.print("enter end date:");
				dOut =in.next();
				if(!dOut.matches(datePattern)) {
					System.out.println("Date input error, try again");
					continue;
				}
				try {
					dateOut = LocalDate.parse(dOut, DateTimeFormatter.ofPattern("M/d/yyyy"));
				}
				catch(DateTimeParseException e) {
					System.out.println("Date input cannot be parsed, try again");
					dOut = "";
				}
				
			}while(!dOut.matches(datePattern));
			
			
			
			double hi = (double) data[0].get(2); 
			double low = (double) data[0].get(3); 
			long vol = 0;
			System.out.println("//-----Statistic data from: "+dateIn +" to "+dateOut+"-----//");
			
			boolean isInRangeOfDate = false;
			
			
			for(ArrayList<Object> i : data) {
				LocalDate date = (LocalDate)i.get(0);
				
				if(date.isAfter(dateIn.minusDays(1))&&date.isBefore(dateOut.plusDays(1))) {
					isInRangeOfDate = true;

					if(hi < (double)i.get(2)) {
						hi = (double) i.get(2);
					}
					
					if(low > (double)i.get(3)) {
						low = (double) i.get(3);
					}
					vol += (long) i.get(6);
				}	
				if(date.isAfter(dateOut)) {
					break;
				}
				
			}
			
			if(isInRangeOfDate) {
				System.out.println("Highest stock price: " + hi);
				System.out.println("Lowest stock price " + low);
				System.out.println("total trading volume: " + vol);
			}
			else {
				System.out.println("no data exist in the range of date inputed by user");
			}
				
			
			in.close();
			
		}
		else {
			System.out.println("Fail validating");
		}
			
	}
}
