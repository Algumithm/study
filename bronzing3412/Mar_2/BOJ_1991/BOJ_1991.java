import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static int[][] dp;
    static class node {
    	node left;
    	node right;
    	char value;
    	
    	node(char c) {
    		value = c;
    	}
    }
    
    public static void main(String[] args) throws Exception {
    	
    	int N = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
		char a = st.nextToken().charAt(0);
		char b = st.nextToken().charAt(0);
		char c = st.nextToken().charAt(0);
		node root = new node(a);
		if(b != '.')
			root.left = new node(b);
		if(c != '.')
			root.right = new node(c);
		
    	for(int i = 1; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = st.nextToken().charAt(0);
    		b = st.nextToken().charAt(0);
    		c = st.nextToken().charAt(0);
    		if(a != '.') {
    			find(root, a, b, c);
    		}
    	}
    	
    	pre(root);
    	bw.write("\n");
    	in(root);
    	bw.write("\n");
    	post(root);
    	bw.write("\n");
    	bw.flush();
    }
    
    static void find(node cur, char v, char l, char r) {
    	if(cur == null) return;
    	if(cur.value == v) {
    		if(l != '.')
    			cur.left = new node(l);
    		if(r != '.')
    			cur.right = new node(r);
    	} else {
    		find(cur.left, v, l, r);
    		find(cur.right, v, l, r);
    	}
    }
    
    static void pre(node cur) throws Exception{
    	if(cur != null) {
    		bw.write(cur.value);
    		if(cur.left != null) pre(cur.left);
    		if(cur.right != null) pre(cur.right);
    	}
    }
    static void in(node cur) throws Exception{
    	if(cur != null) {
    		if(cur.left != null) in(cur.left);
	    	bw.write(cur.value);
	    	if(cur.right != null) in(cur.right);
    	}
    }
    static void post(node cur) throws Exception{
    	if(cur != null) {
    		if(cur.left != null) post(cur.left);
    		if(cur.right != null) post(cur.right);
	    	bw.write(cur.value);
    	}
    }
}
