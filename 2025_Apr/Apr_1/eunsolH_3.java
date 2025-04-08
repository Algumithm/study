package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10026 {
    static char[][] arr;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static boolean[][] visited;
    static int n;

    public static boolean inRange(int x,int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    public static void dfs(int x,int y){


        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(inRange(nx,ny)&&!visited[nx][ny]&&arr[x][y]==arr[nx][ny]){
                visited[nx][ny]=true;
                dfs(nx,ny);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new char[n][n];
        visited=new boolean[n][n];
        int area=0;
        int area2=0;

        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=line.charAt(j);
            }
        }


        //적록색약x 구역찾기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    area++;
                }
            }
        }

        //G를 R로
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='G'){
                    arr[i][j]='R';
                }
            }
        }

        //적록색약 구역찾기
        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    area2++;
                }
            }
        }

        System.out.println(area+" "+area2);





    }
}
