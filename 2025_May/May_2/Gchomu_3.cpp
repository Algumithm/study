#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
int n, k;

int bfs()
{
    queue<pair<int, int>> q;
    q.push({n, 0});

    vector<bool> visited(100001, false);

    while (!q.empty())
    {
        auto cur = q.front();
        q.pop();

        int pos = cur.first;
        int time = cur.second;

        if (pos < 0 || pos > 100000)
            continue;

        if (visited[pos])
            continue;

        visited[pos] = true;

        if (pos == k)
        {
            return time;
        }

        q.push({pos * 2, time + 1});
        q.push({pos + 1, time + 1});
        q.push({pos - 1, time + 1});
    }

    return -1;
}

int main()
{
    cin >> n >> k;

    cout << bfs();

    return 0;
}
