#include <bits/stdc++.h>
using namespace std;

long long t, n, arr[1000001];
void dfs(){

}
int main(){
    cin>>t;

    while(t--){
        cin>>n;
        long long Max=0, ans=0;

        for(int i=0; i<n; i++){
            cin>>arr[i];
        }
        Max=arr[n-1];

        for(int i=n-2; i>=0; i--){
            if(arr[i]<Max)
                ans+=(Max-arr[i]);
            else{
                Max=arr[i];
            }
        }
        cout<<ans<<endl;
    }


    return 0;
}
