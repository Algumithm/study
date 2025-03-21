# 알고리즘

DFS, BFS

# 난이도

배점: 400

AtCoder Problems: 619

# 링크

https://atcoder.jp/contests/abc308/tasks/abc308_d

# 접근 과정

그래프 문제는 언제나 “나 그래프요!” 하고 자랑할 때가 많아 마음에 든다. 이 문제는 좌상단에서 우하단까지 내려가는 데에 `SNUKE` 라는 글자를 따라서 진행해야 하므로 `현재 레벨 % 5` 를 하여 지도에 적힌 글자가 해당하는지를 확인하는 것으로 해결할 수 있었다.

```python
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
    
```
