import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<String> map;
    static ArrayList<String> arr_pw;
    static ArrayList<String> arr_pw2;
    static ArrayList<String> arr_pw3;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
    	int TC = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc <= TC; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int row = Integer.parseInt(st.nextToken());
    		int col = Integer.parseInt(st.nextToken());
    		map = new ArrayList<String>();
    		arr_pw = new ArrayList<String>();
    		arr_pw2 = new ArrayList<String>();
    		arr_pw3 = new ArrayList<String>();
    		for(int i = 0; i < row; i++) {
    			String s = br.readLine();
    			for(int j = 0; j < col; j++) {
    				if(s.charAt(j) != '0') {
    					if(!map.contains(s))
    						map.add(s);
    					break;
    				}
    			}
    		}
    		
    		for(int i = 0; i < map.size(); i++) {
//    			System.out.println(map.get(i));
//    			System.out.println(change16_2(map.get(i)));
//    			System.out.println();
    			arr_pw.add(change16_2(map.get(i)));
    		}
    		
//    		System.out.println(arr_pw.size());
    		for(int i = 0; i < arr_pw.size(); i++) {
    			String num = arr_pw.get(i);
//    			System.out.println(num);
    			for(int j = num.length()-1; j >= 0; j--) {
    				int length = 0;
    				if(num.charAt(j) == '1') {
//    					System.out.println("???" + j);
    					length = findpw(num, j);
    					if(length > 0) {
    						j -= (56*length)-1;
    						arr_pw2.add(num.substring(j, j+56*length));
//    						System.out.println(num.substring(j, j+56*length));
    					}
    				}
    			}
    		}
    		
    		int ans = 0;
    		for(int i = 0; i < arr_pw2.size(); i++) {
    		    String ss = arr_pw2.get(i);
    		    String s3 = "";
    		    for(int j = 0; j < ss.length(); j = j + ss.length() / 56) {  // Corrected condition
    		        s3 += ss.charAt(j);
    		    }
//    		    System.out.println(s3);
    		    if(!arr_pw3.contains(s3)) {
    		    	arr_pw3.add(s3);
//  	  		    	System.out.println(s3);
//	    		    System.out.println(calc2(s3));
	    		    ans += calc2(s3);
    		    }
    		}
//    		System.out.println(ans);
    		bw.write("#"+tc + " " + ans + "\n");
    		bw.flush();
    	}
        
    }
    
    static int findpw(String pw, int idx) {
//    	System.out.println(pw);
    	String s = "";
    	String s2 = "";
    	int cnt = 1;
    	while (true) {
    	    s = pw.substring(idx - (7 * cnt - 1), idx + 1);
    	    StringBuilder patternRatio = new StringBuilder();

    	    List<Integer> counts = new ArrayList<>();
    	    char prevChar = s.charAt(0);
    	    int count = 1;
    	    
    	    for (int i = 1; i < s.length(); i++) {
    	        if (s.charAt(i) == prevChar) {
    	            count++;
    	        } else {
    	            counts.add(count);
    	            prevChar = s.charAt(i);
    	            count = 1;
    	        }
    	    }
    	    counts.add(count);

    	    int gcdValue = counts.get(0);
    	    for (int num : counts) {
    	        gcdValue = gcd(gcdValue, num);
    	    }

    	    for (int num : counts) {
    	        patternRatio.append(num / gcdValue);
    	    }

//    	    System.out.println("Pattern Ratio: " + patternRatio.toString());

    	    if (check(patternRatio.toString())) {
    	        break;
    	    }
    	    cnt++;
    	}
//    	System.out.println(cnt);
//    	System.out.println();
    	return cnt;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    static String change16_2(String pw) {
    	String s = "";
    	for(int i = 0; i < pw.length(); i++) {
    		char a = pw.charAt(i);
    		if(a == '0') s += "0000";
	    	else if(a == '1') s += "0001";
	    	else if(a == '2') s += "0010";
	    	else if(a == '3') s += "0011";
	    	else if(a == '4') s += "0100";
	    	else if(a == '5') s += "0101";
	    	else if(a == '6') s += "0110";
	    	else if(a == '7') s += "0111";
	    	else if(a == '8') s += "1000";
	    	else if(a == '9') s += "1001";
	    	else if(a == 'A') s += "1010";
	    	else if(a == 'B') s += "1011";
	    	else if(a == 'C') s += "1100";
	    	else if(a == 'D') s += "1101";
	    	else if(a == 'E') s += "1110";
	    	else  s += "1111";
    	}
    	return s;
    }
    
    static int calc2(String pw) {
//    	System.out.println(pw);
        int sum = 0;
        int valid = 0;
        int tri = 3;
        for(int i = 0; i < 56; i += 7) {
//        	System.out.println(i);
        	String s = "";
            for (int j = i; j < i+7; j++) {
                    s += pw.charAt(j);
            }
//            System.out.println(s);
            if (s.equals("0011001")) {
                sum += 1;	
                valid += 1*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            } else if (s.equals("0010011")) {
                sum += 2;
                valid += 2*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0111101")) {
                sum += 3;
                valid += 3*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0100011")) {
                sum += 4;
                valid += 4*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0110001")) {
                sum += 5;
                valid += 5*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0101111")) {
                sum += 6;
                valid += 6*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0111011")) {
                sum += 7;
                valid += 7*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0110111")) {
                sum += 8;
                valid += 8*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            }  else if (s.equals("0001011")) {
                sum += 9;
                valid += 9*tri;
                if(tri == 3) tri = 1;
                else tri = 3;
            } else if (s.equals("0001101")) {
                if(tri == 3) tri = 1;
                else tri = 3;
            }
        }
//        System.out.println(valid + " " + sum);
        if(valid % 10 == 0) return sum;
        else return 0;
    }
    
    static boolean check(String s) {
    	if (s.equals("3211")) {
            return true;
        } else if (s.equals("2221")) {
        	return true;
        }  else if (s.equals("2122")) {
        	return true;
        }  else if (s.equals("1411")) {
        	return true;
        }  else if (s.equals("1132")) {
        	return true;
        }  else if (s.equals("1231")) {
        	return true;
        }  else if (s.equals("1114")) {
        	return true;
        }  else if (s.equals("1312")) {
        	return true;
        }  else if (s.equals("1213")) {
        	return true;
        } else if (s.equals("3112")) {
        	return true;
        }
    	return false;
    }
}
