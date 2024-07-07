res = []
tmp = []
tag_start = False

for s in input():
    if s not in ('<', '>', ' '):
        tmp.append(s)
    if s == '<':
        res.append(''.join(tmp[::-1]))
        tmp.clear()
        tag_start = True
        tmp.append(s)
    elif s == '>':
        tmp.append(s)
        tag_start = False
        res.append(''.join(tmp))
        tmp.clear()
    elif s == ' ':
        if tag_start:
            tmp.append(s)
        if not tag_start:
            res.append(''.join(tmp[::-1] + [' ']))
            tmp.clear()

if tmp:
    res.append(''.join(tmp) if tag_start else ''.join(tmp[::-1]))
print(''.join(res))