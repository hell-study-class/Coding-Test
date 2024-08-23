def solution(n):
    if n == 1: return 0
    c = 0
    while c < 500:
        if n == 1:
            return c
        if not n % 2:
            n //= 2
        else:
            n = n * 3 + 1
        c += 1
    return -1