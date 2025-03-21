S = input()
T = input()

dp = [[0 for _ in range(len(S) + 1)] for _ in range(len(T) + 1)]

for r in range(0, len(T)):
    for c in range(0, len(S)):
        if T[r] == S[c]:
            dp[r+1][c+1] = max(dp[r+1][c], dp[r][c+1], dp[r][c] + 1)
        else:
            dp[r+1][c+1] = max(dp[r+1][c], dp[r][c+1])

ans = dp[-1][-1]
print(ans)
