#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
int n, open[2], use, minCnt=987654321;
vector<int> seq;
int cache[30][30][30][2];

void getMinCount(int idx, int cnt) {
	cout << "cnt: " << cnt << endl;
	if (idx == use) {
		minCnt = min(minCnt, cnt);
		return;
	}

	int o1 = open[0], o2 = open[1];
	
	cout << "cach: " << cache[open[0]][open[1]][seq[idx]][0] << endl;
	if (seq[idx] == open[0] || seq[idx] == open[1]) {
		getMinCount(idx + 1, cnt);
	}
	else if (open[0]<seq[idx] && seq[idx] < open[1]) {
		open[0] = seq[idx];
		getMinCount(idx + 1, cnt + cache[open[0]][open[1]][seq[idx]][0]);
		open[0] = o1;
		if (cache[open[0]][open[1]][seq[idx]][1] != -1) {
			open[1] = seq[idx];
			getMinCount(idx + 1, cnt + cache[open[0]][open[1]][seq[idx]][1]);
			open[1] = o2;
		}
	}
	else if (seq[idx] < open[0]) {
		open[0] = seq[idx];
		getMinCount(idx + 1, cnt + cache[open[0]][open[1]][seq[idx]][0]);
		open[0] = o1;
	}else if(open[1] < seq[idx]){
		open[1] = seq[idx];
		getMinCount(idx + 1, cnt + cache[open[0]][open[1]][seq[idx]][0]);
		open[1] = o2;
	}
}

int main()
{
	cin >> n;
	memset(cache, -1, sizeof(cache));
	cin >> open[0] >> open[1];
	open[0]--;
	open[1]--;
	cin >> use;
	for (int i = 0; i < use; ++i)
	{
		int in;
		cin >> in;
		seq.push_back(in-1);
	}

	//초기화 (i, j)가 열려있을 대 k를 여는 최소 cnt 저장
	for (int i = 0; i < n; ++i) {
		for (int j = i + 1; j < n; ++j) {
			for (int k = 0; k < n; ++k) {
				if (k == i || k == j) {
					cache[i][j][k][0] = 0;
				}else if(i<k && k<j){
					cache[i][j][k][0] = k - i;
					cache[i][j][k][1] = j - k;
				}
				else if (k < i) {
					cache[i][j][k][0] = i - k;
				}
				else if (j < k) {
					cache[i][j][k][0] = k - j;
				}
			}
		}
	}

	getMinCount(0, 0);

	cout << minCnt;

	return 0;
}
