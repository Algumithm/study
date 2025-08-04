#include <vector>
using namespace std;

void hanoi(int n, int from, int to, int aux, vector<vector<int>>& result) {
    if(n == 1) {
        result.push_back({from, to});
        return;
    }
    
    // 1. n-1개를 시작→보조로 이동
    hanoi(n-1, from, aux, to, result);
    
    // 2. 가장 큰 원판을 시작→목적지로 이동  
    result.push_back({from, to});
    
    // 3. n-1개를 보조→목적지로 이동
    hanoi(n-1, aux, to, from, result);
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> result;
    hanoi(n, 1, 3, 2, result);  // 1번→3번, 2번은 보조
    return result;
}
