import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static ArrayList<person> ps;
    static ArrayList<Integer> stair;
    static boolean[] visit;
    static int cnt_p, N;
    static int min;
    static class person {
    	int idx_x;
    	int idx_y;
    	int dis1;
    	int dis2;
    	person(int x, int y) {
    		idx_x = x;
    		idx_y = y;
    	}
    }
    
    public static void main(String[] args) throws Exception {    
    	int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
        	bw.write("#" + tc + " ");
        	N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ps = new ArrayList<person>();
            
            stair = new ArrayList<Integer>();
            cnt_p = 0;
            min = Integer.MAX_VALUE;
            
            int cnt = 0;
            for(int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < N; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            		if(map[i][j] == 1) {
            			ps.add(new person(i, j));
            		} else if(map[i][j] > 1) {
            			stair.add(map[i][j]);
            		}
            	}
            }
            visit = new boolean[ps.size()];
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		if(map[i][j] > 1) {
            			for(int k = 0; k < ps.size(); k++) {
            				if(ps.get(k).dis1 == 0) ps.get(k).dis1 = Math.abs(ps.get(k).idx_x - i) + Math.abs(ps.get(k).idx_y - j);
            				else ps.get(k).dis2 = Math.abs(ps.get(k).idx_x - i) + Math.abs(ps.get(k).idx_y - j);
            			}
            		}
            	}
            }
            
            comb(0);
            bw.write(min + "\n");
        }
        bw.flush();
    }
    
    static void comb(int cnt) {
    	if (cnt == ps.size()) {
            find();
            return;
        }

        visit[cnt] = true;
        comb(cnt + 1);

        visit[cnt] = false;
        comb(cnt + 1);
    }
    
    static void find() {
    	ArrayList<Integer> stair1 = new ArrayList<Integer>();
		ArrayList<Integer> stair2 = new ArrayList<Integer>();
		ArrayList<Integer> stair1_w = new ArrayList<Integer>();
		ArrayList<Integer> stair2_w = new ArrayList<Integer>();
		ArrayList<Integer> stair1_b = new ArrayList<Integer>();
		ArrayList<Integer> stair2_b = new ArrayList<Integer>();
		int time = 0;
		
		for(int i = 0; i < ps.size(); i++) {
			if(visit[i]) {
				stair1.add(ps.get(i).dis1);
			} else {
				stair2.add(ps.get(i).dis2);
			}
		}
		
    	while(true) {
    		if(stair1.size() == 0 && stair1_w.size() == 0 && stair1_b.size() == 0 && 
    				stair2.size() == 0 && stair2_w.size() == 0 && stair2_b.size() == 0) break;
    		if(time >= min) break;
    		time++;
    		for(int i = 0; i < stair1.size(); i++) {
    			stair1.set(i, stair1.get(i)-1);
    			if(stair1.get(i) <= 0 && stair1_w.size() < 3) {
    				stair1_w.add(2);
    				stair1.remove(i--);
    			}
    		}
    		for(int i = 0; i < stair2.size(); i++) {
    			stair2.set(i, stair2.get(i)-1);
    			if(stair2.get(i) <= 0 && stair2_w.size() < 3) {
    				stair2_w.add(2);
    				stair2.remove(i--);
    			}
    		}
    		for(int i = 0; i < stair1_w.size(); i++) {
    			stair1_w.set(i, stair1_w.get(i)-1);
    			if(stair1_w.get(i) <= 0 && stair1_b.size() < 3) {
    				stair1_b.add(stair.get(0)+1);
    				stair1_w.remove(i--);
    			}
    		}
    		for(int i = 0; i < stair2_w.size(); i++) {
    			stair2_w.set(i, stair2_w.get(i)-1);
    			if(stair2_w.get(i) <= 0 && stair2_b.size() < 3) {
    				stair2_b.add(stair.get(1)+1);
    				stair2_w.remove(i--);
    			}
    		}
    		for(int i = 0; i < stair1_b.size(); i++) {
    			stair1_b.set(i, stair1_b.get(i)-1);
    			if(stair1_b.get(i) <= 0) {
    				stair1_b.remove(i--);
    				for(int j = 0; j < stair1_w.size(); j++) {
    	    			if(stair1_w.get(j) <= 0 && stair1_b.size() < 3) {
    	    				stair1_b.add(stair.get(0)+1);
    	    				stair1_w.remove(j--);
    	    			}
    	    		}
    				for(int j = 0; j < stair1.size(); j++) {
    	    			if(stair1.get(j) <= 0 && stair1_w.size() < 3) {
    	    				stair1_w.add(2);
    	    				stair1.remove(j--);
    	    			}
    	    		}
    			}
    		}
    		for(int i = 0; i < stair2_b.size(); i++) {
    			stair2_b.set(i, stair2_b.get(i)-1);
    			if(stair2_b.get(i) <= 0) {
    				stair2_b.remove(i--);
    				for(int j = 0; j < stair2_w.size(); j++) {
    	    			if(stair2_w.get(j) <= 0 && stair2_b.size() < 3) {
    	    				stair2_b.add(stair.get(1)+1);
    	    				stair2_w.remove(j--);
    	    			}
    	    		}
    				for(int j = 0; j < stair2.size(); j++) {
    	    			if(stair2.get(j) <= 0 && stair2_w.size() < 3) {
    	    				stair2_w.add(2);
    	    				stair2.remove(j--);
    	    			}
    	    		}
    			}
    		}
    	}
    	min = Math.min(min, time);
    }
}
