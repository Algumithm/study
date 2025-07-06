#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <queue>

using namespace std;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

//현재 위치(r, c)와 보드 상태에 따른 최소조작 횟수
map<pair<pair<int, int>, string>, int> memo;

//현재 보드에서 (r1, c1)에서 (r2, c2)로 가는 최단 거리
int bfs(vector<vector<int>>& board, int r1, int c1, int r2, int c2){
    if(r1 == r2 && c1 == c2) return 0;
    
    vector<vector<int>> visited(4, vector<int>(4, -1));
    queue<pair<int, int>> q;
    
    q.push({r1, c1});
    visited[r1][c1]=0;
    
    while(!q.empty()){
        auto [r, c] = q.front();
        q.pop();
        
        //4방향 탐색
        for(int dir = 0; dir<4; dir++){
            // 1. 1칸 일반이동
            int nr = r + dx[dir];
            int nc = c + dy[dir];
            
            if(nr >= 0 && nr<4 && nc>=0 && nc<4){
                if(visited[nr][nc]== -1){
                    visited[nr][nc] = visited[r][c]+ 1;
                    if(nr == r2 && nc == c2) return visited[nr][nc];
                    q.push({nr, nc});
                }
            }
            
            // 2. Ctrl + 방향키 이동
            nr = r;
            nc = c;
            
            // 해당 방향에 카드가 있을때 까지 이동
            
            while(true){
                nr += dx[dir];
                nc += dy[dir];
                
                //보드 밖으로 나가면 벽에서 멈추기
                if(nr < 0 || nr>=4 || nc<0 || nc>=4){
                    nr -= dx[dir];
                    nc -= dy[dir];
                    break;
                }
                
                //카드가 있으면 멈춤
                if(board[nr][nc] !=0){
                    break;
                }
            }
            
            //이동한 위치가 현재 위치와 다르고 방문하지 않았다면
            if((nr!=r || nc!=c) && visited[nr][nc]==-1){
                visited[nr][nc] = visited[r][c] + 1;
                if(nr == r2 && nc == c2) return visited[nr][nc];
                q.push({nr, nc});
            }
        }
    }
    
    return -1;
}

//카드 위치 찾기
vector<pair<int, int>> findCards(vector<vector<int>>& board, int cardNum){
    vector<pair<int, int>> positions;
    for(int i=0; i<4; ++i){
        for(int j=0; j<4; ++j){
            if(board[i][j] == cardNum){
                positions.push_back({i, j});
            }
        }
    }
    return positions;
}

string boardToString(vector<vector<int>>& board){
    string state="";
    for(int i=0; i<4; ++i){
        for(int j=0; j<4; ++j){
            state += to_string(board[i][j]);
        }
    }
    return state;
}

// 백트래킹 + 메모이제이션
int solve(vector<vector<int>>& board, int r, int c){
    //현재 상태 확인
    string state = boardToString(board);
    pair<pair<int, int>, string> key = {{r, c}, state};
    
    if(memo.count(key)){
        return memo[key];
    }
    
    // 모든 카드가 제거되었는지 확인
    bool allCleared = true;
    for(int i=0; i<4; ++i){
        for(int j=0; j<4; ++j){
            if(board[i][j]!=0){
                allCleared = false;
                break;
            }
        }
        if(!allCleared) break;
    }
    
    if(allCleared){
        return memo[key] = 0;
    }
    
    int result = 987654321;
    
    // 남은 카드 종류 찾기
    vector<int> remainingCards;
    for(int i=0; i<4; ++i){
        for(int j=0; j<4; ++j){
            if(board[i][j] !=0){
                bool found = false;
                for(int card : remainingCards){
                    if(card == board[i][j]){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    remainingCards.push_back(board[i][j]);
                }
            }
        }
    }
    
    //각 카드 종류에 대해 시도
    
    // 각 카드 종류에 대해 시도
    for(int cardNum : remainingCards) {
        vector<pair<int,int>> cardPos = findCards(board, cardNum);
        
        // 카드 쌍 제거 순서 2가지 시도
        // 1) 첫 번째 카드 → 두 번째 카드
        int cost1 = bfs(board, r, c, cardPos[0].first, cardPos[0].second) + 1; // 첫 번째 카드로 이동 + 선택
        cost1 += bfs(board, cardPos[0].first, cardPos[0].second, cardPos[1].first, cardPos[1].second) + 1; // 두 번째 카드로 이동 + 선택
        
        // 2) 두 번째 카드 → 첫 번째 카드  
        int cost2 = bfs(board, r, c, cardPos[1].first, cardPos[1].second) + 1; // 두 번째 카드로 이동 + 선택
        cost2 += bfs(board, cardPos[1].first, cardPos[1].second, cardPos[0].first, cardPos[0].second) + 1; // 첫 번째 카드로 이동 + 선택
        
        // 두 순서 모두 시도해서 최소값 선택
        
        // 1) 첫 번째 → 두 번째 순서로 제거
        board[cardPos[0].first][cardPos[0].second] = 0;
        board[cardPos[1].first][cardPos[1].second] = 0;
        
        int nextCost1 = solve(board, cardPos[1].first, cardPos[1].second);
        result = min(result, cost1 + nextCost1);
        
        // 백트래킹: 원상복구
        board[cardPos[0].first][cardPos[0].second] = cardNum;
        board[cardPos[1].first][cardPos[1].second] = cardNum;
        
        // 2) 두 번째 → 첫 번째 순서로 제거
        board[cardPos[1].first][cardPos[1].second] = 0;
        board[cardPos[0].first][cardPos[0].second] = 0;
        
        int nextCost2 = solve(board, cardPos[0].first, cardPos[0].second);
        result = min(result, cost2 + nextCost2);
        
        // 백트래킹: 원상복구
        board[cardPos[1].first][cardPos[1].second] = cardNum;
        board[cardPos[0].first][cardPos[0].second] = cardNum;
    }
    
    return memo[key] = result;
}

int solution(vector<vector<int>> board, int r, int c) {
    memo.clear();
    return solve(board, r, c);
}
