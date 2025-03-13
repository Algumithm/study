# 알고리즘

BFS, DFS, DP on Tree

# 난이도

배점: 400

AtCoder Problems: 704

# 링크

https://atcoder.jp/contests/abc333/tasks/abc333_d

# 접근 과정

루트 노드를 제거하기 위해서는 루트에서 출발하는 서브트리 중에서 서브트리 단 한 개 이외의 모든 서브트리는 제거되어야 한다. 따라서 각 서브트리의 노드 개수를 구한 다음, 가장 노드가 많지는 않은 모든 서브트리를 제거해주면 된다.

```python
from collections import deque

def BFS(sv: int) -> int:
    dq = deque()
    dq.append(sv)
    visited[sv] = True
    cnt = 1  # 노드의 갯수

    while dq:
        curv = dq.popleft()
        for nxtv in G[curv]:
            if not visited[nxtv]:
                visited[nxtv] = True
                cnt += 1
                dq.append(nxtv)

    return cnt

V = int(input())
G = [[] for _ in range(V+1)]
for _ in range(V-1):
    u, v = map(int, input().split())
    G[u].append(v)
    G[v].append(u)

visited = [False for _ in range(V+1)]
visited[1] = True
if len(G[1]) == 1:  # 서브트리가 하나 뿐이면 바로 루트를 제거할 수 있다.
    print(1)
    exit()

ans = []
for connected in G[1]:
    tmp = BFS(connected)  # 연결된 각 정점에서 BFS를 시행해 모드 개수를 얻는다.
    # print(tmp)
    ans.append(tmp)

ans.sort()
res = 1
for i in range(len(ans)-1):
    res += ans[i]
print(res)
```
