package algo;

import java.util.*;

class Solution0311_최대상금
{
    static char [] arr;
    static int n;
    static String result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		int T = sc.nextInt();
        sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
            arr = s.toCharArray();  
           
            n = sc.nextInt();
            sc.nextLine();
            
            result = ""; 
            back(0, 0);
            System.out.println("#" + test_case + " " + result);
        }
        sc.close();
	}
    
    public static void back(int depth, int count){
        
       if(count == n){
            String current = new String(arr); 
            if (current.compareTo(result) > 0) {  
                result = current;  
            }
           return;
       }
        
       for(int i = depth; i < arr.length; i++){
           for(int j = i + 1; j < arr.length; j++){
               exchange(i, j);
               back(i, count + 1);
               exchange(i, j);
           }
       }
    }
    
    private static void exchange(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

