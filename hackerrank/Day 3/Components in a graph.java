import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {   

    public static void main(String[] args) throws IOException {
                    int[] parent = new int[30001];

                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int a, b;

                while(n-->0){

                    a = sc.nextInt();
                    b = sc.nextInt();

                   // System.out.println(a + " " + b);

                    if(parent[a] == 0) parent[a] = a;
                    if(parent[b] == 0) parent[b] = a;

                    //Disjoin set idea, keep updating the representative element of each set.
                    if(parent[a] != 0 || parent[b] != 0){
                        int low = Math.min(parent[a], parent[b]);
                        int high = Math.max(parent[a], parent[b]);
                        for(int i=0; i<parent.length; i++){
                            if(parent[i] == high)
                                parent[i] = low;
                        }
                    }
                }

                //convert int[] to Integer[] in order to use Collections.frequency(Integer[], int)
                Integer[] newArray = new Integer[parent.length];
                int i = 0;
                for (int value : parent) {
                    newArray[i++] = value;
                }

                List<Integer> ints = Arrays.asList(newArray);
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int item : newArray) {
                    if(item != 0) {
                        int frequency = Collections.frequency(ints, item);
                        min = Math.min(min, frequency);
                        max = Math.max(max, frequency);
                    }
                }

                System.out.println(min + " " + max);
            }
}

