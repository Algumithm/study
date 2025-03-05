#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int n, cache[4001][4001], maxLength;
string s1, s2;

int findMaxLength(int idx1, int idx2) {
	if (idx1 <0 || idx2 <0) {
		return 0;
	}

	int &ret = cache[idx1][idx2];
	if (ret != -1)
		return ret;
	
	if (s1[idx1] == s2[idx2]) {
		ret = findMaxLength(idx1 - 1, idx2 - 1) + 1;
	}
	else {
		ret = 0;
	}

	return ret;
}

int main() {
	cin >> s1 >> s2;
	memset(cache, -1, sizeof(cache));
	for (int i = s1.length() - 1; i>=0; --i) {
		for (int j = s2.length() - 1; j >= 0; --j) {
			maxLength = max(maxLength,findMaxLength(i, j));
		}
	}
	

	cout << maxLength << endl;

	return 0;
}

/*
최장 공통 부분 수열 문제(Longest Common Subsequence) 와 비슷해 점화식은 맞게 세웠으나
코드로 풀어낼 때 헤맸다.

f(i, j)= f(i-1, j-1) +1 //s[i]==s[j]
f(i, j)= 0 // s[i]!=s[j] -> LCS와 다른점
모든 가능한 조합을 탐색.//loop
*/
