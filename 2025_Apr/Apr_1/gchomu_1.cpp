#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, winner, maxNum;
vector<vector<int>> cards;

void findMaxNum(int personNum, int idx, int selected, int curNum)
{
    if (5 < idx)
        return;

    if (selected == 3)
    {
        if (maxNum <= curNum)
        {
            maxNum = curNum;
            winner = personNum;
        }
    }

    findMaxNum(personNum, idx + 1, selected, curNum);
    findMaxNum(personNum, idx + 1, selected + 1, (curNum + cards[personNum][idx]) % 10);
}

int main()
{
    cin >> n;
    cards.assign(n, vector<int>(5));
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < 5; ++j)
        {
            cin >> cards[i][j];
        }
    }

    for (int i = 0; i < n; ++i)
    {
        findMaxNum(i, 0, 0, 0);
    }

    cout << winner + 1 << endl;

    return 0;
}
