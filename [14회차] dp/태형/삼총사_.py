def solution(number):
    def sol(idx: int = 0, s: int = 0, depth: int = 0):
        if depth == 3:
            if not s:
                nonlocal res
                res += 1
            return
        for i in range(idx, len(number)):
            sol(i + 1, s + number[i], depth + 1)

    res = 0
    sol()
    return res
