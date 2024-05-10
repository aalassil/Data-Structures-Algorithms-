/* Name: Adam Al Assil
   ID: 40172296
 */

import java.util.Arrays;
import java.util.Scanner;

public class FrogA {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            // Reading the input
            int N = scan.nextInt();

            int[] H = new int[N];
            int[] S = new int[N];

            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }
            Arrays.fill(S, -1);

            // Calling the function that solves the problem
            int e = findPath(H.length - 1, H, S);

            // writing the output
            System.out.print(e + " ");
            for (int i = 0; i < N; ++i) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(S[i]);
            }
            System.out.println();
        }
        scan.close();
    }

    /**
     * Finds the minimum energy path for the frog to jump to the end of the stones.
     * It utilizes dynamic programming to store and reuse previously calculated values.
     *
     * @param index The current rock index.
     * @param H     The heights of the rocks.
     * @param S     The array to store the minimum energy at each stone.
     * @return The minimum energy cost to reach the current stone.
     */
    static int findPath(int index, int[] H, int[] S) {
        if (index == 0)
            return 0;
        if (S[index] != -1)
            return S[index];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = findPath(index - 1, H, S) + Math.abs(H[index] - H[index - 1]);
        if (index > 1)
            jumpTwo = findPath(index - 2, H, S) + Math.abs(H[index] - H[index - 2]);

        // Track the jumps made
        int jump = (jumpOne <= jumpTwo) ? 1 : 2;

        S[index] = Math.min(jumpOne, jumpTwo);

        // Print the jump made (skip the initial 0)
        int max =-1;
        if(S.length-1 == index) {
            for(int i=1;i<S.length;i++)
            {
                if(S[i]>max) {
                    max = S[i];
                }
            }
            S[0] = 1;
            for(int i=1;i<S.length;i++)
            {
                if(S[i]%max==0) {
                    S[i] = 1;
                }
                else {
                    S[i] =0;
                }
            }
        }
        return Math.min(jumpOne, jumpTwo);
    }
}



