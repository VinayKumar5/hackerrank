import java.io.*;
import java.util.*;

public class Solution {

    private static  Stack<Integer> s1=new Stack<Integer>();
    private static Stack<Integer> s2=new Stack<Integer>();

    
    static void enqueue(int x)
    {
        s1.push(x);
    }

    static int dequeue()
    {
        if(!s2.empty())
        {
            return s2.pop();
        }

        while(!s1.empty())     
        {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    static int print()
    {
         if(!s2.empty())
        {
            return s2.peek();
        }

        while(!s1.empty())     
        {
            s2.push(s1.pop());
        }
        return s2.peek();

    }


    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int q=sc.nextInt();
        for(int i=0;i<q;i++)
        {
            int type=sc.nextInt();

            if(type==1)
            {
                int x=sc.nextInt();
                enqueue(x);
            }
            else if(type==2)
            {
                dequeue();
            }
            else
            {
                System.out.println(print());
            }
        }


        
    }
}
