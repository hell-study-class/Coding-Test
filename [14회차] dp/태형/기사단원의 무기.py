def solution(number, limit, power):
    def get_power(x):
        s = set()
        for i in range(1, int(x ** .5) + 1):
            if not x % i:
                s.add(i)
                s.add(x // i)
        return len(s)

    res = 0
    for y in range(1, number + 1):
        p = get_power(y)
        res += (power if p > limit else p)
    return res