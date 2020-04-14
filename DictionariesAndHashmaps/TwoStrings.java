import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        
        String result = "NO";     
        String[] sa1 = s1.split("(?!^)");
        String[] sa2 = s2.split("(?!^)");

        // 중복 되는 원소 제거를 위해 Set 사용
        Set set1 = new HashSet();
        Set set2 = new HashSet();

        for(int i = 0; i < sa1.length; i++) {
            set1.add(sa1[i]);
        }

        for(int j = 0; j < sa2.length; j++) {
            set2.add(sa2[j]);
        }
        
        // Collections - Set - reatinAll() : 교집합
        // set1과 set2의 교집합이 되는 원소만 보유한다
        set1.retainAll(set2);

        if(set1.size() > 0) {
            result = "YES";
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
