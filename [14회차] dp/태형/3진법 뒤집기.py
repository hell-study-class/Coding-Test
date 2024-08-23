def solution(n):
    t = []
    res = 0
    while n:
        n, r = divmod(n, 3)
        t.append(r)
    t = list(reversed(t))
    for i, x in enumerate(t):
        res += x * 3 ** i
    return res
