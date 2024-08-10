import sys

read = sys.stdin.readline

def out_content(idx):
    maxx = -1
    change = -1
    for c in content:
        if c in order[idx+1:]:
            if maxx <= order.index(c,idx+1):
                maxx = order.index(c,idx+1)
                change = c
        else:
            change = c
            break
    return change

n,k = map(int,read().split())
order = list(map(int,read().split()))

content = []
count = 0
for i,o in enumerate(order):
    if o in content:
        continue
    if len(content) < n:
        content.append(o)
    else:
        c = out_content(i)
        content.remove(c)
        content.append(o)
        count+=1
print(count)
