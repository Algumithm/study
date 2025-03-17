def get_candidates(level: int, A: list) -> None:
    if level == N:
        candidates.append(A)
        return

    get_candidates(level + 1, A + [0])
    get_candidates(level + 1, A + [1])


candidates = []
N, T, K = map(int, input().split())
get_candidates(0, [])

conditions = []
for _ in range(T):
    cnt, *keys, flag = input().split()
    keys = list(map(lambda x: int(x) - 1, keys))  # 1-based index를 0-based로 변환
    conditions.append((keys, int(cnt), flag))

valid_count = 0
for candidate in candidates:  # 2 ** 15
    valid = True
    for keys, cnt, flag in conditions:  # 100
        keycnt = 0
        for k in keys:  # 15
            if candidate[k]:
                keycnt += 1
        if (keycnt >= K and flag == "x") or (keycnt < K and flag == "o"):
            valid = False
            break
    if valid:
        valid_count += 1

print(valid_count)
