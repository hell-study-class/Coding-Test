import sys

read = sys.stdin.readline

h, w = map(int, read().split())
graph = [list(map(lambda x: {'c': True, '.': False}[x], list(read().rstrip()) )) for _ in range(h)]
res = []
for row in graph:
    flag = False; cnt = 0
    new_row = []
    for i in range(w):
        if flag:
            if row[i]:
                cnt = 0
                new_row.append(cnt)
            else:
                cnt += 1
                new_row.append(cnt)
        else:
            if row[i]:
                flag = True
                new_row.append(cnt)
            else:
                new_row.append(-1)
    res.append(new_row)
for row in res:
    print(*row)