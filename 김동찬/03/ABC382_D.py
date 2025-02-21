N, M = map(int, input().split())
res = []


def solution(level: int, A: list):
    if level == N:
        res.append(A)
        return

    if not A:  # 레벨 0에서 빈 배열이 호출됨
        START = 1  # 당연히 1부터 시도할 수 있음
    else:  # 레벨 1부터는 마지막으로 입력된 값보다 10 이상을 유지해야함
        START = A[-1] + 10
    LIMIT = M - 10 * (N-level-1)  # 유망성 계산.
    # 예를 들어 33까지 도달해야 하고 아직 레벨이 2개 남았다면
    # 13까지만 호출을 시도해 13 -> 23 -> 33의 경로가 가능해진다. 
    for i in range(START, LIMIT+1):
        solution(level + 1, A + [i])


solution(0, [])

print(len(res))
for item in res:
    print(*item)
