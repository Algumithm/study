# 알고리즘

Prefix Sum, Binary Search, Greedy

# 난이도

배점: 400

AtCoder Problems: 602

# 링크

https://atcoder.jp/contests/abc334/tasks/abc334_d

# 접근 과정

문제를 읽자마자 든 생각은 “사슴의 수가 정해져있다면 최대한 많은 썰매를 끌기 위해서는 가벼운 썰매부터 끌지 않을 이유가 없다”였다. 그렇다면 몇 개나 끌 수 있을까?

쿼리를 처리해야 하므로 매순간 `사슴의 수 - 각 썰매에 필요한 사슴 수` 를 계산하는 것은 TLE가 날 것임이 분명했으므로 누적 합을 적용했다. 이후 누적합 배열에 이분 탐색을 실행하여 몇 개까지 끌 수 있는지 조사하였다.

```python
import bisect

N, Q = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
prefix = [0]
for i in range(N):
    prefix.append(prefix[-1] + arr[i])

for _ in range(Q):
    q = int(input())
    pos = bisect.bisect_left(prefix, q)

    if pos == N+1:  # 모든 썰매를 끌 수 있는 경우
        print(N)
    elif prefix[pos] == q:  # 정확히 계산이 맞아떨어지는 있는 경우
        print(pos)
    else:  # 그 이외의 경우
        print(pos-1)
        
```
