# 알고리즘

Binary Search

# 난이도

배점: 400

AtCoder Problems: 682

# 링크

https://atcoder.jp/contests/abc302/tasks/abc302_d

# 접근 과정

처음에는 정렬한 다음 투 포인터로 접근했다. WA 판정을 받아서 고민했더니 투 포인터 특성 상 모든 경우를 탐색하는 것은 아니기에 진행하는 과정에서 다른쪽 포인터를 이동시키는 것이 이득인 경우가 존재할 수도 있겠다고 판단해서 버렸다.

```python
N, M, D = map(int, input().split())
A = list(set(list(map(int, input().split()))))
B = list(set(list(map(int, input().split()))))
A.sort()
B.sort()
# print(A)
# print(B)

N = len(A)
M = len(B)
ptr_A = 0
ptr_B = 0

best = -1
while ptr_A < N and ptr_B < M:
    diff = A[ptr_A] - B[ptr_B]

    if abs(diff) <= D:
        best = max(best, A[ptr_A] + B[ptr_B])

    if diff < 0:
        ptr_A += 1
    else:
        ptr_B += 1

if ptr_A < N and ptr_B == M:
    while ptr_A < N:
        remaindiff = B[-1] - A[ptr_A]
        if abs(remaindiff) <= D:
            best = max(best, B[-1] + A[ptr_A])
        ptr_A += 1
elif ptr_A == N and ptr_B < M:
    while ptr_B < M:
        remaindiff = A[-1] - B[ptr_B]
        if abs(remaindiff) <= D:
            best = max(best, A[-1] + B[ptr_B])
        ptr_B += 1

print(best)

```

그리고 떠올린 것은 이분 탐색이었다. A의 어떤 원소에서 차이 D를 더한 값인 A+D를 넘지 않는 가장 큰 B의 원소를 더하는 것이 해당 A의 원소로 얻을 수 있는 최대 이익이다. 이 과정은 B를 정렬하는 것, 그리고 A의 모든 원소에 대해 B를 대상으로 하여 이분 탐색을 실시하므로 총 시간복잡도는 `O(NlogM + MlogM)` 이다. 

AC를 받은 코드이지만 다듬을 필요가 있어 보인다.

```python
import bisect

N, M, D = map(int, input().split())
A = list(set(map(int, input().split())))
B = list(set(map(int, input().split())))
A.sort()
B.sort()
# print(A)
# print(B)

N = len(A)
M = len(B)

ans = -1
for i in range(N):
    curvalue = A[i]
    left_limit = curvalue - D
    right_limit = curvalue + D

    leftpos = bisect.bisect_left(B, left_limit)
    rightpos = bisect.bisect_right(B, right_limit)

    if rightpos == M:
        if abs(curvalue - B[-1]) <= D:  # 제일 끝에 가도 한도를 초과히지 않는다면
            rightmax = curvalue + B[-1]  # 이 값이 최대일 것임
            ans = max(ans, rightmax)
    else:
        if B[rightpos] != right_limit:
            rightpos -= 1

        if leftpos <= rightpos:
            ans = max(ans, curvalue + B[rightpos])

print(ans)

```
