import java.util.*;

public class BJ1 {
	
	public static int[][] arr;
	public static int size;
	public static int[][] visited;
	//public static int houseSize;
	public static ArrayList<Integer> eachHouseSize=new ArrayList<>(); //집마다 크기 list
	public static int houseNum=0; //총집개수 
	public static int count=0;// 
	
	
	public static boolean inRange(int x,int y) {
		return x>=0 && x<size && y>=0 && y<size;
	}
	
	
	
	public static void DFS(int x,int y) {
		int[] dx=new int[] {0,1,0,-1};
		int[] dy=new int[] {1,0,-1,0};
		
		int nx;
		int ny;
		
		for(int i=0;i<4;i++) {
			nx=x+dx[i];
			ny=y+dy[i];
			
			if(inRange(nx, ny) && visited[nx][ny]==0 && arr[nx][ny]==1 ) {
					visited[nx][ny]=1;
					//eachHouseSize.set(houseNum,count++);
					count++;
					DFS(nx,ny);
				
			}
					
		}
			
	}
		

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		size=sc.nextInt();
		//String line = sc.nextLine();
		arr=new int[size][size];
		visited=new int[size][size];
		
		
		//sc.nextInt();
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				//arr[i][j]=sc.nextInt();
				arr[i][j]=sc.nextInt();
				
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(visited[i][j]==0 && arr[i][j]==1) {//방문하지않았으면
//					eachHouseSize.add(0);
//					visited[i][j]=1;
//					DFS(i,j);
//					houseNum++;
//					count=0;
					visited[i][j]=1;
					count=1;
					DFS(i,j);
					eachHouseSize.add(count);
				}
			}
		}
//		for (int i = 0; i < eachHouseSize.size(); i++) {
//            System.out.println(eachHouseSize.get(i));
//        }
		
		System.out.println(eachHouseSize.size());
		
		Collections.sort(eachHouseSize);
        for (int size : eachHouseSize) {
            System.out.println(size);
        }
		sc.close();
		
	}

}
