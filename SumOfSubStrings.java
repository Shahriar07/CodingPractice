import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'substrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING n as parameter.
     */

    public static int substrings(String n) {
        long modulo = 1000000007L;
        long intermediateSum = Integer.parseInt(n.substring(0,1));
        long sum = intermediateSum;
        // System.out.println("intermediateSum " + intermediateSum);
        int len  = n.length();
        
        for(int i=1; i<len; i++) {
         int digit = Integer.parseInt(n.substring(i,i+1));
        //  System.out.println("digit " + digit);
         intermediateSum = (intermediateSum * 10 + digit * (i+1)) % modulo;
                //  System.out.println("intermediateSum " + intermediateSum);
         sum = (sum + intermediateSum) % modulo;
        //  System.out.println("Sum " + sum);
        }
        return (int)(sum);

    }

}

public class SumOfSubStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = bufferedReader.readLine();

        int result = Result.substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}