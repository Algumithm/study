import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> list = new ArrayList();
        boolean[] impossible = new boolean[10];
        impossible[0] = true;
        impossible[1] = true;
        
        for(String str : expressions){
            String[] temp = str.split(" ");
            String a = temp[0];
            String op = temp[1];
            String b = temp[2];
            String c = temp[4];
            
            if(c.equals("X")){
                list.add(str);
            }
            
            for(int i = 2; i < 10; i++){
                try{
                    int num_a = Integer.parseInt(a, i);
                    int num_b = Integer.parseInt(b, i);
                    if(!c.equals("X")){
                        int num_c = Integer.parseInt(c, i);
                    
                    int comp_c = op.equals("+") ? num_a + num_b : num_a - num_b;
                    
                    if(num_c != comp_c){
                        impossible[i] = true;
                    }
                    }
                }catch(NumberFormatException e){
                    impossible[i] = true;
                }
            }
        }
        
        for(boolean a : impossible){
            System.out.print(a + " ");
        }
        
        String[] answer = new String[list.size()];
        
        for(int j = 0; j < list.size(); j++){
            String[] temp = list.get(j).split(" ");
            String a = temp[0];
            String op = temp[1];
            String b = temp[2];

            String compare = null;
            boolean isValid = true;
            for(int i = 2; i < 10; i++){
                if(!impossible[i]){
                    try{
                        int num_a = Integer.parseInt(a, i);
                        int num_b = Integer.parseInt(b, i);
                        int num_c = op.equals("+") ? num_a + num_b : num_a - num_b;

                        String ans_c = Integer.toString(num_c, i);
                        if(compare != null)
                        System.out.print("if : " + (!compare.equals(ans_c)));
                        System.out.print("compare : " + compare + ", num_c : " + num_c);
                        if (compare == null) {
                            compare = ans_c;
                        } else if (!compare.equals(ans_c)) {
                            isValid = false;
                            break;
                        }
                        
                    }catch(NumberFormatException e){
                    }   
                }
            }
            System.out.print(isValid);
            if (isValid && compare != null) {
                answer[j] = a + " " + op + " " + b + " = " + compare;
            } else {
                answer[j] = a + " " + op + " " + b + " = " + "?";
            }
        }
        return answer;
    }
}
