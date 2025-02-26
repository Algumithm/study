#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, minDiff = 987654321;
vector<vector<int>> adj;
vector<bool> used;

void checkAbilityDiff()
{
    int startSum = 0, linkSum = 0;
    for (int i = 0; i < used.size(); ++i)
    {
        for (int j = i + 1; j < used.size(); ++j)
        {
            if (used[i] && used[j])
                startSum += (adj[i][j] + adj[j][i]);
            else if (!used[i] && !used[j])
                linkSum += (adj[i][j] + adj[j][i]);
        }
    }

    minDiff = min(minDiff, abs(startSum - linkSum));
}

void findMinDiff(int cnt, int idx)
{
    if (cnt >= (n / 2))
    {
        checkAbilityDiff();
        return;
    }

    for (int i = idx; i < n; ++i)
    {

        if (used[i] == false)
        {
            used[i] = true;
            findMinDiff(cnt + 1, i + 1);
            used[i] = false;
        }
    }
}

int main()
{
    int totalSum = 0;
    cin >> n;
    adj.resize(n, vector<int>(n, 0));
    used.resize(n, false);
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            cin >> adj[i][j];
        }
    }

    findMinDiff(0, 0);
    cout << minDiff << endl;
}
