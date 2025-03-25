package study0327;

import java.util.Scanner;

public class Main0321_봄버맨 { // 백준 16918 실버1
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int[][] time; // 폭탄이 설치된 시간저장
	static char[][] map;
	static int r,c,n;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		n=sc.nextInt();
		
		map=new char[r][c];
		time=new int[r][c];
		
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=str.charAt(j);
				
				if(map[i][j]=='O')
					time[i][j]=3;
			}
		}
			
		int time=1; // 1초 아무것도안해서 pass
		while(time<n) {
			//3
			time++;
			bomb(time);
			
			//4
			time++;
			boom(time);
			if(time==n) break;
		}
		
		//결과
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]+"");
			}
			System.out.println();
		}
	}
	
	// 봄버맨
	static void bomb(int t) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='.') {
					map[i][j]='O';
					
					time[i][j]=t+3; // 3초되에 time[i][j]이 되면 멈추게하려고 +3
				}
			}
		}
	}
	
	// 폭탄터트리기
	static void boom(int t) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(time[i][j]==t) {
					map[i][j]='.'; 
					
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						if(nx<0||ny<0||nx>=r||ny>=c)
							continue;
						
						map[nx][ny]='.';
					}
				}
			}
		}
	}
	
}
