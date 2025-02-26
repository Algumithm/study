from copy import deepcopy

N = int(input())
start = {}
nxt = {}

start[N] = 1
ans = 0
while start:  # 딕셔너리에 내용물이 있는 동안 반복
    for k, v in start.items():
        ans += k * v  # 해당 값이 몇 개나 있는지?
        if k % 2 == 0:
            mid = k // 2
            if mid != 1:  # 1은 더이상 연산에 필요하지 않음
                if not mid in nxt:
                    nxt[mid] = v * 2
                else:
                    nxt[mid] += v * 2
        else:  # 홀수면, 예를 들어 25는 13과 12로 나뉨.
            left = k // 2 + 1
            right = k // 2

            if left != 1:
                if not left in nxt:
                    nxt[left] = v
                else:
                    nxt[left] += v

            if right != 1:
                if not right in nxt:
                    nxt[right] = v
                else:
                    nxt[right] += v

    start = deepcopy(nxt)
    nxt.clear()

print(ans)
