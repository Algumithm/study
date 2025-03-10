# 알고리즘

Data Structure, Segment Tree, BST

# 난이도

배점: 425

AtCoder Problems: 714

# 링크

https://atcoder.jp/contests/abc352/tasks/abc352_d

# 접근 과정

1년 전에 참가했던 콘테스트이다. 그 당시에 D번 문제에 아무런 제출도 하지 않은 걸로 봐서는 어떻게 풀어야할지조차 몰랐나보다. 그런데 지금 문제를 읽고 나니 “이거 세그먼트 트리로 풀 수 있지 않아?” 하는 생각이 바로 들었다.

예제 입력인 [2, 3, 1, 4]을 예로 들면 이것을 인덱스 배열로 바꾼다. 즉 [3, 1, 2, 4]가 된다. 1은 3번 인덱스에 위치하고, 2는 1번 인덱스에 위치하고, 3은 2번 인덱스에 위치하고, 4는 4번 인덱스에 위치한다. 이후 K = 2이므로 1 ~ 2 구간에서 최소값과 최대값의 차이, 2 ~ 3 구간에서 최소값과 최대값의 차이, 3 ~ 4 구간에서 최소값과 최대값의 차이를 구하는 구간 쿼리를 계속해서 처리해야 한다. 따라서 세그먼트 트리로 접근하였다.

```python
from math import ceil, log2
import sys
input = sys.stdin.readline

def init(left: int, right: int, node: int) -> None:
    if left == right:
        tree[node] = [arr[left], arr[left]]
    else:
        mid = (left + right) // 2
        init(left, mid, 2*node)
        init(mid + 1, right, 2*node + 1)
        tree[node][0] = min(tree[2*node][0], tree[2*node+1][0])
        tree[node][1] = max(tree[2*node][1], tree[2*node+1][1])

def get(left: int, right: int, node: int, idx: int, jdx: int) -> list:
    if right < idx or left > jdx:
        return [float("inf"), -float("inf")]
    if idx <= left and right <= jdx:
        return tree[node]

    mid = (left + right) // 2
    lnode = get(left, mid, 2*node, idx, jdx)
    rnode = get(mid+1, right, 2*node+1, idx, jdx)

    return [min(lnode[0], rnode[0]), max(lnode[1], rnode[1])]

N, K = map(int, input().split())
brr = list(map(int, input().split()))
HEIGHT = ceil(log2(N)) + 1
NODES = 2 ** HEIGHT
# print(NODES)

if K == 1:
    print(0)
    exit()

arr = [0 for _ in range(N)]
for i in range(N):
    arr[brr[i]-1] = i

arr = [-float("inf")] + arr
print(arr)

tree = [[float("inf"), -float("inf")] for _ in range(NODES)]
# print(tree)
init(1, N, 1)
# print(tree)

ans = float("inf")
for i in range(0, N-K+1):
    l,r = get(1, N, 1, i+1, i+K)
    ans = min(ans, r-l)

print(ans)
 
```

에디토리얼은 인덱스 배열로 바꾼 후 BST를 이용하여 최적화를 활용해 NlogK 시간에 처리할 수 있다고 했다. 세그먼트 트리도 어쨌든 NlogK에 돌아가니까 올바르게 접근했다는 생각이 들어서 뿌듯하다.
