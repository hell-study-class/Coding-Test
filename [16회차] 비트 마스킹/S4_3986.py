import sys

read = sys.stdin.readline


def sol(line: str):
    stk = []
    for word in line:
        if stk and stk[-1] == word:
            stk.pop()
        else:
            stk.append(word)
    return 0 if stk else 1


res = 0
for _ in range(int(read())):
    res += sol(read().rstrip())
print(res)
