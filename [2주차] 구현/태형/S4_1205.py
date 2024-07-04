n, s, p = map(int, input().split())

ranking_list = [-1] * (p + 1)
scores = list(map(int, input().split())) if n > 0 else []
for i in range(n):
    ranking_list[i+1] = scores[i]

rank = 1
for i in range(1, p+1):
    if s < ranking_list[i]:
        rank += 1
    if s > ranking_list[i]:
        print(rank)
        break
else:
    print(-1)

'''
앞에서부터 순회하며 값이 더 크면 등수가 하나 밀리고,
값이 동일하다보면 스킵,
값이 더 작다면 등수를 출력, 단 순회하는 동안 작은 값이 나오지 않는다면 -1 출력
'''