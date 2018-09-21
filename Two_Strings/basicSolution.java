//Two Strings Question from Hackerrank
//Reference:https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
//Basic O(n^2) solution
//Determines if two strings share any common substrings
//Referenced pseudocode at https://www.geeksforgeeks.org/check-two-strings-common-substring/ 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class basicSolution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int bigstrSize;
        int smallstrSize;
        String bigstr;
        String smallstr;
        String result = "";
        if(s1.length() > s2.length())
        {
            bigstrSize = s1.length();
            bigstr = s1;
            smallstrSize = s2.length();
            smallstr = s2;
        }
        else
        {
            bigstrSize = s2.length();
            bigstr = s2;
            smallstrSize = s1.length();
            smallstr = s1;
        }
        boolean commonsubstring = false;
        for(int i = 0; i < bigstrSize; i++)
        {
            for(int j = 0; j<smallstrSize; j++)
            {
                if (bigstr.substring(i,i+1).equals(smallstr.substring(j,j+1)))
                {
                    commonsubstring = true;
                    result = "YES";
                }
            } 
        }
            if(commonsubstring == false)
            {
                result = "NO";
            }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}