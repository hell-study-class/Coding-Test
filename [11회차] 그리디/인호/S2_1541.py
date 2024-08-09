line = list(input().split('-'))

for i in range(len(line)):
    if '+' in line[i]:
        line[i] = sum(map(int,line[i].split('+')))
    else:
        line[i] = int(line[i])

cnt = line[0]
for i in range(1,len(line)):
        cnt-=line[i]
print(cnt)

