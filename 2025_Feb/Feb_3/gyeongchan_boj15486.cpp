#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
struct TP {
	int t;
	int p;
};
vector<TP> tps;
vector<int> cache;
int n;

void getMaxProfit() {
	for (int i = n-2; i >= 0; --i) {
		if (cache[i] != -1) {
			if (i + tps[i].t < n) {
				cache[i] = max(cache[i + 1], cache[i] + cache[i + tps[i].t]);
			}
			else {
				cache[i] = max(cache[i + 1], cache[i]);
			}
		}
		else {
			cache[i] = cache[i + 1];
		}
	}
}

int main() {
	cin >> n;
	cache.assign(n + 1, -1);

	for (int i = 0; i < n; ++i) {
		TP tp;
		cin >> tp.t >> tp.p;
		tps.push_back(tp);
		if (i + tp.t <= n)
			cache[i] = tp.p;
		else
			cache[i] = 0;
	}

	getMaxProfit();

	cout << cache[0] << endl;

	return 0;
}
