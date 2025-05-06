#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int f, s, g, u, d, cnt;
bool visited[1000001], isUseStair;

int main()
{
    cin >> f >> s >> g >> u >> d;
    d *= -1;
    visited[s] = true;
    while (s != g)
    {
        // Up 해야 할 때
        if ((s < g || s + d < 1) && s + u <= f)
        {
            s += u;
            if (visited[s])
            {
                isUseStair = true;
                break;
            }
            visited[s] = true;
            cnt++;
        }
        // Down 해야 할 때
        else if ((s > g || s + u > f) && s + d >= 1)
        {
            s += d;
            if (visited[s])
            {
                isUseStair = true;
                break;
            }
            visited[s] = true;
            cnt++;
        }
        else
        {
            isUseStair = true;
            break;
        }
    }

    if (isUseStair)
    {
        cout << "use the stairs\n";
    }
    else
    {
        cout << cnt << "\n";
    }

    return 0;
}
