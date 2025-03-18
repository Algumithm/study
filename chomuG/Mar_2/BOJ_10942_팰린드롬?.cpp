#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <algorithm>
using namespace std;
int n, m;
vector<int> nums;
int cache[2001][2001];

void dp() {
	int s, e;
	//홀수
	for (int i = 1; i <= n; ++i) {
		s = i - 1; 
		e = i + 1;
		while (s >= 1 && e <= n) {
			if (cache[s + 1][e - 1] != 0 && nums[s] == nums[e]) {
				cache[s][e] = 1;
			}
			else {
				//원래 cache는 0이므로
				break;
			}
			s--;
			e++;
		}
	}

	//짝수
	for (int i = 1; i <= n; ++i) {
		s = i;
		e = i + 3;
		while (s >= 1 && e <= n) {
			if (cache[s + 1][e - 1] != 0 && nums[s] == nums[e]) {
				cache[s][e] = 1;
			}
			else {
				break;
			}
			s--;
			e++;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	nums.assign(n + 1, 0);
	for (int i = 1; i <= n; ++i) {
		cin >> nums[i];
		cache[i][i] = 1;
		if (nums[i] == nums[i - 1])
			cache[i - 1][i] = 1;
	}

	dp();


	cin >> m;
	for (int i = 0; i < m; ++i) {
		int s, e;
		cin >> s >> e;
		cout << cache[s][e] << "\n";
	}



	return 0;
}

/*
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr); 제대로 처리 안해줘서 시간초과.

	짝수 처리 시
	s = i;
	e = i + 1;로 해줬어서 초기 계산 잘못됐었음.
*/
