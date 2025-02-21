
# 알고리즘

Greedy

# 난이도

배점: 425

AtCoder Problems: 533

# 링크

https://atcoder.jp/contests/abc393/tasks/abc393_d

# 접근 과정

D번 문제를 봤을 때 시간이 93분 남아서 풀 수 있을 거라 생각했는데 93분동안 전혀 풀지 못했다. 장고 끝에 떠올린 생각의 단편들은 이러하다.

- 양끝으로 모으는 것보다 가운데로 모으는 것이 유리하다.
- 이미 바깥쪽에 있는 0은 정답에 영향을 주지 않는다. (00000110001 을 111000000 으로 모을 필요는 없다)

1끼리 모으고 0끼리 모은 다음에 그 위치 및 개수를 파악한 다음 1들을 가운데로 모을 때 얼마나 스왑이 일어나는지로 접근했는데 AC를 받지 못했다.

```python
N = int(input())
S = input()

start = S.index('1')
end = -1
cnt = 0
arr = []
for i in range(N):
    if S[i] =='1':
        end = i
        arr.append(i)
        cnt += 1

S = S[start:end+1]  # 처음 1이 있는 곳, 마지막 1이 있는 곳
# print(S)
T = S.split('0')  # 1끼리 모음
S = S.split('1')  # 0끼리 모음
print(T)
print(S)

tmpS = []
for val in S:
    if val:  # 빈 칸 제거
        tmpS.append(len(val))  #0 몇 개가 연속해서 붙어있는지
print(tmpS)  

tmpT = []
for val in T:
    if val:
        tmpT.append(len(val))  # 1 몇 개가 연속으로 붙어있는지
print(tmpT)

l = 0
r = len(tmpS) - 1  # 0의 오른쪽 끝
r2 = len(tmpT) - 1  # 1의 오른쪽 끝
coefl = tmpT[l]  # 1이 왼쪽에서 몇 개나 몰려있는가
coefr = tmpT[r2]  # 1이 오른쪽에서 몇 개나 몰려있는가
ans = 0
while l <= r:
    if l == r:
        ans += min(tmpS[l] * coefl, tmpS[r] * coefr)
    else:
        ans += tmpS[l] * coefl  # 모아둔 1(coef)으로 0 몇 개(tmpS[l])를 건너뛰는가
        ans += tmpS[r] * coefr
    l += 1
    r -= 1
    r2 -= 1
    coefl += tmpT[l]
    coefr += tmpT[r2]

print(ans)

```

에디토리얼은 이러했다.

> 1이 아니라 0에 집중한다. 0을 좌우 중 어느 바깥쪽으로 몰아내면 된다. 1**0**00110 같은 경우에, 2번째에 위치한 0과 1번째에 위치한 0을 바꾸면 0은 자연스럽게 바깥으로 가며, **0**100110이 된다. 그러면 세 번째에 위치한 0과 방금 이동한 1을 바꿀 수 있다. 따라서 0010110이 된다. 
최초 상태인 100**0**110에서 네 번째 0을 오른쪽 바깥으로 빼기 위해서는 2번의 스왑을 해야 한다. 1001**0**10을 만든 다음, 10011**0**0을 만든다. 그렇지만 001**0**110 에서 왼쪽으로 빼면 00**0**1110의 한 번의 스왑으로 바깥으로 뺄 수 있다.
즉 0이 어디에 있든 간에 바깥쪽에 위치한 0부터 자신의 왼쪽/오른쪽에 위치한 1과 스왑하면 자신은 바깥으로 빠지면서 1을 안쪽으로 모을 수 있다. 따라서 왼쪽/오른쪽 중 1이 적게 존재하는 쪽으로 스왑을 하면 된다.
> 

```python
import bisect

N = int(input())
S = input()

l = -1
r = -1
pos = []
for i in range(N):
    if S[i] == "1":
        r = i
        if l == -1:
            l = i
        pos.append(i)

# print(l, r) 시작 위치와 끝 위치를 계산한다.
# print(pos)

ans = 0
for j in range(l, r):
    if S[j] == "0":
        x = bisect.bisect_left(pos, j)
        # print(x)
        ans += min(x, len(pos) - x)

print(ans)
```
