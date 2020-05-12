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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

     public static int gcd(int a,int b)
     {
         if(a==0)
            return b;
        return gcd(b%a,a);
     }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        int ar[]=new int[a.size()]        ;
        int br[]=new int[b.size()];
        Arrays.sort(ar);
        Arrays.sort(br);

        int i=0;
        for(int x:a)
        {
            ar[i]=x;
            i++;            
        }
        i=0;
        for(int x:b)
        {
            br[i]=x;
            i++;
        }

        int lcm=ar[0];
        for(i=1;i<ar.length;i++)
        {
            lcm=(lcm*ar[i])/gcd(lcm,ar[i]);
        }
       

        int gc=br[0];
        for(i=1;i<br.length;i++)
        {
            gc=gcd(gc,br[i]);
        }
         System.out.println("gcd="+gc);
        
        int p=lcm;
        int count=0;
        for(i=2;p<=gc;i++) 
        {
            if(gc%p==0)            
                count++;           
            p=lcm*i;      
        }        
        // for(i=0;i<ar.length;i++)
        //     System.out.println(ar[i]);
        return count;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

