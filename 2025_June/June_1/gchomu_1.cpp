#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int k;
vector<int> arr;
void combination(int cnt, int depth, vector<int> lotto)
{
    if (cnt == 6)
    {
        for (int i = 0; i < 5; ++i)
        {
            cout << lotto[i] << " ";
        }

        cout << lotto[5] << "\n";
        return;
    }

    if (depth == k)
        return;
    lotto.push_back(arr[depth]);
    combination(cnt + 1, depth + 1, lotto);
    lotto.pop_back();
    combination(cnt, depth + 1, lotto);
}

int main()
{
    while (1)
    {
        cin >> k;
        if (k == 0)
            break;

        arr.assign(k, 0);
        for (int i = 0; i < k; ++i)
        {
            cin >> arr[i];
        }

        sort(arr.begin(), arr.end());
        combination(0, 0, {});
        cout << "\n";
    }

    return 0;
}
