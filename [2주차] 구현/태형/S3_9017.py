import sys

read = sys.stdin.readline

for T in range(int(read())):
    n, nums = int(read()), list(map(int, read().split()))
    team_counter = {i+1: 0 for i in range(200)}
    for num in nums:
        team_counter[num] += 1
    scores = {i+1: [[], 0] for i in range(200) if team_counter[i+1] >= 6}
    score = 1
    for num in nums:
        if team_counter[num] >= 6:
            scores[num][0].append(score)
            if len(scores[num][0]) <= 4:
                scores[num][1] += score
            score += 1
    winner = sorted(scores.items(), key=lambda x: (x[1][1], x[1][0][4]))
    print(winner[0][0])
