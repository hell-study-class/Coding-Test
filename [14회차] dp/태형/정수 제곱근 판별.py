def solution(n):
    r_n = int(n ** .5)
    return (r_n + 1) ** 2 if r_n == n ** .5 else -1