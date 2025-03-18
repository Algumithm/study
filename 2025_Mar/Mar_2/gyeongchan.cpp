#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
int n, minCost=987654321;
int adj[10][10];
bool visited[10];

void findMinCost(int depth, int curCost, int prev, int first) {
	if (depth == n) {
		if (adj[prev][first] != 0) {
			minCost = min(minCost, curCost + adj[prev][first]);
		}
		return;
	}


	for (int i = 0; i < n; ++i){
		if (!visited[i]) {
			visited[i] = true;
			if (prev == -1) {
				findMinCost(depth + 1, curCost, i, i);
			}
			else if(adj[prev][i] != 0){
					findMinCost(depth + 1, curCost + adj[prev][i], i, first);
			}

			visited[i] = false;
		}
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> adj[i][j];
		}
	}
	findMinCost(0, 0, -1, -1);

	cout << minCost << endl;
	return 0;
}
