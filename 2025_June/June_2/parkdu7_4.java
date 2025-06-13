// 효율성 테스트 실패(시간 초과)
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        List<Long> assigned = new ArrayList<>();
        int n = room_number.length;
        
        for(int i = 0; i < n; i++){
            if(assigned.contains(room_number[i])){
                for(long j = room_number[i] + 1; j <= k; j++){
                    if(!assigned.contains(j)){
                        assigned.add(j);
                        break;
                    }
                }
            }
            else{
                assigned.add(room_number[i]);
            }
        }
        
        answer = new long[assigned.size()];
        for(int i = 0; i < assigned.size(); i++){
            answer[i] = assigned.get(i);
        }
        
        return answer;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

// 효율성 테스트 통과 (Union-find)  (ps. claude 코드)
import java.util.*;

class Solution {
    private Map<Long, Long> parent = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            long wantedRoom = room_number[i];
            long assignedRoom = find(wantedRoom);
            
            answer[i] = assignedRoom;
            
            // 배정된 방을 다음 가능한 방(assignedRoom + 1)과 연결
            union(assignedRoom, assignedRoom + 1);
        }
        
        return answer;
    }
    
    // Union-Find의 find 연산 (경로 압축 적용)
    private long find(long x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x))); // 경로 압축
        }
        
        return parent.get(x);
    }
    
    // Union-Find의 union 연산
    private void union(long x, long y) {
        long rootX = find(x);
        long rootY = find(y);
        
        if (rootX != rootY) {
            parent.put(rootX, rootY);
        }
    }
}

