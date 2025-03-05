#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;
int n, maxLength, cache[31];

int dp(int idx) {
	int &ret = cache[idx];
	if (ret != -1)
		return ret;

	ret = dp(idx - 2)*4 - dp(idx-4);

	return ret;
}

int main() {
	cin >> n;
	memset(cache, -1, sizeof(cache));
	cache[0] = 1;
	cache[2] = 3;
	cache[4] = 11;
	dp(n);
	if (n % 2 == 1)
		cache[n] = 0;
	cout << cache[n] << endl;
	return 0;
}

/*

*/
