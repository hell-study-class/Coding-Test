import re
import sys

read = sys.stdin.readline


def check(sc: str):
    stk = []
    for w in sc:
        if w in ('(', '['):
            stk.append(w)
        elif w == ')':
            if not stk or stk[-1] != '(':
                return 'no'
            stk.pop()
        elif w == ']':
            if not stk or stk[-1] != '[':
                return 'no'
            stk.pop()
    return 'no' if stk else 'yes'


while s := read()[:-2]:
    if s == '.':
        break
    print(check(re.sub(r'[^\[\]()]', '', s)))
