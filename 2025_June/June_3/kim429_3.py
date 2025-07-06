def solution(words):
    words.sort()
    answer = 0

    for i in range(len(words)):
        word = words[i]
        cnt = 0
        for j in range(1, len(word) + 1):
            prefix = word[:j]
            match = [w for w in words if w.startswith(prefix)]
            if len(match) == 1:
                cnt = j
                break
        answer += cnt if cnt != 0 else len(word)
    return answer
