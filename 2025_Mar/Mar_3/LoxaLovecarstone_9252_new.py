S = input()
T = input()
reconstruct = []

dp = [[0 for _ in range(len(T) + 1)] for _ in range(len(S) + 1)]
for r in range(1, len(S) + 1):
    i = r-1
    for c in range(1, len(T) + 1):
        j = c-1
        if S[i] == T[j]:
            dp[r][c] = dp[r-1][c-1] + 1
        else:
            if dp[r-1][c] >= dp[r][c-1]:
                dp[r][c] = dp[r-1][c]
            else:
                dp[r][c] = dp[r][c-1]


lastrow = len(S)
lastcol = len(T)

if dp[-1][-1] == 0:
    print(0)
    exit()

while dp[lastrow][lastcol] != 0:
    current = dp[lastrow][lastcol]
    lookup = dp[lastrow-1][lastcol]
    lookleft = dp[lastrow][lastcol-1]
    if current == lookleft:
        lastcol -= 1
    elif current == lookup:
        lastrow -= 1
    else:
        reconstruct.append(S[lastrow-1])
        lastrow -= 1
        lastcol -= 1

print(len(reconstruct))
# print(reconstruct)
ans = "".join(reversed(reconstruct))
print(ans)
