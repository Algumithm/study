#include <iostream>
#include <vector>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;
int n, m, dx[] = { -1, 1, 0, 0 }, dy[] = {0, 0, -1, 1};
vector<vector<int>> grid, ans;
vector<vector<bool>> visited;

struct Info{
	int r;
	int c;
	int distance;
};

bool isOutRange(int r, int c) {
	return (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || visited[r][c]);
}

void findMinDistance(int r, int c) {
	queue<Info> q;
	q.push({ r, c, 0 });
	visited[r][c] = true;


	while (!q.empty()) {
		Info cur = q.front();
		q.pop();
		ans[cur.r][cur.c] = cur.distance;

		for (int i = 0; i < 4; ++i) {
			int nr = cur.r + dx[i], nc = cur.c + dy[i], dist = cur.distance;
			if (!isOutRange(nr, nc)) {
				visited[nr][nc] = true;
				q.push({ nr, nc, dist + 1 });
			}
		}
	}
}

int main() {
	cin >> n >> m;
	int pos[2];
	grid.assign(n, vector<int>(m));
	ans.assign(n, vector<int>(m, 0));
	visited.assign(n, vector<bool>(m, false));

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> grid[i][j];
			if (grid[i][j] == 2) {
				pos[0] = i;
				pos[1] = j;
			}
		}
	}

	findMinDistance(pos[0], pos[1]);
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (grid[i][j] != 0 && ans[i][j] == 0) {
				ans[i][j] = -1;
			}
		}
	}
	ans[pos[0]][pos[1]] = 0;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (j == m - 1) {
				cout << ans[i][j];
			}
			else {
				cout << ans[i][j] << " ";
			}
		}
		cout << endl;
	}

	return 0;
}
