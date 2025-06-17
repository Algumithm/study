#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
vector<long long> solution(long long k, vector<long long> room_number) {
    vector<long long> copy_number = room_number, answer;
    set<ll> rooms;
    ll cur=0;
    sort(copy_number.begin(), copy_number.end());
    
    
    //필요 방 번호 저장
    for(int i=0; i<copy_number.size(); ++i){
        if(cur<copy_number[i]){
            cur=copy_number[i]+1;
            rooms.insert(copy_number[i]);
        }else{
            rooms.insert(cur);
            cur++;
        }
    }
    
    //순서대로 배정
    for(int i=0; i<room_number.size(); ++i){
        auto it = rooms.lower_bound(room_number[i]);
        answer.push_back(*it);
        rooms.erase(it);
    }
    
    return answer;
}
