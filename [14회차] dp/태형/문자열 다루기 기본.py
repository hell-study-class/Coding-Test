def solution(s):
    if len(s) in (4, 6):
        for c in s:
            if not c.isdigit():
                return False
        return True
    return False