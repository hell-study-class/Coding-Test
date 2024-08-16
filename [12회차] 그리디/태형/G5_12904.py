s, t = input(), input()
head, tail = 0, len(t) - 1
c = len(t)
res = 0


while c > len(s):
    reverse = True if t[tail] == 'B' else False
    if tail > head:
        tail -= 1
    else:
        tail += 1
    if reverse:
        head, tail = tail, head
    c -= 1
if head <= tail:
    if t[head:tail+1] == s:
        res = 1
else:
    if t[tail:head+1][::-1] == s:
        res = 1
print(res)