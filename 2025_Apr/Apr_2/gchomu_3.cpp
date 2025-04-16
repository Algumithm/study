#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
typedef pair<int, int> pii;
int n;
vector<pii> st;


int main()
{

	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		int s, t;
		cin >> s >> t;
		st.push_back({ s, t });
	}

	sort(st.begin(), st.end());
	priority_queue<int, vector<int>, greater<int>> endTime;

	for (int i = 0; i < n; ++i) {
		if (endTime.empty()) {
			endTime.push(st[i].second);
		}
		else {
			int cur = endTime.top();
			if (cur <= st[i].first) {
				endTime.pop();
				endTime.push(st[i].second);
			}
			else {
				endTime.push(st[i].second);
			}
		}
	}

	cout << endTime.size() << "\n";

	return 0;
}
