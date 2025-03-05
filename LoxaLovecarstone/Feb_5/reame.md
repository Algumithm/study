# 알고리즘

Dijkstra

# 난이도

배점: 400

AtCoder Problems: 765

# 링크

https://atcoder.jp/contests/abc373/tasks/abc373_d 

# 접근 과정

이전에 이런 문제를 풀어봤을 때, 하나를 정하면 나머지는 그에 맞춰서 설정을 해주면 정답이 나옴을 배웠다. 그래서 아직 방문하지 않은 아무 정점의 가중치를 0으로 잡은 다음에, 간선을 따라가면서 연결된 정점의 가중치를 그에 맞게 설정하면 될 것이라고 생각했다.

이러한 접근 방식은 이후 에디토리얼을 열어보았을 때도 첫 아이디로 제시했던 것이기 때문에 옳은 접근이었다. 그런데 이후에 문제가 되었던 것은 “어떻게 잘못된 걸 바로잡지?” 였다. 아래 그림을 보자.

![image.png](attachment:77977202-3b2e-4b19-abf9-bd731aa6f37c:image.png)

처음에 V1에서 출발해, 간선의 가중치 10을 따라 V2의 가중치를 10으로 설정한다.
V3은 아직 방문하지 않았으므로 가중치를 0으로 설정한다. 간선을 따라 V2를 5로 설정한다.
그렇다면 V1 → V2의 결과가 무너진다.

이러한 문제가 생길 때마다 백트래킹을 치는 건 말이 안 된다고 생각해서 고민을 했으나 해결을 하지 못해 에디토리얼을 열어봤다.

> 각 간선에 대해 역방향 간선을 잇는다. 이 때 가중치는 기존 간선에서 부호를 바꾼다.
> 

![image.png](attachment:ca8a1656-7c3a-4e8c-be87-cbb008f007e8:image.png)

처음에 V1에서 출발해, 간선의 가중치 10을 따라 V2의 가중치를 10으로 설정한다.
V2에서 출발해, 간선의 가중치 -5를 따라 V3의 가중치를 5로 설정한다.

매번 느끼는 거지만, 이런 트릭을 볼 때마다 더이상 내가 아는 알고리즘이 아닌 것 같다.

```python
from collections import deque

# dst - src = w
# src + w = dst

V, E = map(int, input().split())
G = [[] for _ in range(V+1)]
for _ in range(E):
    src, dst, w = map(int, input().split())
    G[src].append((w, dst))
    G[dst].append((-w, src))  # 역방향 간선 및 가중치 부호 반대

cost = [0 for _ in range(V+1)]
visited = [False for _ in range(V+1)]
for v in range(1, V+1):
    if not visited[v]:
        visited[v] = True
        q = deque([v])
        while q:
            cur = q.popleft()
            for nxt_w, nxt_v in G[cur]:
                if not visited[nxt_v]:
                    visited[nxt_v] = True
                    cost[nxt_v] = cost[cur] + nxt_w
                    q.append(nxt_v)

for i in range(1, V+1):
    print(cost[i], end=" ")
\
```
