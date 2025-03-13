import sys
lst = list(map(int, sys.argv[1].split(',')))

lst = [0] + [lst[i] for i in range(len(lst)) if i % 2 == 0]
i=2
while i < len(lst):

    newLst = []
    current = lst[i]
    for j in range(len(lst)):
        if j % current != 0:
            newLst.append(lst[j])

    lst = [0] + newLst

    i += 1


print(lst[1::])