코드마다 주석을 달아두는게 더 효과적일것 같아서 일단 주석으로 달아뒀습니다!
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static int n;
    public static int count;
    public static int [] getx = {-1, 1, 0, 0};
    public static int [] gety = {0, 0, -1, 1};
    public static boolean [][] visited;

    public static int [][] a;
    public static int BFS(int i, int j)
    {
        int sum = 0;
        Queue<Game> queue = new LinkedList<>();
        Game game = new Game(i,j);
        queue.add(game);
        visited[i][j] = true;
        while(!queue.isEmpty())
        {
            sum++;
            for(int k = 0;k<4;k++)
            {
                int x = queue.peek().x + getx[k];
                int y = queue.peek().y + gety[k];
                if(x >= 0 && y >= 0 && x < n && y < n) // 배열 범위를 넘어서지 않으며
                {
                    if(a[x][y] == 1 &&  !visited[x][y]) // 해당 칸이 이동할수 있는 칸이며, 아직 방문안한 배열일경우
                    {
                        visited[x][y] = true;
                        game = new Game(x, y);
                        queue.add(game);
                    }
                }
            }
            queue.remove();

        }
        count++; // bfs를 한다는것 자체가 이미 단지하나가 생성되었다는 뜻이라 count++
        return sum; // 단지에 집이 몇개있는지를 넘겨줘서 리스트에 저장할 것
    }
    public static void main (String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        count = 0;
        ArrayList<Integer> list = new ArrayList<>(); // 한 번 구역을 탐색하러 들어가면 그 구역은 하나의 단지 이기에 list에 저장
        a = new int[n][n];
        visited = new boolean[n][n]; // 방문 처리를 해야 이미 탐색한 단지를 접속하지 않음
        for(int i = 0;i<n;i++)
        {
            String s = br.readLine();
            for(int j = 0;j<n;j++)
            {
                a[i][j] = Integer.parseInt(s.substring(j, j+1));
            }

        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(a[i][j] == 1 && !visited[i][j]) // 집이 존재하고 아직 방문하지않았다면?
                {
                    list.add(BFS(i,j));
                }
            }
        }
        Collections.sort(list); // 오름차순으로 정렬해야해서 정렬
        System.out.println(count); // 단지의 갯수 출력
        for(int i : list) // 오름차순으로 단지마다 크기 출력
        {
            System.out.println(i);
        }
    }

}
class Game {
    public int x;
    public int y;
    public Game(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
