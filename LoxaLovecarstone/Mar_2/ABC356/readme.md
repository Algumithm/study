# 알고리즘

Bruteforce

# 난이도

배점: 300

AtCoder Problems: 568

# 링크

https://atcoder.jp/contests/abc356/tasks/abc356_c

# 접근 과정

문제를 읽고 떠올린 접근 과정은 조합론이었다. 입력 예제를 예로 들어보자. 

```
11 4 9
10 1 2 3 4 5 6 7 8 9 10 o
11 1 2 3 4 5 6 7 8 9 10 11 o
10 11 10 9 8 7 6 5 4 3 2 x
10 11 9 1 4 3 7 5 6 2 10 x
```

첫 번째 줄과 두 번째 줄에서, o의 교집합이 아닌 열쇠는 가짜라고 확정할 수 있다.

첫 번째 줄과 세 번째 줄에서, o - x의 원소인 1은 반드시 필요하다고 확정할 수 있다.

같은 논리로 첫 번째 줄과 네 번째 줄에서 8은 반드시 필요하다고 확정할 수 있다.

따라서 11개의 열쇠 중 3개는 확정된다. 남은 8개의 열쇠인 2, 3, 4, 5, 6, 7, 9, 10 중 9 - 2 = 7개의 열쇠를 고르면 된다. 따라서 답은 8이다.

WA Verdict을 받았으니 논리가 잘못된 거겠지만, 아주 틀린 논리는 아니었기에 무언가 더 고려하지 못한 사항이 있는가 하고 한참을 붙잡다가 포기하고 에디토리얼을 열어보았다.

에디토리얼은 브루트포스였다.

> 열쇠 15개를 적절히 고르는 문제이다. 열쇠가 옳은 열쇠인가 필요 없는 열쇠인가를 따지는 모든 경우는 2 ** 15 = 32768이다. 이 경우에 대해서 모든 M개의 케이스와 모순이 없으면 해당 경우는 가능하다. 따라서 32768 * 100 = 3276800 이므로 충분히 접근 가능하다.

모순에는 두 종류가 있다. 첫 번째 모순은 올바른 열쇠를 K개 미만만큼 끼웠음에도 문이 열리는 경우이다. 두 번째 모순은 올바른 열쇠를 K개 이상을 끼웠음에도 문이 열리지 않는 경우이다.
> 

입력 예시와 함께 이해해보자.

```
3 2 2
3 1 2 3 o
2 2 3 x

```

이 때 열쇠가 (0, 0, 0) 즉 모두 필요 없는 열쇠라고 가정해보자. 그렇다면 첫 번째 줄에서 옳은 열쇠가 0개 꽂혔으므로 문이 열려서는 안 된다. 그런데 문이 열렸으므로 이것은 불가능하다.

마찬가지로 열쇠가 (1, 0, 0) 즉 1번만 필요하다고 해보자. 그러면 첫 번째 줄에서 옳은 열쇠가 1개 꽂혔으므로 문이 열려서는 안 되지만 문이 열렸으므로 모순이다.

만약 열쇠가 (0, 1, 1) 즉 2와 3만 옳은 열쇠라고 해보자. 첫 번째 줄에서는 2개의 열쇠가 맞았으므로 문이 열렸다. 그런데 두 번째 줄에서 역시 2개의 열쇠가 맞았으므로 문이 열려야하지만 문이 열리지 않았다. 이것은 불가능하다.

열쇠가 (1, 1, 1) 즉 모두 옳은 열쇠라고 해보자. 그러면 두 번째 라인에서 2개의 옳은 열쇠가 들어갔으므로 문이 열려야하지만 열리지 않았으므로 모순이다.

```python
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

```
