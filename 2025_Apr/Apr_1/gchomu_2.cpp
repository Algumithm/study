#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int testCase, n;
vector<vector<int>> ranks;

int main()
{
    cin >> testCase;

    for (int tc = 0; tc < testCase; ++tc)
    {
        int newEmpNum = 1, maxInterviewRank = 0;
        cin >> n;
        ranks.assign(n, vector<int>(2));

        for (int i = 0; i < n; ++i)
        {
            cin >> ranks[i][0] >> ranks[i][1];
        }

        sort(ranks.begin(), ranks.end());
        maxInterviewRank = ranks[0][1];
        for (int i = 1; i < n; ++i)
        {
            // 인터뷰 성적에서 나보다 높은 등수가 없으면 채용 후 등수 갱신
            if (ranks[i][1] < maxInterviewRank)
            {
                newEmpNum++;
                maxInterviewRank = ranks[i][1];
            }
        }

        cout << newEmpNum << "\n";
    }
}
