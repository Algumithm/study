import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int l,c;
    static String[] ch;
    static String[] ch2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        l=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        ch=new String[c];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            ch[i]=st.nextToken();
        }
        Arrays.sort(ch);
        ch2=new String[l];
        Comb(0,0);
    }

    static void Comb(int idx,int start){
        if(idx==l){
            for(int i=0;i<l;i++){
                if(isValid(ch2)){
                    goPrint(ch2);
                    break;
                }
            }
            return;
        }

        for(int i=start;i<c;i++){
            ch2[idx]=ch[i];
            Comb(idx+1,i+1);
        }
    }

    static boolean isValid(String[] arr){
        int moem=0;
        int jaem=0;

        for(int i=0;i<l;i++){
            if(arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")||arr[i].equals("o")||arr[i].equals("u")){
                moem++;
            }else{
                jaem++;
            }
        }

        if(moem>=1 && jaem>=2) return true;
        else return false;
    }

    static void goPrint(String[] arr){
        for(int i=0;i<l;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
