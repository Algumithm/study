from collections import deque

R, C = map(int, input().split())
matrix = [input() for _ in range(R)]

if matrix[0][0] != "s":
    print("No")
    exit()

visited = [[False for _ in range(C)] for _ in range(R)]
SNUKE = "snuke"

dq = deque()
dq.append((0, 0, 0))
visited[0][0] = True
dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

while dq:
    cr, cc, cl = dq.popleft()
    for i in range(4):
        nr, nc, nl = cr + dr[i], cc + dc[i], (cl + 1) % 5
        if not (0 <= nr < R and 0 <= nc < C):
            continue
        if visited[nr][nc]:
            continue
        if matrix[nr][nc] != SNUKE[nl]:
            continue
        visited[nr][nc] = True
        dq.append((nr, nc, nl))

if visited[-1][-1]:
    print("Yes")
else:
    print("No")
    
