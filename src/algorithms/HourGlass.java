package algorithms;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HourGlass {

    static int R = 6;
    static int C = 6;
    static int hourglassSum(int[][] arr) {
        if (R < 3 || C < 3)
            return -1;


        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++)
        {
            for (int j = 0; j < C - 2; j++)
            {

                int sum = (arr[i][j] + arr[i][j + 1] +
                        arr[i][j + 2]) + (arr[i + 1][j + 1]) +
                        (arr[i + 2][j] + arr[i + 2][j + 1] +
                                arr[i + 2][j + 2]);


                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;

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