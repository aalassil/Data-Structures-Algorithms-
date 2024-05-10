// ID: 40172296
// Name: Adam Al Assil

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MultipleTetranacciCalculator {
    public static void main(String[] args) {
        double multipleTetranacci = 0;
        int n = 20;
        for (int j =0; j <  n; j++) {
            double executionTime = 0;
            for (int i = 0; i <= n; i++) {
                double startTime = System.nanoTime();
                multipleTetranacci = MultipleTetranacciRecursion(i);
                double endTime = System.nanoTime();
                executionTime = (endTime - startTime);
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("TetraOut(M).txt", ))) {
                writer.printf("Multiple Tetranacci(%d): %.0f, Time - %f nanoseconds.%n", n, multipleTetranacci, executionTime);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * This method calculates the nth Tetranacci number using multiple recurrence relation.
     * @param n - the index of the Tetranacci number to calculate
     * @return the nth Tetranacci number as a double.
     */
    public static double MultipleTetranacciRecursion(int n) {
        if(n < 3) return 0;
        if(n == 3) return 1;
        return MultipleTetranacciRecursion(n - 1) + MultipleTetranacciRecursion(n - 2) +
                MultipleTetranacciRecursion(n - 3) + MultipleTetranacciRecursion(n - 4);
    }
}

