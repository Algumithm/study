import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int n,m;
    static ArrayList<int[]> home,chiken;
    static int mi=Integer.MAX_VALUE;
    static boolean[] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        home=new ArrayList<>();
        chiken=new ArrayList<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==1){
                    home.add(new int[]{i,j});
                }else if(temp==2){
                    chiken.add(new int[]{i,j});
                }
            }
        }
        v=new boolean[chiken.size()];
        dfs(0,0);

        System.out.println(mi);
    }

    static void dfs(int idx, int chiken_cnt){
        if(chiken_cnt==m){
            mi=Math.min(mi,cal());
            return;
        }

        //모든 조합을 구하는 코드 그냥 외우자
        for(int i=idx;i<chiken.size();i++){
            v[i]=true;
            dfs(i+1,chiken_cnt+1);
            v[i]=false;
        }
    }

    static int cal(){
        int sum=0;

        for(int[] h:home){
            int m=Integer.MAX_VALUE;
            for(int i=0;i< chiken.size();i++){
                if(v[i]){
                    int distance=Math.abs(h[0]-chiken.get(i)[0])+Math.abs(h[1]-chiken.get(i)[1]);
                    m=Math.min(m,distance);
                }
            }
            sum+=m;
        }

        return sum;
    }

    //처음엔 dfs만으로 접근하려했음=>실패
//    static void dfs(int h,int c, int distance){
//        if(c>=m) return;
//        if(h==home.size()) {
//            mi=Math.min(mi,distance);
//            return;
//        }
//
//        dfs(h+1,c,distance+(Math.abs(home.get(h+1)[0]-chiken.get(c)[0])+Math.abs(home.get(h+1)[1]-chiken.get(c)[1])));
//        dfs(h,c+1,distance+(Math.abs(home.get(h)[0]-chiken.get(c+1)[0])+Math.abs(home.get(h)[1]-chiken.get(c+1)[1])));
//    }
}
