#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <map>
#include <queue>
#include <deque>
#include <cstdlib>
#include <algorithm>
using namespace std;
int n, k, maxEnergy;
vector<int> branch, cache;


//연속으로 먹거나 안먹거나
void findMaxEnergy(int idx, int satisfaction, int energy) {
	if (idx == n) {
		maxEnergy = max(maxEnergy, energy);
		return ;
	}

	findMaxEnergy(idx + 1, 0, energy);

	satisfaction += branch[idx];

	if (k <= satisfaction) {
		energy += (satisfaction - k);
		satisfaction = 0;
	}

	findMaxEnergy(idx + 1, satisfaction, energy);
}


int main() {
	cin >> n >> k;
	branch.assign(n, 0);
	cache.assign(n, -1);

	for (int i = 0; i < n; ++i) {
		cin >> branch[i];
	}

	findMaxEnergy(0, 0, 0);

	cout << maxEnergy << "\n";

	return 0;
}
