N, K = map(int, input().split())
arr = tuple(map(int, input().split()))
l = 1
r = sum(arr) + len(arr) - 1
# print(r)

ans = float("inf")
while l <= r:
    mid = (l + r) // 2
    rowcnt = 0
    current_length = 0

    # 만약 arr[i]가 mid보다 크다면 절대 불가능하고 폭을 늘려야 함
    impossible = False
    for v in arr:
        if v > mid:
            impossible = True
    if impossible:
        l = mid + 1
        continue

    for i in range(len(arr)):
        nxt = current_length + arr[i]
        if nxt == mid:
            rowcnt += 1
            current_length = 0
        elif nxt < mid:
            current_length = nxt
            current_length += 1  # space
        else:  # nxt > mid:
            rowcnt += 1
            current_length = arr[i]  # init with row
            current_length += 1  # space

    if current_length:
        rowcnt += 1

    if rowcnt <= K:  # 열이 제한조건을 만족한다면 폭을 좁히고 재탐색해봄
        r = mid - 1
        ans = min(ans, mid)
    else:  # rowcnt > K
        l = mid + 1

print(ans)
