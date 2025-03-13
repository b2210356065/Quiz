import sys
def hesap(a,b):
    c = a ** b
    while c >= 10:
        toplam =0
        c = str(c)
        for i in c:
            toplam+=int(i)
            c = toplam
        print(c)
    print(c,end="")
hesap(sys.argv[1],sys.argv[2])

