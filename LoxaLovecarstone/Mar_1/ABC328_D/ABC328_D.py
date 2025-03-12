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
