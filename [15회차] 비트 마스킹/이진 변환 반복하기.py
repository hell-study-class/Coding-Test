def solution(s):
    res = 0
    i = 0
    while s != '1':
        i += 1
        c = s.count('0')
        res += c
        s = bin(len('1' * (len(s) - c)))[2:]
    return [i, res]