def sol():
    ss = input()
    res, tmp = 0, 1
    stk = []
    for i in range(len(ss)):
        if ss[i] == '(':
            stk.append('(')
            tmp *= 2
        elif ss[i] == '[':
            stk.append('[')
            tmp *= 3
        elif ss[i] == ')':
            if not stk or stk[-1] == '[':
                return False
            if ss[i - 1] == '(':
                res += tmp
            tmp //= 2
            stk.pop()
        else:
            if not stk or stk[-1] == '(':
                return False
            if ss[i - 1] == '[':
                res += tmp
            tmp //= 3
            stk.pop()
    return False if stk else res


s = sol()
print(s if s else 0)
