def solution(x):
    return not x % sum(list(map(int, list(str(x)))))