from typing import List

class Solution:
    def solution(self, begin:str, target:str, words:List[str]):
        visited = [False] * len(words)
        stack = [[begin,0]]
        while stack:
            w,cnt = stack.pop()
            if w == target:
                return cnt
            for i,word in enumerate(words):
                if not visited[i]:
                    difference = sum([w[j] != word[j] for j in range(len(w))])
                    if difference ==1:
                        visited[i] = True
                        stack.append([word,cnt+1])
        return 0
