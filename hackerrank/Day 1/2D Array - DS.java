import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.

    static int hourglass(int r_start,int c_start,int arr[][])
    {
        int r_end=r_start+2;
        int c_end=c_start+2;

        int sum1=0,sum2=0;
        for(int i=c_start;i<=c_end;i++)
        {
            sum1+=arr[r_start][i];
            sum2+=arr[r_end][i];
        }
        return (sum1+sum2+arr[(r_start+r_end)/2][(c_start+c_end)/2]);
    }


    static int hourglassSum(int[][] arr) {

        int nr=arr.length;
        int nc=arr[0].length;

        int i,j,max=Integer.MIN_VALUE;

        for(i=0;i<nr-2;i++)
        {
            for(j=0;j<nc-2;j++)
            {
                int hourglassValue=hourglass(i,j,arr);
                if(max<hourglassValue)
                    max=hourglassValue;
            }
        }
        return max;
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
