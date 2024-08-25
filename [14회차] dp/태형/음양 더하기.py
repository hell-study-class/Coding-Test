def solution(absolutes, signs):
    res = 0
    for n, sign in zip(absolutes, signs):
        if sign:
            res += n
        else:
            res -= n
    return res