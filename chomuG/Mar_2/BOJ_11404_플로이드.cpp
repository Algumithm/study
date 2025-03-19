#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <algorithm>
using namespace std;
int n, m;
vector<vector<int>> adj, price;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	adj.assign(n + 1, vector<int>(n + 1, 0));
	price.assign(n + 1, vector<int>(n + 1, 987654321));
	for (int i = 0; i < m; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		if (adj[a][b] == 0)
			adj[a][b] = c;
		else
			adj[a][b] = min(adj[a][b], c);
	}

	//base case
	for (int s = 1; s <= n; ++s) {
		for (int e = 1; e <= n; ++e) {
			if (adj[s][e] != 0)
				price[s][e] = adj[s][e];
		}
		price[s][s] = 0;
	}


	//직접 가는것보다 경유하는게 가까운 경우 갱신
	for (int mid = 1; mid <= n; ++mid) {
		for (int s = 1; s <= n; ++s) {
			for (int e = 1; e <= n; ++e) {
				price[s][e] = min(price[s][e], price[s][mid] + price[mid][e]);
			}
		}
	}

	for (int s = 1; s <= n; ++s) {
		for (int e = 1; e <= n; ++e) {
			if (price[s][e] != 987654321) {
				cout << price[s][e] << " ";
			}
			else {
				cout << 0 << " ";
			}
		}
		cout << "\n";
	}
	



	return 0;
}

/*
경유하는 점을 가장 바깥에 반복문에 배치
*/
