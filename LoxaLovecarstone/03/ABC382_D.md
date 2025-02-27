# 알고리즘

Recursive, Bruteforce

# 난이도

배점: 425

AtCoder Problems: 685

# 링크

https://atcoder.jp/contests/abc382/tasks/abc382_d

# 접근 과정

문제를 보자마자 재귀함수를 호출하면서 백트래킹을 치면 답을 얻을 수 있을 것이라 확신했다. 그런데 백트래킹을 치기에는 호출되는 것이 너무 많아서 TLE를 받고 고민하게 되었다.

또 재귀함수를 호출하려고 하니 레벨 0에서 반복문으로 호출하면 코드가 꼬일 것 같아 레벨 0일 때 어떻게 시작해야하는지를 고민했다.

진행해야하는 레벨과 그 때 도달할 수 있는 최댓값이 초기에 주어지므로 현재 조사 중인 상태공간트리에서 값, 레벨을 바탕으로 유망성을 계산할 수 있다. 따라서 호출하고 유망하지 않은 것을 제거하는 것이 아니라 유망한 것들만 호출하도록 하였다.

```python
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
```
