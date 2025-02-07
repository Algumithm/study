# ABC 384: D - Repeated Sequence

# 알고리즘

Prefix Sum, Two Pointer

# 난이도

배점: 400

AtCoder Problems: 666

# 링크

[https://atcoder.jp/contests/abc384/tasks/abc384_d](https://atcoder.jp/contests/abc384/tasks/abc384_d)

# 접근 과정

연속된 구간을 골라야한다는 지문을 보고 떠올린 것은 투 포인터였다. 무한순열이므로 나머지 연산을 사용해 반복되게 하면서 현재까지의 합이 목표와 비교해 어떤지에 따라 l과 r을 적절히 옮겨주면 될 거라고 생각했다. 

```python
N, S = map(int, input().split())
arr = tuple(map(int, input().split()))

l = 0
r = 0
val = 0
visited = set()
while l <= r:
    if val == S:
        print("Yes")
        exit()

    if (l % N, r % N, val) in visited:
        break
    visited.add((l % N, r % N, val))
    if val < S:
        val += arr[r % N]
        r += 1
    else:
        val -= arr[l % N]
        l += 1

print("No")

```

문제는 시간복잡도였다. A = [1] 이라고 하고, 목표 값이 최대인 10**18이라면 이 횟수만큼 계산을 해야하므로 절대 AC를 받을 수 없다.

무한순열이라는 점이 접근 과정을 떠올릴 때 장애물이었지만, 에디토리얼에는 오히려 무한순열인 점을 활용해서 문제를 풀었다.

> 어떤 순열이 주어지든 그 순열의 합만큼은 언제나 계산할 수 있음이 자명하다. 그렇다면 목표값을 순열의 합으로 나눈 나머지(목표값에서 순열의 합만큼은 얼마든지 뺄 수 있으므로)를 어떻게 처리할 것인가? 예제 입력으로는 [3, 8, 4] 구간으로 15를 만들어야 한다. 이는 3 + 8 + 4이므로 가능하다.

그러면 만약에 [3, 8, 4] 구간으로 7을 만들어야 한다면 어떨까? 무한순열이 아니라면 3 + 8 = 11, 8 + 4 = 12, 3 + 8 + 4 = 15이므로 7이 될 수 없다. 하지만 4 + 3 = 7 로 계산하다. 즉 구간을 [8, 4, 3]이 반복되는 것이나 [4, 3, 8] 이라고 생각한 다음 투 포인터를 돌리면 7이 계산된다.

다시 말해, 구간을 두 배로 늘려서 [3, 8, 4, 3, 8, 4]로 한다면 0 ≤ l < r 의 투 포인터를 돌리는 것으로 모든 경우에 접근이 가능하다.
> 

```python
N, S = map(int, input().split())
arr = list(map(int, input().split()))
total = sum(arr)

remain = S % total
# print(remain)

brr = arr + arr
# print(*brr)

prefix = [0]
for i in range(len(brr)):
    prefix.append(prefix[-1] + brr[i])
# print(*prefix)

l = 0
r = 1
val = 0
while l <= r < len(prefix):
    val = prefix[r] - prefix[l]
    if val == remain:
        # print(l, r)
        print("Yes")
        exit()
    if val < remain:
        r += 1
    else:
        l += 1

print("No")
 
```
