#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <array>
#include <iterator>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    int a[n + 1], b[n + 1];
    int dp[25];
    for(int i = 0;i<25;i++)
    {
        dp[i] = 0;
    }
    for(int i = 1;i<=n;i++)
    {
        cin >> a[i]>> b[i];
    }
    for(int i = 1;i<=n;i++)
    {
        dp[i] = max(dp[i - 1], dp[i]);
        dp[a[i] + i - 1] = max(dp[a[i] + i - 1], dp[i - 1] + b[i]);
    }
    cout << dp[n];
}
