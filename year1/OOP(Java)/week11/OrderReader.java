import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OrderReader {
    //TASK1
    public static ArrayList<String> readOrder(String fileName) {
        //CODE HERE
    	String target = "not initialized";
    	try {
			target = Files.readString(Path.of(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	StringTokenizer reader = new StringTokenizer(target,"\n");
    	ArrayList<String> returner = new ArrayList<String>();
    	while(reader.hasMoreTokens()) {
    		returner.add(reader.nextToken().replace("\n", "").replace("\r", ""));
    	}
    	
   
        return returner;
    }

    //TASK2
    public static double getTotal(ArrayList<String> order) {
    	
    	ArrayList<String> clone = new ArrayList<>(order);
    	while(clone.contains("[order]")) {
     		clone.remove(0);
     	}
    	double total = 0;
    	for(String x : clone) {
	    	StringTokenizer xtractor = new StringTokenizer(x.replaceAll("[A-Za-z]", ""),"*");
	    	total+= Double.parseDouble(xtractor.nextToken())*Double.parseDouble(xtractor.nextToken());
    	}
    	
        return total;
    }

    //TASK3
    public static double getTax(ArrayList<String> order) {
       
        return getTotal(order)*7.0/100.0;
    }

    //TASK4
    public static double getSubtotal(ArrayList<String> order) {
        //CODE HERE
        return getTotal(order) - getTax(order);
    }

    //CHALLENGES
    public static void printReceipt(ArrayList<String> order, double total, double tax, double subtotal) {
        for (int i = 0; i < order.size(); i++) {
            String line = order.get(i);
            if (i == 0 || i == 1 || i == order.size() - 1) {
                System.out.println(line);
            } else {
                System.out.println(line.replaceAll("\\d+\\.\\s+", ""));
            }
        }
        System.out.printf("\n%-20s $%.2f\n", "Total:", total);
        System.out.printf("%-20s $%.2f\n", "Tax:", tax);
        System.out.printf("%-20s $%.2f\n", "Subtotal:", subtotal);
    }

    public static void printReceipt(ArrayList<String> order, String filepath) throws IOException {
    	
    	File output = new File(filepath);
		FileWriter jotter = new FileWriter(output);

        for (int i = 0; i < order.size(); i++) {
            String line = order.get(i);
            if (i == 0 || i == 1 || i == order.size() - 1) {
                jotter.write(line+"\n");
            } else {
            	jotter.write(line.replaceAll("\\d+\\.\\s+", "")+"\n");
            }
        }
        jotter.write(String.format("\n%-20s $%.2f\n", "Total:", getTotal(order)));
        jotter.write(String.format("%-20s $%.2f\n", "Tax:", getTax(order)));
        jotter.write(String.format("%-20s $%.2f\n", "Subtotal:", getSubtotal(order)));
        
        jotter.close();
    }
    

    //You are allow to modify code in main to handle the exception that may occur.
    public static void main(String[] args) throws IOException {
            ArrayList<String> order = readOrder("C:\\Users\\arust\\eclipse-workspace\\week11\\input\\order1.txt");
//            double total = getTotal(order);
//            double tax = getTax(order);
//            double subtotal = getSubtotal(order);
//            printReceipt(order, total, tax, subtotal);
            printReceipt(order, "C:\\Users\\arust\\eclipse-workspace\\week11\\output\\reciept1.txt");
            System.out.print(Files.readString(Path.of("C:\\Users\\arust\\eclipse-workspace\\week11\\output\\reciept1.txt")));
    }
}
