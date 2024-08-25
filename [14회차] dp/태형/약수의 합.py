def solution(n):
    if not n:
        return 0
    res = set([n])
    for x in range(1, n // 2 + 1):
        if not n % x:
            res.add(x)
            res.add(n // x)
    return sum(res)
