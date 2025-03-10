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
