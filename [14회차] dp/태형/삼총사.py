def solution(number):
    res = 0
    for i in range(len(number)-2):
        for j in range(i+1, len(number)-1):
            for k in range(j+1, len(number)):
                if not number[i] + number[j] + number[k]:
                    res += 1
    return res