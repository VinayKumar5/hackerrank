import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {

       double medians[]=new double[a.length];
        PriorityQueue<Integer> lower=new PriorityQueue<Integer>(Collections.reverseOrder()); //maxheap
        PriorityQueue<Integer> higher=new PriorityQueue<Integer>(); //minheap
        
        for(int i=0;i<a.length;i++)
        {
            if(lower.size()==0)
            {
                lower.add(a[i]);
            }
            else if(a[i]<lower.peek())
            {
                lower.add(a[i]);
            }
            else if(a[i]>lower.peek())
            {
                higher.add(a[i]);
            }
            
            
            if(Math.abs(lower.size()-higher.size())>=2)
            {
                if(lower.size()>higher.size())
                {
                    higher.add(lower.poll());
                }
                else
                {
                    lower.add(higher.poll());
                }
            }
            
            
            if(lower.size()>higher.size())
            {
                medians[i]=lower.peek();
            }
            else if(higher.size()>lower.size())
            {
                medians[i]=higher.peek();
            }
            else
            {
                medians[i]=((double)lower.peek()+(double)higher.peek())/2;
            }
            
        }
        return medians;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
