#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, testCase;
vector<vector<int>> cache, sticker;

int getMaxScore(int idx, int direct) {
	if (n <= idx) {
		return 0;
	}
		
	int &ret = cache[idx][direct];

	if(idx == n-1)
		ret = sticker[idx][direct];

	if (ret != -1)
		return ret;

	ret = sticker[idx][direct];
	direct = (direct == 0) ? 1 : 0;

	ret += max(getMaxScore(idx + 1, direct), getMaxScore(idx + 2, direct));

	return ret;
}

int main()
{
	cin >> testCase;

	for (int tc = 0; tc < testCase; ++tc) {
		cin >> n;
		cache.assign(n, vector<int>(2, -1));
		sticker.assign(n, vector<int>(2));
		
		for (int i = 0; i < n; ++i)
			cin >> sticker[i][0];
		for (int i = 0; i < n; ++i)
			cin >> sticker[i][1];


		cout << max(getMaxScore(0, 0), getMaxScore(0, 1)) << "\n";;
	}


	return 0;
}
