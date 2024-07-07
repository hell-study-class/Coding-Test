import sys

read = sys.stdin.readline

inputs = [read().split() for _ in range(int(read()))]
times = []
for i in inputs:
    times.append([int(i[0]), i[1]])
times.append([0, '48:00'])
team_one = [0, 0]
team_two = [0, 0]
current = 0

for team, time in times:
    m, s = map(int, time.split(':'))
    t = m * 60 + s
    if team_one[0] > team_two[0]:
        team_one[1] += t - current
    elif team_one[0] < team_two[0]:
        team_two[1] += t - current
    current += t - current
    if team == 1:
        team_one[0] += 1
    elif team == 2:
        team_two[0] += 1
print('{:0>2}:{:0>2}'.format(team_one[1] // 60, team_one[1] % 60))
print('{:0>2}:{:0>2}'.format(team_two[1] // 60, team_two[1] % 60))
