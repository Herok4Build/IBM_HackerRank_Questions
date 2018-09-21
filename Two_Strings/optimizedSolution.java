//https://www.geeksforgeeks.org/check-two-strings-common-substring/
//Optimized solution based on code from Shivam.Pradhan, nitin mittal, Anant Agarwal and Ilkin
//optimized code is noted by citation to reference with twoStrings() function
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class optimizedSolution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int bigstrSize;
        int smallstrSize;
        String bigstr;
        String smallstr;
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
        //https://www.geeksforgeeks.org/check-two-strings-common-substring/
        //based on code from Shivam.Pradhan and Anant Agarwal and Ilkin
        //optimized code based on code from Shivam. Pradhan, nitin mittal, and Anant Agarwal and Ilkin
        boolean string_check[] = new boolean[1000];
        Arrays.fill(string_check, false);
        
        for(int z = 0; z < bigstrSize; z++)
        {
            string_check[bigstr.charAt(z) - 'A'] = true;
        }
        for(int z = 0; z < smallstrSize; z++)
        {
            if(string_check[smallstr.charAt(z) - 'A'] == true)
            {
                return "YES";
            }
        }
        return "NO";
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
