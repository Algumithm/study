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
