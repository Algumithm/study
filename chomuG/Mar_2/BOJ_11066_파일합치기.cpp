#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <algorithm>
using namespace std;
int k, testCase;
vector<vector<int>> cache;
vector<int> prefixSum, files;

int getSum(int a, int b) {
	if (a == 0) {
		return prefixSum[b];
	}
	else {
		return prefixSum[b] - prefixSum[a - 1];
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> testCase;
	for (int tc = 0; tc < testCase; ++tc) {
		cin >> k;
		prefixSum.assign(k, 0);
		files.assign(k, 0);
		cache.assign(k, vector<int>(k, 987654321));

		//입력과 구간 합
		for (int i = 0; i < k; ++i) {
			cin >> files[i];
			if (i == 0) {
				prefixSum[i] = files[i];
			}
			else {
				prefixSum[i] = prefixSum[i - 1] + files[i];
			}
		}
		//base case
		for (int i = 0; i < k; ++i) {
			cache[i][i] = 0;
		}

		//구간을 늘려가며 cache 계산
		for (int len = 2; len <= k; ++len) {
			//i : 0~k
			for (int i = 0; i + len <= k; ++i) {
				int j = i + len - 1;
				//mid: 중단점
				for (int mid = i; mid < j; ++mid) {
					//합칠때마다 구간의 합을 더해줘야 한다
					cache[i][j] = min(cache[i][j], cache[i][mid] + cache[mid + 1][j] + getSum(i, j));
				}
			}
		}

		cout<<cache[0][k-1]<<"\n";

	}

	return 0;
}

/*
1. 구간의 길이를 기준으로 반복문을 설계한다

*/
