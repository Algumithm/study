#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;
vector<vector<int>> upAdj, downAdj;

//아래위로 몇명있는지 확인
bool checkRanking(int n, int target){
    vector<bool> visited(n, false);
    queue<int> q;
    int cnt=0, cur=target;
    q.push(cur);
    //아래 확인
    while(!q.empty()){
        
        cur= q.front();
        q.pop();
        
        if(visited[cur]) continue;
        cnt++;
        visited[cur]=true;
        for(int i=0; i<downAdj[cur].size(); ++i){
            if(!visited[downAdj[cur][i]]){
                q.push(downAdj[cur][i]);
            }
        }
    }
    //위 확인
    
    visited.assign(n, false);
    cur=target;
    q.push(cur);
    while(!q.empty()){
        cur= q.front();
        q.pop();
        if(visited[cur]) continue;
        cnt++;
        visited[cur]=true;
        for(int i=0; i<upAdj[cur].size(); ++i){
            if(!visited[upAdj[cur][i]]){
                q.push(upAdj[cur][i]);
            }
        }
    }

    
    return cnt == n + 1;
}

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    upAdj.assign(n, vector<int>(0));
    downAdj.assign(n, vector<int>(0));
    
    for(vector<int> result: results){
        downAdj[result[0]-1].push_back(result[1]-1);
        upAdj[result[1]-1].push_back(result[0]-1);
    }
    for(int i=0; i<n; ++i){
        if(checkRanking(n, i)){
            answer++;
        }
            
    }
    return answer;
}
