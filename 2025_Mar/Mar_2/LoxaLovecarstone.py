

def solution(level: int, val: int, init: int, last: int):  # init -> start position, last -> last visited position
    global ans
    if val > ans:  # not promise
        return

    if level == N-1:  # back to start position
        res = val + matrix[last][init]
        ans = min(ans, res)
        return

    visited[last] = True
    for j in range(N):
        if not visited[j]:
            solution(level + 1, val + matrix[last][j], init, j)
    visited[last] = False


N = int(input())
matrix = [list(map(int, input().split())) for _ in range(N)]
for r in range(N):
    for c in range(N):
        if r != c and matrix[r][c] == 0:  # cannot go --> make weight as infinity
            matrix[r][c] = float("inf")
visited = [False for _ in range(N)]
ans = float("inf")
for i in range(N):
    solution(0, 0, i, i)

print(ans)
