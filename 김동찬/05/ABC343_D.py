N, T = map(int, input().split())
dic = {0: N}  # 모든 사람은 0점에서 시작
arr = [0 for _ in range(N+1)]  # i번째 사람의 점수를 기록할 배열
for _ in range(T):
    idx, point = map(int, input().split())
    if dic[arr[idx]] != 0:  # 점수가 변동되는 사람의 점수가 딕셔너리에 기록되어 있다면
        dic[arr[idx]] -= 1  # 더이상 그 점수가 아니므로 제거해주고
        if dic[arr[idx]] == 0:  # 그 결과 해당 점수의 사람이 없다면
            dic.pop(arr[idx])  # 딕셔너리에서 키 제거
    arr[idx] += point  # 점수 갱신
    if arr[idx] not in dic.keys():  # 딕셔너리에 새 점수 기록
        dic[arr[idx]] = 1
    else:
        dic[arr[idx]] += 1

    print(len(dic))
