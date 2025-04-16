//GPT
import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		int[] arr = new int[n];
		int sum = 0;
		int mm = Integer.MIN_VALUE;
        
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strs[i]);
			sum += arr[i];
			mm = Math.max(mm, arr[i]);
		}
		
		int max = Integer.parseInt(br.readLine());
		
		int left = 0;
    int right = mm;
    int answer = 0;

    while(left <= right) {
	    int mid = (left + right) / 2;

	    int total = 0;
	    for(int i = 0; i < n; i++) {
	        total += Math.min(arr[i], mid);
	   }
        

    if(total <= max) {
        answer = mid;
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
System.out.println(answer);
		
		
		
	}
}
//
