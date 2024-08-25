def solution(left, right):
    def get_num(x):
        ret = set()
        for i in range(1, int(x ** .5) + 1):
            if not x % i:
                ret.add(i)
                ret.add(x // i)
        return len(ret)

    res = 0
    for x in range(left, right + 1):
        if get_num(x) % 2:
            res -= x
        else:
            res += x
    return res