package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
 *  07:05:45PM → 19:05:45
 *  
 *  12AM -> 00
 *  1AM -> 01
 *  2AM -> 02
 *  ...
 *  12PM -> 12
 *  01PM -> 13
 *  ...
 *  11PM -> 23
 *  
 */
public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
	int hours = Integer.parseInt(s.split(":")[0]);
	int minutes = Integer.parseInt(s.split(":")[1]);
	int seconds = Integer.parseInt(s.split(":")[2].replaceAll("[^0-9]", ""));	
	String ampm = s.split(":")[2].replaceAll("[^A-Z]", "");

	// AM/PM 시간을 24시간으로 변환
	hours = hours % 12; 	// 1. hours를 12로 나눈 나머지 구하기
	if("PM".equals(ampm)) hours += 12;	// 2. PM인 경우 hours에 12를 더하기

	StringBuilder sb = new StringBuilder();
	sb.append(String.format("%02d", hours)).append(":").append(String.format("%02d", minutes)).append(":").append(String.format("%02d", seconds));

	System.out.println(sb.toString());
    	return sb.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
