#include <string>
#include <vector>
#include <queue>
using namespace std;
bool visited[201];

void bfs(int idx, vector<vector<int>> computers){
    visited[idx]=true;
    queue<int> q;
    q.push(idx);
    while(!q.empty()){
        int cur= q.front();
        q.pop();
        for(int i=0; i<computers[cur].size(); ++i){
            if(computers[cur][i]==1 && !visited[i]){
                visited[i]=true;
                q.push(i);
            }
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0; i<n; ++i){
        if(!visited[i]){
            bfs(i, computers);
            answer++;
        }
    }
    return answer;
}
