import sys

read = sys.stdin.readline


def check():
    ps = read().rstrip()
    stk = []
    for p in ps:
        if p == '(':
            stk.append('(')
        elif p == ')':
            if not stk or stk[-1] != '(':
                return False
            stk.pop()
    return False if stk else True


for _ in range(int(read())):
    print('YES' if check() else 'NO')
