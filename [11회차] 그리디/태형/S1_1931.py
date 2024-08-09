import sys

read = sys.stdin.readline

tables = sorted([list(map(int, read().split())) for _ in range(int(read()))], key=lambda x: (x[1], x[0]))
res, l = 0, 0
for time in tables:
    s, e = time
    if s >= l:
        res += 1
        l = e
print(res)