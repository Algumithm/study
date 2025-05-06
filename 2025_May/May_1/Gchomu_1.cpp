#include <iostream>
#include <algorithm>
#include <deque>
#include <queue>
using namespace std;
int n, testCase;
int main()
{
    cin >> testCase;
    while (testCase--)
    {
        deque<int> trees;
        int minDiff = 0;
        cin >> n;
        priority_queue<int> pq;
        for (int i = 0; i < n; ++i)
        {
            int in;
            cin >> in;
            pq.push(in);
        }
        while (!pq.empty())
        {
            trees.push_back(pq.top());
            pq.pop();
            if (pq.empty())
                break;
            trees.push_front(pq.top());
            pq.pop();
        }
        for (int i = 0; i < n - 1; ++i)
        {
            minDiff = max(minDiff, abs(trees[i] - trees[i + 1]));
        }
        cout << minDiff << "\n";
    }

    return 0;
}
