import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//Was solved earlier and put into my MatchStrings repository. The same code can be found there.
//reference: https://stackoverflow.com/questions/22632492/counting-frequency-of-data-using-dictionary
//Florent Bayle

//reference: https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
//gregory
public class Solution {
    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int string_index;
        int queries_index;
        int[] results = new int[queries.length];
        Map<String, Integer> querydictionary = new HashMap<String, Integer>();
        for(queries_index = 0; queries_index<=queries.length-1; queries_index++)
            {
            querydictionary.put(queries[queries_index],0);
            }
       
            for(string_index = 0; string_index <= strings.length-1; string_index++)
                 {
                      if(querydictionary.containsKey(strings[string_index]))
                      {
                          querydictionary.put(strings[string_index], querydictionary.get(strings[string_index])+1);
                      }
                 }
            for(queries_index = 0; queries_index<=queries.length-1; queries_index++)
            {
                if(querydictionary.containsKey(queries[queries_index]))
                {
                    results[queries_index]=querydictionary.get(queries[queries_index]);
                }
            }
        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
