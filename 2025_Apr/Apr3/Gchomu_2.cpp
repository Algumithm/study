#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>
#include<unordered_map>
using namespace std;
typedef pair<int, int> pii;
int n, testCase;
long long minSumSize = LLONG_MAX;
vector<pii> pos;
vector<int> ops;

long long getSumSize() {
	long long sumX = 0, sumY = 0;
	for (int i = 0; i < pos.size(); i++) {
		sumX += (pos[i].first * ops[i]);
		sumY += (pos[i].second * ops[i]);

	}
	return sumX * sumX + sumY * sumY;
}

void getMinVectorSum(int idx, int remainPlus, int remainMinus) {
	if (remainPlus == 0 && remainMinus == 0) {
		minSumSize = min(minSumSize, getSumSize());
		return;
	}

	ops.push_back(1);
	if(remainPlus>0)
		getMinVectorSum(idx + 1, remainPlus-1, remainMinus);
	ops.pop_back();

	ops.push_back(-1);
	if (remainMinus > 0)
		getMinVectorSum(idx + 1, remainPlus, remainMinus-1);
	ops.pop_back();
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> testCase;
	
	for (int tc = 1; tc <= testCase; ++tc) {
		cin >> n;
		pos.clear();
		minSumSize = LLONG_MAX;

		for (int i = 0; i < n; ++i) {
			int x, y;
			cin >> x >> y;
			pos.push_back({ x, y });
		}
		 
		getMinVectorSum(0, n/2, n/2);


		cout << "#" << tc << " " <<minSumSize << "\n";
	}
	
	return 0;
}
