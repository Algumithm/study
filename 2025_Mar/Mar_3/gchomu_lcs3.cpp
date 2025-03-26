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
int n, cache[101][101][101], dx[] = {1, 0, 0}, dy[] = {0, 1, 0 }, dz[] = { 0, 0, 1 };
string s[3];

int dp(int idx1, int idx2, int idx3) {
	if (idx1 >= s[0].length() || idx2 >= s[1].length() || idx3 >= s[2].length())
		return 0;

	int &ret = cache[idx1][idx2][idx3];

	if (ret != -1)
		return ret;

	ret = 0;

	if (s[0][idx1] == s[1][idx2] && s[1][idx2] == s[2][idx3]) {
		ret = dp(idx1 + 1, idx2 + 1, idx3 + 1) + 1;
	}
	else {
		ret = max({ dp(idx1 + 1, idx2, idx3), dp(idx1, idx2 + 1, idx3), dp(idx1, idx2, idx3 + 1) });
	}

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	memset(cache, -1, sizeof(cache));

	for (int i = 0; i < 3; ++i)
		cin >> s[i];


	cout << dp(0, 0, 0) << "\n";

	return 0;
}
