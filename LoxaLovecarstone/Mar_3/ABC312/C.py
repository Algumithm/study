import bisect

N, M = map(int, input().split())
seller = list(map(int, input().split()))
buyer = list(map(int, input().split()))

seller.sort()
buyer.sort()

# 판매자는 X가 자신의 값 이상이면 수락할 것임
# 구매자는 X가 자신의 값 이하이면 수락할 것임

l = 1
r = 10 ** 9 + 1
ans = float("inf")
while l <= r:
    mid = (l + r) // 2
    sellerpos = bisect.bisect_right(seller, mid)
    sellercnt = sellerpos

    buyerpos = bisect.bisect_left(buyer, mid)
    buyercnt = M - buyerpos

    if sellercnt >= buyercnt:  # 물건을 팔겠다는 사람이 많으면 사겠다는 사람을 늘려보게 함...? 가격을 내리면 됨...
        ans = min(ans, mid)
        r = mid - 1
    else:
        l = mid + 1

print(ans)
