#include <iostream>
#include <vector>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;
int n, m, maxRect;
vector<vector<int>> grid, cache;

int main()
{
	cin >> n >>m;
	cin.ignore();
	grid.assign(n, vector<int>(m));
	cache.assign(n, vector<int>(m, 0));
	for (int i = 0; i < n; ++i) {
		string s;
		cin >> s;
		for (int j = 0; j < m; ++j) {
			grid[i][j] = s[j] - '0';
			if (grid[i][j] == 1) {
				cache[i][j] = 1;
				maxRect = 1;
			}
		}
	}


	for (int i = 0; i < n - 1; ++i) {
		for (int j = 0; j < m - 1; ++j) {
			if (grid[i + 1][j + 1] == 1) {
				cache[i + 1][j + 1] = min({ cache[i][j], cache[i + 1][j], cache[i][j + 1] }) + 1;
				maxRect = max(maxRect, cache[i + 1][j + 1]);
			}
		}
	}

	cout << maxRect*maxRect << "\n";

	return 0;
}
