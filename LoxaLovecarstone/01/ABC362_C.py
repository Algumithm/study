N = int(input())
L = []
R = []
lsum = 0
rsum = 0
for i in range(N):
    l, r = map(int, input().split())
    lsum += l
    rsum += r
    L.append(l)
    R.append(r)

if (lsum > 0) or (rsum < 0):
    print("No")
    exit()

target = 0
rollback = []
res = [0 for _ in range(N)]
for i in range(N):
    tmp = L[i]
    L[i] -= tmp
    R[i] -= tmp
    target -= tmp
    rollback.append(tmp)

# print(*L)
# print(*R)
# print(target)
# print(rollback)

for j in range(N):
    res[j] = min(target, R[j])
    target -= res[j]

# print(*res)
for k in range(N):
    res[k] += rollback[k]

print("Yes")
print(*res)
