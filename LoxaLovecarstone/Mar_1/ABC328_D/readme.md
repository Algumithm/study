# 알고리즘

Data Structure, Stack

# 난이도

배점: 425

AtCoder Problems: 555

# 링크

https://atcoder.jp/contests/abc328/tasks/abc328_d

# 접근 과정

이젠 너무나도 익숙해진 스택이다. 문자열을 하나씩 조사하다가 제거가 시작될 수 있는 “C” 가 들어오면 제거가 가능한지 확인한 후 스택에서 제거한다. 만약 제거가 불가능하다면 스택에 해당 문자열을 넣어준다.

괄호 짝 맞추기 하면서 “대체 이걸 어떻게 이런 생각을 하는 거지?” 했던 때가 아직도 새록새록한데… 이래저래 늘긴 늘었나보다.

```python
S = input()
stack = []

ptr = 0
while ptr < len(S):
    # print(S[ptr], end=" ")
    if S[ptr] == "C":
        if len(stack) >= 2:
            if stack[-2] == "A" and stack[-1] == "B":
                stack.pop()
                stack.pop()
            else:
                stack.append(S[ptr])
        else:
            stack.append(S[ptr])
    else:
        stack.append(S[ptr])

    ptr += 1

print("".join(stack))

```
