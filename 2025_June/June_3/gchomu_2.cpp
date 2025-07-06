#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Task{
    int duration;
    int requestTime;
    int num;
    
    bool operator < (const Task& other)const{
        if(duration != other.duration)
            return duration > other.duration;
        
        if(requestTime != other.requestTime){
            return requestTime > other.requestTime;
        }
        return num > other.num;
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0, currentTime = 0;
    
    sort(jobs.begin(), jobs.end());
    
    priority_queue<Task> pq;
    int jobIndex = 0;
    int completed = 0;
    
    while(completed < jobs.size()) {
        while(jobIndex < jobs.size() && jobs[jobIndex][0] <= currentTime) {
            Task task;
            task.requestTime = jobs[jobIndex][0];
            task.duration = jobs[jobIndex][1];
            task.num = jobIndex;
            pq.push(task);
            jobIndex++;
        }
        
        // 수행할 수 있는 작업이 있다면
        if(!pq.empty()) {
            Task currentTask = pq.top();
            pq.pop();
            
            completed++;
            currentTime += currentTask.duration;
            answer += (currentTime - currentTask.requestTime);

        }
        // 수행할 수 있는 작업이 없다면 다음 작업으로 이동
        else {
            if(jobIndex < jobs.size()) {
                currentTime = jobs[jobIndex][0];
            }
        }
    }
    
    return answer / jobs.size();
}
