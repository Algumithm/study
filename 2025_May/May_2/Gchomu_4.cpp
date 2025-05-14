#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, maxScore = -1;
vector<vector<int>> results;
int players[9] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

int checkScore()
{
    int outCnt = 0, innings = 0, curPlayer = 0, score = 0, bases[3] = {0, 0, 0};
    ;
    while (innings < n)
    {
        int result = results[innings][players[curPlayer]];
        if (result == 0)
        {
            outCnt++;
            if (outCnt == 3)
            {
                innings++;
                outCnt = 0;
                for (int i = 0; i < 3; ++i)
                {
                    bases[i] = 0;
                }
            }
        }
        else if (result == 4)
        {
            score++;
            for (int i = 0; i < 3; ++i)
            {
                if (bases[i] == 1)
                {
                    score++;
                    bases[i] = 0;
                }
            }
        }
        else
        {
            for (int i = 2; i >= 0; --i)
            {
                if (bases[i] == 1)
                {
                    if (i + result > 2)
                    {
                        score++;
                        bases[i] = 0;
                    }
                    else
                    {
                        bases[i] = 0;
                        bases[i + result] = 1;
                    }
                }
            }
            bases[result - 1] = 1;
        }
        curPlayer = (curPlayer + 1) % 9;
    }
    return score;
}

void getMaxScore(int idx)
{
    if (idx == 9)
    {
        maxScore = max(maxScore, checkScore());
        return;
    }

    for (int i = 0; i < 9; ++i)
    {
        if (players[i] == -1)
        {
            players[i] = idx;
            getMaxScore(idx + 1);
            players[i] = -1;
        }
    }
}

int main()
{
    cin >> n;
    results.assign(n, vector<int>(9));
    players[3] = 0;

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < 9; ++j)
        {
            cin >> results[i][j];
        }
    }
    getMaxScore(1);
    cout << maxScore << endl;
    return 0;
}
