import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _2DArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = 0; j < arr[i].length - 2; j++) {
                int hourglassSum = 0;
                hourglassSum += arr[i][j];
                hourglassSum += arr[i][j+1];
                hourglassSum += arr[i][j+2];
                hourglassSum += arr[i+1][j+1];
                hourglassSum += arr[i+2][j];
                hourglassSum += arr[i+2][j+1];
                hourglassSum += arr[i+2][j+2];

                if(result < hourglassSum || (i == 0 && j == 0)) {
                    result = hourglassSum;
                }
            }        
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
