#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <array>
#include <iterator>
using namespace std;

string lcs(const string& str1, const string& str2)
{
    int n = str1.length();
    int m = str2.length();
    vector<vector<int>> dp (n + 1, vector<int> (m + 1, 0));
    for(int i = 1;i<=n;i++)
    {
        for(int j = 1;j<=m;j++)
        {
            if(str1[i - 1] == str2[j - 1])
            {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else
            {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    int i = n, j = m;
    string s;
    while(i > 0 && j > 0)
    {
        if(str1[i - 1] == str2[j - 1])
        {
            s = str1[i - 1] + s;
            i--;
            j--;
        }
        else if(dp[i - 1][j] > dp[i][j - 1])
        {
            i--;
        }
        else
        {
            j--;
        }
    }
    return s;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str1, str2;
    cin >> str1;
    cin >> str2;
    string s = lcs(str1, str2);
    cout << s.length() << endl;
    cout << s << endl;

}
