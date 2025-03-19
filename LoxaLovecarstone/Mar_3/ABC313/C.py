N = int(input())
arr = list(map(int, input().split()))
arr.sort()

# print(arr)
total = sum(arr)

quotinent = total // N
remain = total % N

destination = [quotinent for _ in range(N)]
for i in range(N-1, -1, -1):
    if not remain:
        break
    destination[i] += 1
    remain -= 1
# print(destination)

ans = 0
l = 0
r = N - 1
while l <= r:
    ldiff = destination[l] - arr[l]
    rdiff = arr[r] - destination[r]
    if ldiff == rdiff:
        ans += ldiff
        arr[l] = destination[l]
        arr[r] = destination[r]
        l += 1
        r -= 1
    elif ldiff > rdiff:
        ans += rdiff
        arr[r] = destination[r]
        r -= 1
        arr[l] += rdiff
    else:  # ldiff < rdiff
        ans += ldiff
        arr[l] = destination[l]
        l += 1
        arr[r] -= ldiff

print(ans)
