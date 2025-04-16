#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, budget, requestSum, maxRequest;
vector<int> request;
int main()
{
	cin >> n;
	request.assign(n, 0);

	for (int i = 0; i < n; ++i) {
		cin >> request[i];
		maxRequest = max(maxRequest, request[i]);
		requestSum += request[i];
	}
	cin >> budget;

	if (requestSum <= budget) {
		cout << maxRequest << "\n";
		return 0;
	}

	int low=1, high=budget+1, mid;

	while (low+1 < high) {
		int sum = 0;
		mid = (low + high) / 2;
		for (int i = 0; i < n; ++i) {
			sum += min(request[i], mid);
		}

		//요청 예산이 주어진 예산보다 크면 줄여야함
		if (budget < sum) {
			high = mid;
		}
		else {
			low = mid;
		}
	}

	cout << low << "\n";

	return 0;
}
