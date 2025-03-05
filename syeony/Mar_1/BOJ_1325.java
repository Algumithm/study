import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s1_1325 {
    static int n,m;
    static ArrayList<Integer>[] list;
    static int ma=Integer.MIN_VALUE;
    static boolean[] v;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        depth=new int[n+1];
        for(int i=1;i<n+1;i++){
            v=new boolean[n+1];
            int n=bfs(i);
            ma=Math.max(ma,n);
            depth[i]=n;
        }

//        System.out.println(Arrays.toString(depth));

        for(int i=0;i<n+1;i++){
            if(depth[i]==ma){
                System.out.print(i+" ");
            }
        }

    }

    static int bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        v[start]=true;
        int num=0;

        while(!q.isEmpty()){
            int c=q.poll();

            for(int i:list[c]){
                if(!v[i]){
                    v[i]=true;
                    num+=1;
                    q.add(i);
                }
            }
        }

        return num;
    }
}
