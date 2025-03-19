N = int(input())
arr = list(map(int, input().split()))
imos = [0 for _ in range(N+1)]
stone = 0

for i in range(N):
    if i != 0:  # 가장 첫 번째 녀석은 받을 수 없음
        stone += imos[i]  # imos 값을 더해준 다음
        arr[i] += stone  # 변화를 받음

    give = min(arr[i], (N-1) - i)  # 가진 모든 것을 주거나, 제일 끝사람에게 하나씩 주거나
    arr[i] -= give

    if give > 0:  # 만약 줬다면
        imos[i+1] += 1  # 다음 사람부터 받을 수 있고
        dist = min(give, N-1)  # 주는 양 혹은 끝까지
        imos[i + dist + 1] -= 1

print(*arr)
