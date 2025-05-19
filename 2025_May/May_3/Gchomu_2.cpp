#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
int n, a, b, m;
vector<vector<int>> adj;
vector<bool> visited;
int getRelative() {
	queue<pair<int, int>> q;
	q.push({a, 0});

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		if (cur.first == b) {
			return cur.second;
		}
		q.pop();
		for (int i = 0; i < adj[cur.first].size(); ++i) {
			if (!visited[adj[cur.first][i]]) {
				visited[adj[cur.first][i]] = true;
				q.push({ adj[cur.first][i], cur.second + 1 });
			}
		}
	}
	return -1;
}

int main() {
	cin >> n >> a >> b >> m;
	adj.assign(n+1, vector<int>(0));
	visited.assign(n+1, false);
	for (int i = 0; i < m; ++i) {
		int p, c;
		cin >> p >> c;
		adj[p].push_back(c);
		adj[c].push_back(p);
	}

	cout<<getRelative();

	return 0;
}
