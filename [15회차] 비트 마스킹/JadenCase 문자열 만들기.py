def solution(s):
    is_first = True
    res = []
    for c in s:
        if c == ' ':
            is_first = True
            res.append(' ')
        else:
            if is_first:
                res.append(c.upper())
                is_first = False
            else:
                res.append(c.lower())
    return ''.join(res)