# 알고리즘

DP

# 난이도

배점: 400

AtCoder Problems: 720

# 링크

https://atcoder.jp/contests/abc291/tasks/abc291_d

# 접근 과정

무언가 큰 소수로 나누라는 것은 속임수일 수도 있지만, 많은 경우 DP이다. 점화식을 찾는 것이 흥미로웠다.

- 카드는 앞면과 뒷면으로 나뉘므로 0행을 앞면, 1행을 뒷면으로 생각하고 테이블을 만든다.
- 현재 상태의 앞면이 이전 상태의 앞면과 다르면, 이전 상태의 경우의 수를 그대로 활용할 수 있다.
- 현재 상태의 앞면이 이전 상태의 뒷면과 다르면, 이전 상태의 경우의 수를 그대로 활용할 수 있다.
- 이 논리는 현재 상태의 뒷면에도 똑같이 적용된다.
- 따라서 현재 앞면 = 이전 앞면+ 이전 뒷면, 현재 뒷면 = 이전 앞면 + 이전 뒷면의 점화식을 바탕으로 두 카드가 서로 다른지 같은지 확인하면 되었다.

```python
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

```
