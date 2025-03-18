#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <algorithm>
using namespace std;
int n;

int main() {
	ios_base::sync_with_stdio();
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin >> n;
	priority_queue<int> left;
	priority_queue<int, vector<int>,greater<>> right;
	int num, ans;
	for (int i = 0; i < n; ++i) {
		cin >> num;
		if (left.empty() || num<=left.top()) {
			left.push(num);
		}
		else{
			right.push(num);
		}

		if (left.size() > right.size() + 1) {
			right.push(left.top());
			left.pop();
		}
		else if (right.size() > left.size() + 1) {
			left.push(right.top());
			right.pop();
		}

		if (right.size() == left.size()) {
			ans = min(left.top(), right.top());
		}
		else if(left.size()< right.size()){
			ans = right.top();
		}
		else {
			ans = left.top();
		}

		cout << ans << "\n";
	}


	return 0;
}

/*
priority queue를 써야한다는 것은 알고 있었다. 양쪽에서 pq를 사용해 중앙값을 구한다.
세부 조건 조정에서 애먹었다. 짧게 코드 짜려다가 계속 틀린 느낌.

+ endl때문에 출력 시간초과 났다. "\n" 잘 써야할듯.

*/
