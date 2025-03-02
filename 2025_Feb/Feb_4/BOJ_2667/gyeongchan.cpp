#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
int n, dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};
vector<vector<int>> grid;
vector<vector<bool>> visited;
vector<int> groups;

bool isOutRange(int r, int c)
{
    return (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0);
}

int dfs(int r, int c)
{
    int ret = 1;
    for (int i = 0; i < 4; ++i)
    {
        int nr = r + dx[i], nc = c + dy[i];
        if (!isOutRange(nr, nc))
        {
            visited[nr][nc] = true;
            ret += dfs(nr, nc);
        }
    }

    return ret;
}

void findGroups()
{
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            if (!isOutRange(i, j))
            {
                visited[i][j] = true;
                int ret = dfs(i, j);
                if (ret)
                {
                    groups.push_back(ret);
                }
            }
        }
    }
}

int main()
{
    cin >> n;
    grid.assign(n, vector<int>(n));
    visited.assign(n, vector<bool>(n, false));
    cin.ignore();
    for (int i = 0; i < n; ++i)
    {
        string s;
        cin >> s;
        for (int j = 0; j < s.length(); ++j)
        {
            grid[i][j] = s[j] - '0';
        }
    }

    findGroups();

    sort(groups.begin(), groups.end());

    cout << groups.size() << endl;
    for (int ans : groups)
    {
        cout << ans << endl;
    }

    return 0;
}
