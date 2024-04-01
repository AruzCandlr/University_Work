package fileAndStr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public interface RuzMethod {
	

	
	static ArrayList<String> GetLinePerArray (String input){
		StringTokenizer tok = new StringTokenizer(input,"\n");
    	ArrayList<String> command = new ArrayList<String>();
    	while(tok.hasMoreTokens()) {
    		command.add(tok.nextToken().replace("\n","").replace("\r",""));
    	}
		return command;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<String>[] csvToArr(String input) throws IOException, IndexOutOfBoundsException {
		
		ArrayList<String> file = GetLinePerArray(Files.readString(Path.of(input)));
		//remove the column label at index 0
		file.remove(0);
		
		ArrayList<String>[] output = new ArrayList[file.size()];
		
		
		for(int i = 0; i < file.size(); i++) {
			output[i] = new ArrayList<String>();
			StringTokenizer line = new StringTokenizer(file.get(i), ",");

			while(line.hasMoreTokens()) {
				output[i].add(line.nextToken());
			}
			
		}	
		
		return output;
	}
	
	static HashMap<String,Integer> mapFromCsv (String input) throws IOException{
		
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


	

}
