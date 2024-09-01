import sys

read = sys.stdin.readline


def sol():
    ln = 1
    for n in ns:
        while ln <= n:
            stk.append(ln)
            res.append('+')
            ln += 1
        if stk[-1] != n:
            return False
        stk.pop()
        res.append('-')
    return True


ns = [int(read()) for _ in range(int(read()))]
stk, res = [], []
print('\n'.join(res) if sol() else 'NO')