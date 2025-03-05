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
