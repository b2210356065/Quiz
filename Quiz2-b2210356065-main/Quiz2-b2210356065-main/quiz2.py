import sys
try:
    a = int(sys.argv[1])
    b = int(sys.argv[2])
    c = int(sys.argv[3])
    d = a*2
    e = b*3
    cc = d+e+c
    print(cc)
except:
    pass
#BEDIRHAN GENCASLAN 2210356065

def healthStatus(boy,kilo):
    kitleendeksi = kilo/boy**2
    if kitleendeksi <= 18.5:
        return("underweight")
    else:
        if kitleendeksi <= 24.9:
            return("healthy")
        else:
            if kitleendeksi <= 29.9:
                return("overweight")
            else:
                if kitleendeksi <= 39.9:
                    return("obese")
                else:
                    return("morbid obese")

