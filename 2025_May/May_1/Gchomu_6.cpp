#include <iostream>
#include <queue>
#include <vector>
using namespace std;
typedef pair<int, int> pii;
int grid[9][9];
bool rowVisited[9][10], colVisited[9][10], boxVisited[9][10], isCompleted;
vector<pii> pos;


void completeSudoku(int idx) {
	if (isCompleted)
		return;
	if (idx == pos.size()) {
		isCompleted = true;
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				cout << grid[i][j];
			}
			cout << "\n";
		}
		return;
	}

	int r = pos[idx].first, c = pos[idx].second, boxIdx= (r / 3) * 3 + c / 3;
	for (int i = 1; i <= 9; i++) {
		//아직 사용안한 숫자이면 방문
		if (!rowVisited[r][i] && !colVisited[c][i] && !boxVisited[boxIdx][i]) {
			grid[r][c] = i;
			rowVisited[r][i] = true;
			colVisited[c][i] = true;
			boxVisited[boxIdx][i] = true;
			completeSudoku(idx + 1);
			grid[r][c] = 0;
			rowVisited[r][i] = false;
			colVisited[c][i] = false;
			boxVisited[boxIdx][i] = false;
		}
	}
}

int main()
{
	for (int i = 0; i < 9; ++i) {
		for (int j = 0; j < 9; ++j) {
			char ch;
			cin >> ch;
			grid[i][j] = ch - '0';
			//사용한 숫자 visited 처리
			if (ch != '0') {
				rowVisited[i][ch-'0'] = true;
				colVisited[j][ch-'0'] = true;
				boxVisited[(i / 3) * 3 + j / 3][ch - '0'] = true;
			}
			else {
				//남은 빈칸 위치 저장
				pos.push_back({ i, j });
			}
		}
	}


	completeSudoku(0);

	
	return 0;
}
