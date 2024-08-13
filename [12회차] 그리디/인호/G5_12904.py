import sys

s = input()
t = input()

while t != '':
    if t == s:
        print(1)
        break
    if t[-1] == 'A':
        t= t[:-1]
    elif t[-1] == 'B':
        t= t[:-1]
        t= t[::-1]
else:
    print(0)