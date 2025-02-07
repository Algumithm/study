N, S = map(int, input().split())
arr = list(map(int, input().split()))
total = sum(arr)

remain = S % total
# print(remain)

brr = arr + arr
# print(*brr)

prefix = [0]
for i in range(len(brr)):
    prefix.append(prefix[-1] + brr[i])
# print(*prefix)

l = 0
r = 1
val = 0
while l <= r < len(prefix):
    val = prefix[r] - prefix[l]
    if val == remain:
        # print(l, r)
        print("Yes")
        exit()
    if val < remain:
        r += 1
    else:
        l += 1

print("No")
