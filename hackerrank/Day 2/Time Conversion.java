import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

        int h=Integer.parseInt(s.substring(0,2)   );
        int m=Integer.parseInt(s.substring(3,5));
        int sec=Integer.parseInt(s.substring(6,8));
        String type=s.substring(8);

        String res="";

        if(type.equals("AM"))
        {
            if(h==12)
                {
                    
                    res="00"+s.substring(2,8);
                }
            else
                {
                    res=s.substring(0,8);
                }
        }
        else
        {
            if(h==12)
            {
                res=s.substring(0,8);
            }
            else
            {
                h+=12;
                res=h+s.substring(2,8);
            }

        }

            
        return res;
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
