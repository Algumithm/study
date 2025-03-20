import bisect

N, M, D = map(int, input().split())
A = list(set(map(int, input().split())))
B = list(set(map(int, input().split())))
A.sort()
B.sort()
# print(A)
# print(B)

N = len(A)
M = len(B)

ans = -1
for i in range(N):
    curvalue = A[i]
    left_limit = curvalue - D
    right_limit = curvalue + D

    leftpos = bisect.bisect_left(B, left_limit)
    rightpos = bisect.bisect_right(B, right_limit)

    if rightpos == M:
        if abs(curvalue - B[-1]) <= D:  # 제일 끝에 가도 한도를 초과히지 않는다면
            rightmax = curvalue + B[-1]  # 이 값이 최대일 것임
            ans = max(ans, rightmax)
    else:
        if B[rightpos] != right_limit:
            rightpos -= 1

        if leftpos <= rightpos:
            ans = max(ans, curvalue + B[rightpos])

print(ans)
