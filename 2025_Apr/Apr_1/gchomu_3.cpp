#include <iostream>
#include <vector>
#include <cstring>
#include <string>
using namespace std;
int n, normal, blind, dx[] = { 1, -1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
vector<vector<char>> grid;
vector<vector<bool>> visited;

bool isOutRange(int r, int c) {
	return (r < 0 || r >= n || c < 0 || c >= n || visited[r][c]);
}

void countZone(int r, int c, char color)
{
	for (int i = 0; i < 4; ++i) {
		int nr = r + dx[i], nc = c + dy[i];
		if (!isOutRange(nr, nc) && grid[nr][nc]==color) {
			visited[nr][nc] = true;
			countZone(nr, nc, color);
		}
	}
}

int main()
{
	cin >> n;
	cin.ignore();
	grid.assign(n, vector<char>(n));
	visited.assign(n, vector<bool>(n, false));
	for (int i = 0; i < n; ++i)
	{
		string s;
		cin >> s;
		for (int j = 0; j < n; ++j)
		{
			grid[i][j] = s[j];
		}

	}

	//일반
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (!visited[i][j]) {
				visited[i][j] = true;
				countZone(i, j, grid[i][j]);
				normal++;
			}
		}
	}

	visited.assign(n, vector<bool>(n, false));
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (grid[i][j] == 'R')
				grid[i][j] = 'G';
		}
	}

	//색약
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (!visited[i][j]) {
				visited[i][j] = true;
				countZone(i, j, grid[i][j]);
				blind++;
			}
		}
	}

	cout << normal << " " << blind << "\n";

	return 0;
}
