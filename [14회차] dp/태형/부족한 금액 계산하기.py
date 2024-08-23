def solution(price, money, count):
    r = sum([price * c for c in range(1, count + 1)]) - money
    return r if r > 0 else 0