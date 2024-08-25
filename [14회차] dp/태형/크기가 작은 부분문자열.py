def solution(t, p):
    p_i = int(p)
    res = 0

    for i in range(len(t) - len(p) + 1):
        if int(t[i:i + len(p)]) <= p_i:
            res += 1
    return res