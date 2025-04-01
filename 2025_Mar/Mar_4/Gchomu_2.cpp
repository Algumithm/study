#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <map>
#include <queue>
#include <deque>
#include <cstdlib>
#include <algorithm>
typedef long long ll;
using namespace std;
ll n, tree, treeQnt;
vector<ll> growth;

int main() {
	cin >> n;
	growth.assign(n, 0);
	for (ll i = 0; i < n; ++i) {
		cin >> tree;
		treeQnt += tree;
	}
	for (ll i = 0; i < n; ++i) {
		cin >> growth[i];
	}
	sort(growth.begin(), growth.end());
	for (ll i = 0; i < n; ++i) {
		treeQnt += (growth[i] * i);
	}
	cout << treeQnt <<"\n";
	return 0;
}
