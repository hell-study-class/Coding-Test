def solution(n, m):
    def gcd(a, b):
        while b != 0:
            r = a % b
            a, b = b, r
        return a
    if n < m:
        n, m = m, n
    c = gcd(n, m)
    return [c, n * m // c] if c != 1 else [c, n * m]
