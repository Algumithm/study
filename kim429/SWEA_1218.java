import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10 ; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String bracket = br.readLine();
            String change_bracket;
             
            int answer = 1;
             
            change_bracket = bracket.replace("{","");
            bracket = bracket.replace("}","");
            if(change_bracket.length() != bracket.length()) {
                answer = 0;
            }
             
            change_bracket = bracket.replace("[","");
            bracket = bracket.replace("]","");
            if(change_bracket.length() != bracket.length()) {
                answer = 0;
            }
             
            change_bracket = bracket.replace("(","");
            bracket = bracket.replace(")","");
            if(change_bracket.length() != bracket.length()) {
                answer = 0;
            }
             
            change_bracket = bracket.replace("<","");
            bracket = bracket.replace(">","");
            if(change_bracket.length() != bracket.length()) {
                answer = 0;
            }
             
             
             
            System.out.println("#"+test_case+" " + answer);
             
        }
         
    }
}
