def solution(d, budget):
    d.sort()
    res = 0
    for x in d:
        if budget - x >= 0:
            budget -= x
            res += 1
        else:
            break
    return res