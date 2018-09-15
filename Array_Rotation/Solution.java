//Made using a pseudocode method found on https://www.geeksforgeeks.org/array-rotation/ which was, at the time the page was visited, recently whetted by shantanoo

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    int[] temp = new int[d];//Temporary array created
    for(int i = 0; i < d; i++)//Stores elements that have vulnerable positions into a temporary array
    {
        temp[i] = a[i];
    }
    for(int i = 0; i < a.length-d; i++)//Moves the elements in the existing array over
    {
        a[i]= a[d+i];//Stores all values not stored in temp to positions at the front of the array, not ecessarily filling in the entire array
    }
    for(int i = 0; i < d; i++)//inserts values of temp array back into main array
    {
        a[a.length-d+i] = temp[i]; //Counts from the stopping place of the index of the previous for loop
    }
    return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
