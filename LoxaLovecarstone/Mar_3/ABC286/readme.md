# 알고리즘

DP

# 난이도

배점: 400

AtCoder Problems: 607

# 링크

https://atcoder.jp/contests/abc286/tasks/abc286_d

# 접근 과정

DP문제인 것은 바로 알 수 있었다. 그리고 전체 경우의 수를 구하는 것이 아니라 가능한지 아닌지만 판별하면 되므로 DP 테이블을 0 아니면 1로 채우고자 했다.

이 문제에서 포인트는 해당 가치의 동전이 무제한으로 있는 것이 아니라 일정 개수만큼만 있다. 따라서 각 레벨마다 DP 테이블을 채울 때 동전의 가치만큼 건너뛰는 동시에 어디까지 갈 수 있는지도 체크해줘야 했다.

DP테이블을 채우는 경우는

- 조사하고 있는 금액이 이전 상태에서 가능했을 경우에는 현재 동전을 소모하지 않고도 그대로 가능하다
- 조사하고 있는 금액이 이전 상태에서 불가능했을 경우, 이전 상태에서 조사하고 있는 금액을 뺀 상태에서 가능했다면 현재 동전을 소모하고 가능하다
- 이전 상태와 무관하게 현재 상태로만으로도 도달할 수 있다.

로 정리할 수 있다.

```python
N, X = map(int, input().split())
coins = [(-1, -1)] + [tuple(map(int, input().split())) for _ in range(N)]

dp = [[0 for _ in range(X+1)] for _ in range(N+1)]

for level in range(1, N+1):
    price, cnt = coins[level]
    for c in range(1, X+1):
        if dp[level-1][c]:  # 이전에 아무런 조치를 취하지 않고 가능했다면
            dp[level][c] = 1  # 현재도 당연히 가능할 것임
        else:  # 이전에 아무런 조치를 취하지 않고는 불가능하다면, 무언가 조치를 취해볼 것임
            for use in range(1, cnt + 1):  # 동전은 1개 이상 cnt 이하 사용 가능함
                prev = use * price  # 이만큼 뒤로 돌아갈 것임
                if 0 <= prev <= X:
                    dp[level][prev] = 1  # 현재 이 금액을 쓴 건 당연히 가능함
                if c - prev >= 0:  # 뒤로 돌아간 곳이 바운더리를 벗어나지 않고
                    if dp[level-1][c-prev]:  # 이전에 가능했다던 기록이 남아있으면
                        dp[level][c] = 1  # 이전 상태로부터 지금 가능하다고 결론을 이끌어낼 수 있음
                else:  # 바운더리를 벗어난다면
                    pass  # 뭐 어쩔 수 있나 안 되는 거지

print("Yes" if dp[-1][-1] else "No")

```
