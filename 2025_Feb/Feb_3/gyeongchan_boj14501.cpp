#include <iostream>

#include <vector>

#include <algorithm>
using namespace std;
int n, maxPrice = 0;
vector<pair<int, int>> tp;

void findMaxPrice(int index, int curPrice)
{
    maxPrice = max(maxPrice, curPrice);
    for (int i = index; i < n; ++i)
    {
        if (i + tp[i].first <= n)
            findMaxPrice(i + tp[i].first, curPrice + tp[i].second);
    }
}

int main()
{
    cin >> n;

    for (int i = 0; i < n; ++i)
    {
        int t, p;
        cin >> t >> p;
        tp.push_back({t, p});
    }
    for (int i = 0; i < n; ++i)
    {
        if (i + tp[i].first <= n)
            findMaxPrice(i + tp[i].first, tp[i].second);
    }

    cout << maxPrice << endl;
}
