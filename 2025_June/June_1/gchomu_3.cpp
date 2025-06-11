#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
int T, W, cache[1001][31], num[1001];

int dp(int t, int w, int pos)
{
    if (t == T)
        return 0;
    int cnt = 0;
    if (num[t] == pos)
        cnt = 1;

    if (t == T - 1)
    {
        return cnt;
    }

    int &ret = cache[t][w];
    if (ret != -1)
        return ret;

    // 위치 변경 안했을 때
    ret = dp(t + 1, w, pos) + cnt;

    // 위치 변경 했을 때
    if (w < W)
    {
        pos = (pos == 1) ? 2 : 1;
        ret = max(ret, dp(t + 1, w + 1, pos) + cnt);
    }

    return ret;
}

int main()
{
    memset(cache, -1, sizeof(cache));
    cin >> T >> W;
    for (int i = 0; i < T; ++i)
    {
        cin >> num[i];
    }

    cout << max(dp(0, 0, 1), dp(0, 1, 2)) << "\n";
    return 0;
}
