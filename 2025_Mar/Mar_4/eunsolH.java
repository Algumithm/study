package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq=new ArrayDeque<>();
        int num=Integer.parseInt(br.readLine());

        for(int i=1;i<=num;i++){
            dq.addLast(i);
        }


        if(dq.size()==1){
            System.out.println(dq.peek());
        }else{
            while(true){
                dq.poll();
                if(dq.size()==1){
                    break;
                }
                int first=dq.poll();
                dq.offerLast(first);
                if(dq.size()==1){
                    break;
                }

            }

            System.out.println(dq.poll());

        }




    }
}
