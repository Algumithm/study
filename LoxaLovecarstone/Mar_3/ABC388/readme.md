# 알고리즘

Prefix Sum, Imos

# 난이도

배점: 400

AtCoder Problems: 659

# 링크

https://atcoder.jp/contests/abc388/tasks/abc388_d

# 접근 과정

문제를 비틀어서 생각하는 것까지는 했다. 문제에서는 선물을 “받는다”고 했지만, 받는 선물은 결국 이전 외계인이 “주어야” 받을 수 있는 것이기 때문에 주는 것에 초점을 맞추었다.

각 외계인은 다음 외계인이 나이를 먹을 때마다 자신이 가진 선물을 주어야 한다. 그러므로 가진 게 있다면 다 주되, 남은 외계인 수가 내가 가진 선물의 수보다 작다면 다 줄 필요가 없다. 이 부분은 `min(arr[i], (N-1) - i` 로 생각할 수 있었다.

그런데 내가 가진 선물은 내 앞사람이 주는 것에 따라 늘어난다. 이것을 처리하는 것이 문제의 핵심이었다. 내가 받는 선물은 앞사람들이 준 모든 선물의 합이므로 누적합 및 imos를 떠올리기까지는 했으나 업데이트를 제대로 처리하지 못해 WA 판정을 받았다.

```python
N = int(input())
arr = list(map(int, input().split()))
imos = [0 for _ in range(N+1)]
cnt = 0  # 내 이전 사람한테 받은 개수
for i in range(N-1):  # 마지막 사람은 따로 마크할 것이 없음
    # print(cnt)
    i_will_give = min(arr[i] + cnt, (N-1) - i)  # 나는 내가 가진 것과 앞으로 줄 사람만큼 중 작은 숫자만큼 줄 수 있음
    if i_will_give:  # 내가 줄 것이 있다면
        imos[i+1] += 1  # 내 다음사람에게 줄 수 있다고 표시해주고
        imos[i+i_will_give+1] -= 1  # 어디까지 줄 수 있는지도 마크함
        if imos[i+1] != 0:  # 내 영향력이 미칠 수 있다면 
            cnt += 1  # 영향력을 전파함 << 이 부분이 잘못된 로직임
    # print(imos)

cur = 0
for i in range(N):
    cur += imos[i]
    arr[i] += cur

# print(*arr)
for i in range(N):
    lost = (N-1) - i
    arr[i] = max(0, arr[i] - lost)
print(*arr)

```

에디토리얼의 접근 과정은 나와 다르지 않았으나, 업데이트를 하는 과정을 하나의 반복문 안에서 해결했다. 즉 내가 가진 선물의 양을 imos를 활용해 먼저 업데이트한 다음에, 줘야하는 만큼 내가 가진 선물을 감소시키고, 또 그만큼 imos를 갱신하였다.

GPT가 CPP에서 Python으로 번역한 에디토리얼 코드는 아래와 같다.

```python
N = int(input())
arr = list(map(int, input().split()))

# imos: 차분 배열 (길이 N+1)
imos = [0] * (N + 1)
# recv: 현재까지 받은 돌의 누적합
recv = 0

for i in range(N):
    if i != 0:  # 첫 외계인은 줄 것이 없으므로 조건을 걸어줌
        # 이전 외계인들로부터 받은 돌의 누적합을 갱신
        recv += imos[i]
        arr[i] += recv  # 원래 가지고 있던 돌에 누적 받은 돌을 더함

    # i번째 외계인이 줄 수 있는 돌의 개수는 남은 외계인 수와 현재 보유 돌 개수 중 작은 값
    give = min(N - i - 1, arr[i])
    arr[i] -= give  # 본인의 돌에서 줄 돌의 개수를 차감

    if give > 0:  # 내가 줄 돌이 있다면
        imos[i + 1] += 1  # 다음 외계인부터
        imos[min(N, i + give + 1)] -= 1  # 그 돌의 개수만큼(물론 돌이 더 많더라도 N번보다 많이는 불가능) 전파할 수 있음.

# 최종 결과 출력
print(*arr)

```

이를 바탕으로 이해한 내 코드는 아래와 같다.

```python
N = int(input())
arr = list(map(int, input().split()))
imos = [0 for _ in range(N+1)]
stone = 0

for i in range(N):
    if i != 0:  # 가장 첫 번째 녀석은 받을 수 없음
        stone += imos[i]  # imos 값을 더해준 다음
        arr[i] += stone  # 변화를 받음

    give = min(arr[i], (N-1) - i)  # 가진 모든 것을 털어내지만, 제일 끝사람까지만 주면 됨
    arr[i] -= give

    if give > 0:  # 만약 줬다면
        imos[i+1] += 1  # 다음 사람부터 받을 수 있고
        dist = min(give, N-1)  # 주는 양만큼, 혹은 마지막 외계인까지 그 영향력이 행사됨
        imos[i + dist + 1] -= 1  # 영향력을 다 행사하면 끝났다고 마크함

print(*arr)

```
