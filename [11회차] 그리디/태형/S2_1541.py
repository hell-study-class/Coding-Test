op = input()
res = []
tmp = ''
flag = False
for s in op:
    if s.isdigit():
        tmp += s
    if not s.isdigit():
        res.append(str(int(tmp)))
        tmp = ''
        if s == '-':
            flag = True
        if flag:
            res.append('-')
        else:
            res.append(s)
res.append(str(int(tmp)))
print(int(eval(''.join(res))))
'''
55-50+40
10-20-40-10-20+100
10+20+30+40+10
'''
