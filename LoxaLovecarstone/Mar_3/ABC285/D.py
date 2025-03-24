from collections import deque


N = int(input())
unused = 0
G = {}
word2num = {}
for _ in range(N):
    dst, src = input().split()
    if dst not in word2num:
        word2num[dst] = unused
        unused += 1
    if src not in word2num:
        word2num[src] = unused
        unused += 1

    dst2num = word2num[dst]
    src2num = word2num[src]

    if src2num not in G:
        G[src2num] = [dst2num]
    else:
        G[src2num].append(dst2num)

indegree = [0 for _ in range(len(word2num))]
visited = [False for _ in range(len(word2num))]
# print(indegree)

for k, v in G.items():
    for vertex in v:
        indegree[vertex] += 1
# print(indegree)


q = deque()
for i, deg in enumerate(indegree):
    if not deg:
        q.append(i)
        visited[i] = True

while q:
    cur = q.popleft()
    if cur in G.keys():
        for adj in G[cur]:
            indegree[adj] -= 1
            if not indegree[adj]:
                visited[adj] = True
                q.append(adj)

# print(indegree)

print("Yes" if all(not v for v in indegree) else "No")
