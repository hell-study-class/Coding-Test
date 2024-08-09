import sys

read = sys.stdin.readline

for T in range(int(read())):
    ps = sorted([list(map(int, read().split())) for _ in range(int(read()))])
    r, m = 1, ps[0][1]
    for i in range(1, len(ps)):
        if ps[i][1] < m:
            m = ps[i][1]
            r += 1
    print(r)