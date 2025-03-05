package algo;

import java.util.*;
import java.io.*;

public class BOJ2667 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,0};
	static int[][] array;
	static int count;
	static int N;
	static List<Integer> count_array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		count_array = new ArrayList<>();
		
		
		
		for(int i = 0; i < array.length ; i++) {
			String line = br.readLine();
			for(int j = 0; j < array.length; j++) {
				array[i][j] = line.charAt(j) - '0';
			}
		}

		for(int i = 0; i < array.length ; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[i][j] == 1) {
					search(i,j);
				}
			}
		}
		System.out.println(count_array);
	}
	
	static void search(int i, int j) {
		if(array[i][j] == 0) {
			return;
		}
		count = 0;
		if(i == 0 && j == 0) {
			for(int x = 1; x < dx.length-1; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		if(i == 0 && j == N) {
			for(int x = 2; x < dx.length; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		if(i == N && j == 0) {
			for(int x = 0; x < 2; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		if(i == N && j == N) {
			if(array[i+dx[0]][j+dy[0]] == 1) {
				count++;
				search(i+1,j+1);
			}
			if(array[i+dx[3]][j+dy[3]] == 1) {
				count++;
				search(i+1,j+1);
			}
		}
		if(!(i == 0 && j == 0)&&!(i == 0 && j == N)&&i==0) {
			for(int x = 1; x < dx.length; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		if(!(i == 0 && j == N)&&!(i == N && j == N)&&j==N) {
			if(array[i+dx[0]][j+dy[0]] == 1) {
				count++;
				search(i+1,j+1);
			}
			for(int x = 2; x < dx.length; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		if(!(i == N && j == 0)&&!(i == N && j == N)&&i==N) {
			for(int x = 0; x < 2; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
			if(array[i+dx[3]][j+dy[3]] == 1) {
				count++;
				search(i+1,j+1);
			}
		}
		if(!(i == 0 && j == 0)&&!(i == N && j == 0)&&j==0) {
			for(int x = 0; x < dx.length-1; x++) {
				if(array[i+dx[x]][j+dy[x]] == 1) {
					count++;
					search(i+1,j+1);
				}
			}
		}
		for(int x = 0; x < dx.length; x++) {
			if(array[i+dx[x]][j+dy[x]] == 1) {
				count++;
				search(i+1, j+1);
			}
		}
		
		count_array.add(count);
	}
	
}
