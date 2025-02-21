# ABC 362: C - Sum = 0

# 알고리즘

Greedy, Number Theroy

# 난이도

Points: 350

AtCoder Problems: 521

# 링크

[https://atcoder.jp/contests/abc362/tasks/abc362_c](https://atcoder.jp/contests/abc362/tasks/abc362_c)

# 접근 과정

접근조차 할 수 없었다. 아무것도 떠오르지 않아 에디토리얼을 읽었다.

에디토리얼은 힌트를 제공했다.

> 0부터 시작하는 정수 구간이 여럿 주어질 때, 각 구간에서 적당히 하나씩 골라 합을 S로 만들 수 있는가? 예를 들어, 정수 구간 [0, 5], [0, 6], [0, 7]에서 적당히 정수를 하나씩 골라 그 합을 15로 만들 수 있는가?

  만약 합으로 만들어야하는 수가 음수라면 절대 불가능함이 자명하다. 같은 이유로 각 구간에서 최대값을 골라 더한 값보다 큰 수(위 예시에서는 100)를 만드는 것은 절대 불가능하다. 그렇다면 반대로, 합으로 만들어야 하는 정수가 [0, SUM(R)] 구간에 존재한다면 만들 수 있을까?

  이는 그리디하게 증명 가능하다. 예를 들어서 합을 15를 만들어야 한다고 해보자. 15에서 제1구간의 최대값 5를 제거하면 10이 남는다. 여기서 제2구간의 최대값 6을 제거하면 4가 남는다. 마지막으로 4는 제3구간에서 선택 가능하므로 4를 고르면 된다.

  합을 S라고 했을 때, 각 구간에 대해서 S에서 min(S, L)을 빼나가면 그 수를 만들 수 있다. 반대로 min(S, R)을 빼나가도 해당 합을 이루는 조합을 찾을 수 있다.
> 

정답 코드는 읽어도 이해가 가지 않아, 이 힌트를 바탕으로 구현을 했다. 

> SUM(L) 이 S보다 크거나, SUM(R)이 S보다 작다면 불가능함이 자명하다.

이제 문제를 힌트에 따라서 환원한다. 구간 [L, R]에서 -L을 적용해 [0, R-L]로 만든다. S에도 매번 -L을 적용하여 목표값을 바꾼다. 이는 나중에 다시 되돌려줘야하므로 바꿔야할 값을 저장해준다.

증명된 것대로 선택해야 할 것들을 저장한 다음, 되돌려준다.
> 

```python
N = int(input())
L = []
R = []
lsum = 0
rsum = 0
for i in range(N):
    l, r = map(int, input().split())
    lsum += l
    rsum += r
    L.append(l)
    R.append(r)

if (lsum > 0) or (rsum < 0):
    print("No")
    exit()

target = 0
rollback = []
res = [0 for _ in range(N)]
for i in range(N):
    tmp = L[i]
    L[i] -= tmp
    R[i] -= tmp
    target -= tmp
    rollback.append(tmp)

# print(*L)
# print(*R)
# print(target)
# print(rollback)

for j in range(N):
    res[j] = min(target, R[j])
    target -= res[j]

# print(*res)
for k in range(N):
    res[k] += rollback[k]

print("Yes")
print(*res)

```
