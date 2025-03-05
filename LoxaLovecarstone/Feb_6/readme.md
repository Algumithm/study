# 알고리즘

Dijkstra

# 난이도

배점: 425

AtCoder Problems: 784

# 링크

https://atcoder.jp/contests/abc340/tasks/abc340_d

# 접근 과정

문제를 읽고 “무슨 지문이지…?” 하고 잠깐 이해하지 못했다. 조금 읽어보니 평범한 데이크스트라여서 막힘 없이 구현했다. 아무리 생각해도 https://atcoder.jp/contests/abc373/tasks/abc373_d 이 문제보다 쉬운데 배점이나 AtCoder Problems 난이도가 더 높은 이유를 잘 모르겠다. 아마 지문에서 정점과 간선이라는 정보를 제공하지 않아 어렵게 느꼈던 사람이 많았던 것 같다.

```python
import heapq

V = int(input())
G = [[] for _ in range(V+1)]

for i in range(1, V):
    A, B, X = map(int, input().split())  # i becomes src
    G[i].append((A, i+1))  # weight, dst
    G[i].append((B, X))

# print(G)

dist = [float("inf") for _ in range(V+1)]
dist[1] = 0
q = [(0, 1)]
while q:
    cur_w, cur_v = heapq.heappop(q)
    for nxt_w, nxt_v in G[cur_v]:
        if dist[cur_v] + nxt_w < dist[nxt_v]:
            dist[nxt_v] = dist[cur_v] + nxt_w
            heapq.heappush(q, (dist[nxt_v], nxt_v))

print(dist[-1])

```
