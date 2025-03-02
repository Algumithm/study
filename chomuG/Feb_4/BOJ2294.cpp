#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
int n, k;
vector<int> cache, coin;

void calculateMinNum()
{
    for (int i = 1; i <= k; ++i)
    {
        for (int c : coin)
        {
            if (0 < i - c && cache[i - c] != -1)
            {
                if (cache[i] == -1)
                {
                    cache[i] = cache[i - c] + 1;
                }
                else
                {
                    cache[i] = min(cache[i], cache[i - c] + 1);
                }
            }
        }
    }
}

int main()
{
    cin >> n >> k;
    cache.assign(k + 1, -1);
    cache[0] = 0;
    for (int i = 0; i < n; ++i)
    {
        int in;
        cin >> in;
        coin.push_back(in);
        cache[in] = 1;
    }

    calculateMinNum();

    cout << cache[k] << endl;
    return 0;
}

/*
F(k) = k원을 만들기 위해 사용되는 동전의 최소 개수
F(k) = min(F(k-x) + 1, F(k)) // x : 1~n
*/
