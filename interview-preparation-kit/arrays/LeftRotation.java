import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    /*
    * [1 2 3 4 5] --- 4 left shift ---> [5 1 2 3 4]
    * 0 : 0 - 4 + 5 = 1 % 5 = 1
    * 1 : 1 - 4 + 5 = 2 % 5 = 2
    * 2 : 2 - 4 + 5 = 3 % 5 = 3
    * 3 : 3 - 4 + 5 = 4 % 5 = 4
    * 4 : 4 - 4 + 5 = 5 % 5 = 5
    */
    static int[] rotLeft(int[] a, int d) {
        int[] b = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            int shift = (i - d + a.length) % a.length;  // solution code!!
            b[shift] = a[i];
        }
        return b;
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
