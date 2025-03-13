# 알고리즘

Parametric Search

# 난이도

배점: 400

AtCoder Problems: 631

# 링크

https://atcoder.jp/contests/abc319/tasks/abc319_d

# 접근 과정

지문을 읽고 굉장히 난해했다. 이걸 어떻게 구하는 거지라고 하면서. 그런데 경험상 “최대값 중 최소값” 이나 “최소값 중 최대값” 등의 지문이 있으면 많은 경우 파라메트릭 서치였고, 그렇게 생각을 해보니 파라메트릭으로 접근이 가능할 것이라고 생각했다.

즉 현재 화면의 폭이 충분히 넓어 줄의 수가 적당하다면 폭을 줄일 수 있는지 검토하고, 반대로 폭이 좁아서 줄이 넘쳐버린다면 폭을 넓힐 필요가 있다.

단, 문자열의 길이가 폭보다 크다면 비교할 필요도 없이 폭을 늘려야한다는 예외가 존재하는 상황과, 띄어쓰기를 어떻게 처리할 것인지도 고려해야해서 조금 까다로웠다.

```python
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

```
