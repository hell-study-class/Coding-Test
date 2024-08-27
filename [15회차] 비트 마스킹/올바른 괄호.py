def solution(s):
    stk = []
    for c in s:
        if c == ')':
            if not stk or stk[-1] == ')':
                return False
            stk.pop()
        elif c == '(':
            stk.append('(')
    return True if not stk else False