from collections import deque


R, C = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(R)]
visited = [[float("inf") for _ in range(C)] for _ in range(R)]  # init with infinity
sr, sc = -1, -1  # starting row, starting column
for r in range(R):  # finding the starting point
    for c in range(C):
        if matrix[r][c] == 2:
            sr, sc = r, c

# BFS
dq = deque()  # there is no queue in python; only deque
visited[sr][sc] = 0
dq.append((sr, sc, 0))
dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]
while dq:
    cr, cc, cl = dq.popleft()  # current row, current column, current level
    for i in range(4):
        nr, nc = cr + dr[i], cc + dc[i]  # next row, next column
        if not (0 <= nr < R and 0 <= nc < C):  # out of bound
            continue
        if matrix[nr][nc] == 0:  # wall
            continue
        if visited[nr][nc] != float("inf"):  # already visited
            continue
        visited[nr][nc] = cl + 1  # next level
        dq.append((nr, nc, cl + 1))

for r in range(R):
    for c in range(C):
        if visited[r][c] == float("inf"):  # not visited
            if matrix[r][c] == 0:  # cannot go because it's wall
                print(0, end=" ")
            else:  # cannot go even though it's NOT wall
                print(-1, end=" ")
        else:
            print(visited[r][c], end=" ")
    print()
