n = int(input())
a, b = sorted(map(int, input().split())), sorted(map(int, input().split()), reverse=True)
print(sum(x * y for x, y in zip(a, b)))