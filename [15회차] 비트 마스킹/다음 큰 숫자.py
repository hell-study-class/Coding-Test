def solution(n):
    bin_n = bin(n)[2:]
    c = bin_n.count('1')
    i = 1
    while True:
        if bin(n+i)[2:].count('1') == c:
            return n+i
        i += 1