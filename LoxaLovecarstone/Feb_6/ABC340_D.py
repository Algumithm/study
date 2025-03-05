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
