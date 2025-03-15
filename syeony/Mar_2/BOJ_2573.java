import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int n,m;
    static int[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int separate;
    static int[][] map2;
    static boolean[][] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        separate=0;
        map2=new int[n][m];

        while(checkSeparate()<=1){
            if(checkAllZero()){
                separate=0;
                break;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]!=0){
                        bfs(i,j);
                    }
                }
            }
            update();
            separate+=1;
        }

        System.out.println(separate);

    }

    static void bfs(int x,int y){
        int zero_cnt=0;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(map[nx][ny]==0){
                zero_cnt+=1;
            }
        }

        if(map[x][y]<=zero_cnt){
            map2[x][y]=0;
        }else{
            map2[x][y]=map[x][y]-zero_cnt;
        }
    }

    static void update(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=map2[i][j];
            }
        }
    }

    static boolean checkAllZero(){
        int zero_cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    zero_cnt+=1;
                }
            }
        }
        if(zero_cnt==n*m) return true;
        else return false;
    }

    static int checkSeparate(){
        int cnt=0;
        v=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!=0 && !v[i][j]){
                    bfs2(i,j);
                    cnt+=1;
                }
            }
        }
//        System.out.println(cnt);
        return cnt;
    }

    static void bfs2(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        v[x][y]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int xx=c[0];
            int yy=c[1];

            for(int i=0;i<4;i++){
                int nx=xx+dx[i];
                int ny=yy+dy[i];

                if(map[nx][ny]!=0 && !v[nx][ny]){
                    v[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }

}
