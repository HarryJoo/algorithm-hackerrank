import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        String[] sArray = s.split("(?<!^)");
        long letterACount = 0;
        long repeatedSCountBy = n / sArray.length;
        long repeatedSCountPlus = 0;

        // a의 반복되는 수 찾기
        for(int i = 0; i < sArray.length; i++) {
            if("a".equals(sArray[i])) {    
                letterACount++;
                if(i <= (n % sArray.length) - 1) {
                    repeatedSCountPlus++;
                }
            }
        }
        
        letterACount *= repeatedSCountBy;
        letterACount += repeatedSCountPlus;
        
        return letterACount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
