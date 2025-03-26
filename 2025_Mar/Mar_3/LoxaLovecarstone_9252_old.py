S1 = input()
S2 = input()
LCS_dp = [[0 for _ in range(len(S1)+1)] for _ in range(len(S2)+1)]
LCS_bool = [[False for _ in range(len(S1)+1)] for _ in range(len(S2)+1)]
# print(LCS_dp)
# print(LCS_bool)

for level in range(1, len(S2) + 1):
    idx_2 = level - 1
    for c in range(1, len(S1) + 1):
        idx_1 = c - 1
        if S2[idx_2] == S1[idx_1]:
            LCS_dp[level][c] = max(LCS_dp[level-1][c], LCS_dp[level-1][c-1] + 1)
            LCS_bool[level][c] = True
        else:
            LCS_dp[level][c] = max(LCS_dp[level - 1][c], LCS_dp[level][c-1])

# for i in range(1, 7):
#     subarr1 = LCS_dp[i]
#     subarr2 = LCS_bool[i]
#     print(*subarr1)
#     print(*subarr2)

tmp = ""
backidx1 = len(S1)  # column
backidx2 = len(S2)  # row
while backidx1 != 0 and backidx2 != 0:  # 둘중 하나라도 0번 라인에 도달하면 끝남
    if LCS_bool[backidx2][backidx1]:  # 해당 문자가 LCS에 포함
        tmp += S2[backidx2 - 1]
        backidx2 -= 1
        backidx1 -= 1

    else:  # 해당 문자가 LCS에 포함되지 않음
        if LCS_dp[backidx2-1][backidx1] > LCS_dp[backidx2][backidx1-1]:  # 왼쪽으로 가는 값이 위로 가는 값보다 크다면
            backidx2 -= 1
        else:
            backidx1 -= 1

ans = ""
for i in range(len(tmp) - 1, -1, -1):
    ans += tmp[i]
print(LCS_dp[-1][-1])
print(ans)
