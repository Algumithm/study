N = int(input())
cards = [tuple(map(int, input().split())) for _ in range(N)]

dp = [[0 for _ in range(N)] for _ in range(2)]
dp[0][0] = 1
dp[1][0] = 1

for c in range(1, N):
    current_front = cards[c][0]
    current_back = cards[c][1]
    prev_front = cards[c-1][0]
    prev_back = cards[c-1][1]

    if current_front != prev_front:
        dp[0][c] += dp[0][c-1]
    if current_front != prev_back:
        dp[0][c] += dp[1][c-1]
    if current_back != prev_front:
        dp[1][c] += dp[0][c-1]
    if current_back != prev_back:
        dp[1][c] += dp[1][c-1]

    dp[0][c] %= 998244353
    dp[1][c] %= 998244353

# print(dp)
ans = 0
for subarr in dp:
    ans += subarr[-1]

print(ans % 998244353)
