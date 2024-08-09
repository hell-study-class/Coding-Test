import sys

read = sys.stdin.readline

cs = [25, 10, 5, 1]
res = []
for T in range(int(read())):
    ret = [0] * 4
    n = int(read())
    for i in range(4):
        ret[i], n = divmod(n, cs[i])
    res.append(ret)
for r in res:
    print(*r)