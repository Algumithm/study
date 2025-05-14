#include <bits/stdc++.h>
using namespace std;

long long s, c, mid, l=0, r=1000000001, len[1000001], cnt, sum;

int main(){
    cin.tie(NULL);
	cout.tie(NULL);

    cin>>s>>c;

    for(long long i=0; i<s; i++){
        cin>>len[i];
        sum+=len[i];
    }

    while(l+1<r){
        cnt=0;
        mid=(l+r)/(1ll*2);
        for(long long i=0; i<s; i++){
            cnt+=(len[i]/mid);
        }

        if(cnt<c)
            r=mid;
        else
            l=mid;
    }
    cout<<sum-l*c;
    return 0;
}
