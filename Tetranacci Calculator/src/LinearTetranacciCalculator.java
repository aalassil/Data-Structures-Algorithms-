// ID: 40172296
// Name: Adam Al Assil

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LinearTetranacciCalculator {
    public static void main(String[] args) {
        double linearTetranacci = 0;
        int n = 10;
        double executionTime = 0;
        for(int i = 0; i <= n; i++) {
            double startTime = System.nanoTime();
            linearTetranacci = LinearTetranacciRecursion(i, 0, 0, 0, 1);
            double endTime = System.nanoTime();
            executionTime = (endTime - startTime);

            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("TetraOut(L).txt"))) {
                writer.printf("Linear Tetranacci(%d): %.0f, Time - %f nanoseconds.%n", n, linearTetranacci, executionTime);
            } catch (IOException e) {
                e.printStackTrace();
                }
    }
    /**
     * This method calculates the nth Tetranacci number using a linear recurrence relation.
     * @param n - the index of the Tetranacci number to calculate
     * @param t1 - the first term in the Tetranacci sequence
     * @param t2 - the second term in the Tetranacci sequence
     * @param t3 - the third term in the Tetranacci sequence
     * @param t4 - the fourth term in the Tetranacci sequence
     * @return the nth Tetranacci number as a double.
     */
    public static double LinearTetranacciRecursion(int n, double t1, double t2, double t3, double t4) {
        if(n < 3) return 0;
        if(n == 3) return t4;
        return LinearTetranacciRecursion(n - 1, t2, t3, t4, t1 + t2 + t3 + t4);
    }
}
