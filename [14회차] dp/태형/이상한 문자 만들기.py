def solution(s):
    res = ''
    r = ''
    flag = True
    for c in s:
        if c == ' ':
            r = c
            res += ' '
        else:
            if r == ' ':
                flag = True
                r = ''
            if flag:
                res += c.upper()
            else:
                res += c.lower()
            flag = not flag
    return res