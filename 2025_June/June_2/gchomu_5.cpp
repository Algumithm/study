#include <string>
#include <vector>
#include <queue>
#include <map>
using namespace std;

struct State {
    int time;
    int room;
    int trapState;
    
    bool operator>(const State& other) const {
        return time > other.time;
    }
};

int solution(int n, int start, int end, vector<vector<int>> roads, vector<int> traps) {
    // 함정 번호를 비트 인덱스로 매핑
    map<int, int> trapIndex;
    for(int i = 0; i < traps.size(); i++) {
        trapIndex[traps[i]] = i;
    }
    
    // (방번호, 함정상태) -> 최소시간 저장
    map<pair<int,int>, int> visited;
    
    priority_queue<State, vector<State>, greater<State>> pq;
    pq.push({0, start, 0});
    
    while(!pq.empty()) {
        State current = pq.top();
        pq.pop();
        
        if(current.room == end) {
            return current.time;
        }
        
        pair<int,int> key = {current.room, current.trapState};
        if(visited.count(key) && visited[key] <= current.time) {
            continue;
        }
        visited[key] = current.time;
        
        // 모든 길 확인
        for(auto& road : roads) {
            int from = road[0], to = road[1], cost = road[2];
            
            // 현재 방에서 이 길을 사용할 수 있는지 확인
            bool canUse = false;
            int nextRoom = -1;
            
            // from과 to 중 어느 쪽이 함정인지 확인
            bool fromIsTrap = trapIndex.count(from);
            bool toIsTrap = trapIndex.count(to);
            bool fromActive = fromIsTrap && ((current.trapState >> trapIndex[from]) & 1);
            bool toActive = toIsTrap && ((current.trapState >> trapIndex[to]) & 1);
            
            // 방향이 바뀌는 조건: 연결된 함정 중 활성화된 것의 개수가 홀수
            bool reversed = (fromActive + toActive) % 2 == 1;
            
            if(reversed) {
                // 방향 뒤바뀜: to → from
                if(current.room == to) {
                    canUse = true;
                    nextRoom = from;
                }
            } else {
                // 원래 방향: from → to
                if(current.room == from) {
                    canUse = true;
                    nextRoom = to;
                }
            }
            
            if(canUse) {
                int nextTrapState = current.trapState;
                
                // 도착지가 함정이면 상태 변경
                if(trapIndex.count(nextRoom)) {
                    nextTrapState ^= (1 << trapIndex[nextRoom]);
                }
                
                pq.push({current.time + cost, nextRoom, nextTrapState});
            }
        }
    }
    
    return -1;
}
