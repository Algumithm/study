#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> players, int m, int k) {
    int answer = 0;
    vector<int> servers(24, 0);
    
    for(int i=0; i<players.size(); ++i){
        if(players[i]==0)
            continue;
        int pCnt = players[i], needed=0;
        if(servers[i] < pCnt/m){
            needed= max(needed, (pCnt/m)-servers[i]);
        }
        answer+=needed;
        for(int j=i; j < i+k; j++){
            if(j == players.size())
                break;
            servers[j]+=needed;
        }
    }
    
    
    return answer;
}
