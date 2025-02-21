import bisect

N = int(input())
S = input()

l = -1
r = -1
pos = []
for i in range(N):
    if S[i] == "1":
        r = i
        if l == -1:
            l = i
        pos.append(i)

# print(l, r) 시작 위치와 끝 위치를 계산한다.
# print(pos)

ans = 0
for j in range(l, r):
    if S[j] == "0":
        x = bisect.bisect_left(pos, j)
        # print(x)
        ans += min(x, len(pos) - x)

print(ans)
