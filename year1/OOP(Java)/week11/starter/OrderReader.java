import java.io.*;
import java.util.*;

public class OrderReader {
    //TASK1
    public static ArrayList<String> readOrder(String fileName) {
        //CODE HERE
        return new ArrayList<String>();
    }

    //TASK2
    public static double getTotal(ArrayList<String> order) {
        //CODE HERE
        return 0.0;
    }

    //TASK3
    public static double getTax(ArrayList<String> order) {
        //CODE HERE
        return 0.0;
    }

    //TASK4
    public static double getSubtotal(ArrayList<String> order) {
        //CODE HERE
        return 0.0;
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

    //You are allow to modify code in main to handle the exception that may occur.
    public static void main(String[] args) {
            ArrayList<String> order = readOrder("FILE NAME TO READ HERE");
            double total = getTotal(order);
            double tax = getTax(order);
            double subtotal = getSubtotal(order);
            printReceipt(order, total, tax, subtotal);
    }
}
