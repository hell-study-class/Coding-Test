import sys

read = sys.stdin.readline

i = 1
while True:
    l, p, v = map(int, read().split())
    if not l and not p and not v:
        break
    res, d = divmod(v, p)
    if d > l:
        d = l
    res = (res * l) + d
    print(f'Case {i}: {res}')
    i += 1