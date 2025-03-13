xx = open("inputFile .txt","r")
ax = open("outputFile.txt","w")
cc = xx.readlines()
cs = []
sc = []
data = []
for g in cc:
    d = g.split("\t")
    cs.append(int(d[0]))
    sc.append(int(d[1]))
    data.append(g)
k = set(cs)
l = set(sc)
d = []
v = []
for a in k:
    d.append(a)
for c in l:
    v.append(c)
binlik = sorted(d)
birlik = sorted(v)
for ı in range(len(binlik)):
    for e in range(len(birlik)):
        for i in data:
            if str(binlik[ı])+str(birlik[e]) == i.split("\t")[0]+i.split("\t")[1]:
                ax.write(i)

