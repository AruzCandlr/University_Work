package fileAndStr;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuzFunction {
	public RuzFunction() {
		
	}
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
	
	
	protected static ArrayList<String> GetLinePerArray (String input){
		StringTokenizer tok = new StringTokenizer(input,"\n");
    	ArrayList<String> command = new ArrayList<String>();
    	while(tok.hasMoreTokens()) {
    		command.add(tok.nextToken().replace("\n","").replace("\r",""));
    	}
		return command;
	}
	

	@SuppressWarnings("unchecked")
	protected static ArrayList<Object>[] csvToArr(String input) throws IOException, IndexOutOfBoundsException {
		
		ArrayList<String> file = GetLinePerArray(Files.readString(Path.of(input)));
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
					output[i].add("error dummy 1");
				}
			}
			
				
		}
		
		
		return output;
	}
	
	protected static HashMap<String,Integer> mapFromCsv (String input) throws IOException{
		
		ArrayList<String> file = GetLinePerArray(Files.readString(Path.of(input)));
		ArrayList<String> key = new ArrayList<>();
		StringTokenizer line = new StringTokenizer(file.get(0), ",");
		while(line.hasMoreTokens()) {
			key.add(line.nextToken());
		}
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String x : key) {
			map.put(x, key.indexOf(x));
		}
		return map;
		
	}

	//to get something from csv: csvArr[i].get(mapFromCsv.get(-column name-))

}
