#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, m;
vector<int> cache;
vector<bool> vip;

int main()
{
    cin >> n >> m;
    vip.assign(n + 1, false);
    cache.assign(n + 1, 0);
    cache[0] = 1;
    cache[1] = 1;
    for (int i = 0; i < m; ++i)
    {
        int in;
        cin >> in;
        vip[in] = true;
    }

    for (int i = 2; i <= n; ++i)
    {
        cache[i] = cache[i - 2] + cache[i - 1];
    }
    int cnt = 0, ans = 1;
    for (int i = 1; i <= n; ++i)
    {
        cnt++;
        if (vip[i])
        {
            ans *= cache[cnt - 1];
            cnt = 0;
        }
    }
    ans *= cache[cnt];

    cout << ans;
    return 0;
}
