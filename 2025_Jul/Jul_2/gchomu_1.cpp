#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n, int w, int num) {
    int answer = 0, cur=num, front=0, back=0;
    
    if(((num-1)/w)%2==0){
        back = (w-(num-1)%w)*2-1;
        front = w*2-back;    
    }else{
        back = ((num-1)%w)*2+1;
        front = w*2-back;
    }
    
    
    while(cur<=n){
        answer++;
        if(((cur-1)/w)%2==0){
            cur+=back;
        }else{
            cur+=front;
        }
    }
    return answer;
}
