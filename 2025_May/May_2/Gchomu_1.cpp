#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, m, minFuel = 987654321, space[7][7];

int dx[3] = {-1, 0, 1};

void getMinFuel(int row, int col, int prevDir, int curFuel)
{

    if (row == n)
    {
        minFuel = min(minFuel, curFuel);
        return;
    }

    for (int dir = 0; dir < 3; dir++)
    {

        if (dir == prevDir && prevDir != -1)
            continue;

        int nextCol = col + dx[dir];

        if (nextCol < 0 || nextCol >= m)
            continue;

        getMinFuel(row + 1, nextCol, dir, curFuel + space[row][nextCol]);
    }
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> space[i][j];
        }
    }

    for (int i = 0; i < m; i++)
    {
        getMinFuel(1, i, -1, space[0][i]);
    }

    cout << minFuel << "\n";
    return 0;
}
