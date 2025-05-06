#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
int digit, maxNum = -1;
string a, b;
bool visited[11];

void getMaxNum(int idx, string curNum)
{
    if (idx == digit && stoi(curNum) <= stoi(b))
    {
        maxNum = max(maxNum, stoi(curNum));
    }

    for (int i = 0; i < digit; ++i)
    {
        if (idx == 0 && a[i] == '0')
            continue;
        if (!visited[i])
        {
            visited[i] = true;
            getMaxNum(idx + 1, curNum + a[i]);
            visited[i] = false;
        }
    }
}

int main()
{
    cin >> a >> b;
    digit = a.length();
    getMaxNum(0, "");

    cout << maxNum << "\n";
    return 0;
}
