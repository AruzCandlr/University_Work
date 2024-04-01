package fileAndStr;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class dabaduu{
	public dabaduu() {}
	public static void UseFileInputStream(String input) throws IOException {
		
		FileInputStream  reader = new FileInputStream(input);
		InputStreamReader readerStream = new InputStreamReader(reader,StandardCharsets.UTF_8);
		BufferedReader readerX = new BufferedReader(readerStream);
		String line;
		System.out.println(readerX.readLine()+readerX.readLine());
//		while((line = readerX.readLine()) != null) {
//			
//		}
		
	} 
	public static String UseFileInputStream2(String input) throws IOException{
		
		FileInputStream  reader = new FileInputStream(input);
		InputStreamReader readerStream = new InputStreamReader(reader,StandardCharsets.UTF_8);
		BufferedReader readerX = new BufferedReader(readerStream);
		StringBuilder output = new StringBuilder();
		String line;
		while((line = readerX.readLine()) != null) {
			output.append(line+"\n");
		}
		
		return output.toString();	
		} 
//	public static void UseFile(String input) throws IOException {
//		String x = Files.readString(Path.of(input));
//		System.out.println(x);
//	}
	
	
	
	public static void main(String [] args) throws IOException {
		UseFileInputStream("inputCSV.csv");
		//System.out.println(RuzMethod.csvToStr("inputCSV.csv"));
		//System.out.println(GetLinePerArray(Files.readString(Path.of("inputCSV.csv"))));
		//System.out.println(RuzMethod.csvToArr("inputCSV.csv")[1].get(RuzMethod.mapFromCsv("inputCSV.csv").get("name")));
		
	}
}
