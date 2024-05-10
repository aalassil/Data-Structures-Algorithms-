/* Name: Adam Al Assil
   ID: 40172296
 */

import java.util.*;

public class FrogB {
    // read two integers separated by space and output their product
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int N = scan.nextInt();
            int[] H = new int[N];
            int[] S = new int[N];

            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }

            FrogB F = new FrogB();
            int e = F.findPath(S, H, 0, 0);

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


    /*
    Need to implement your solution in the findPath function as specified in the problem specifications.

    In this file you are allowed to:
    * change the body of the findPath function (i.e. the implementation) the signature of the function.
    * change the signature of the findPath function in any way you want.
    * You are allowed to minimally change the main function - only the line where the function call to findPath is done in order for the program to compile.
    * You can add any variable to the class of any size, but not new methods.
    */
    public int findPath(int[] S, int[] H, int currentRock, int energySum) {
        int N = H.length;

        if(N == 0) return 0; //if the array has no elements, return 0
        else if(N == 1) { //if the array has only one element, set the 0th index to 1, and return 0(no jump was made)
            S[0] = 1;
            return 0;
        } else if(N == 2) { //if the array has two elements, set the 0th and 1st indices to 1, return the energy jump from 0 to 1
            S[0] = S[1] = 1;
            return Math.abs(H[0] - H[1]);
        }

        //use a stack to keep track of the total energy
        Stack<Integer> energyStack = new Stack<>();
        energyStack.push(0);

        //set the first and last rocks to 1
        S[0] = S[N - 1] = 1;

        //handle the base cases
        if(currentRock == N - 1) { //the last rock is reached
            return 0;
        } else if(currentRock == N - 2) { //the second to last rock is reached
            return Math.abs(H[currentRock] - H[currentRock + 1]) + findPath(S, H, currentRock + 1, energySum);
        }

        //calculate the energy required for one-rock and two-rock jumps
        int oneRockHeightDiff = Math.abs(H[currentRock] - H[currentRock + 1]) + findPath(S, H, currentRock + 1, energySum);
        int twoRocksHeightDiff = Math.abs(H[currentRock] - H[currentRock + 2]) + findPath(S, H, currentRock + 2, energySum);

        //determine the next jump, update S accordingly
        S[currentRock] = 1; //applies to both one-rock and two-rock jumps
        if(oneRockHeightDiff < twoRocksHeightDiff) {
            S[currentRock + 1] = 1;
            energyStack.push(oneRockHeightDiff + energySum);
        } else {
            S[currentRock + 1] = 0;
            S[currentRock + 2] = 1;
            energyStack.push(twoRocksHeightDiff + energySum);
        }

        //calculate the total minimal energy stored in the stack
        while(!energyStack.isEmpty()) {
            energySum += energyStack.pop();
        }
        return energySum;
    }
}
// 874426534