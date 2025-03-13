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
        
