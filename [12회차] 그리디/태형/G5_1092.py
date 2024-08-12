n, cs = int(input()), sorted(list(map(int, input().split())), reverse=True)
m, bs = int(input()), sorted(list(map(int, input().split())), reverse=True)
res = 0

if bs[0] > cs[0]:
    print(-1)
else:
    while bs:
        for c in cs:
            for b in bs:
                if c >= b:
                    bs.remove(b)
                    break
        res += 1
    print(res)
'''
pypy
'''