import sys

cc = -1
print("The expected output: ")
try:
    file1 = open(sys.argv[1], "r")
    x  = file1.readlines()
    file2 = open(sys.argv[2], "r")
    y = file2.readlines()

except IOError:
    print("IOError: cannot open" + sys.argv[1])
    print("- Game Over -")


for i in x:
    try:
        print("------------")
        cc += 1
        aa = i[:-1].split(" ")
        a = []

        for j in aa:
            g = str(float(j))
            if int(g.split(".")[1])>=5:
                a.append(int(g.split(".")[0])+1)
            else:
                a.append(g.split(".")[0])
        list = []
        for c in range(int(a[2]), int(a[3])):
            if c % int(a[0])==0:
                if not c % int(a[1])==0:
                    list.append(c)
        list = [str(i) for i in list]
        if  y[cc][:-1].split()  == list:
            print("My results:"+"              "+" ".join(list))
            print("Results compare:"+" "*9+" ".join(y[cc][:-1].split(" ")))
            print("Goool!!!")
        else:
            print("My results:" + "              " + " ".join(list))
            print("Results compare:" + " " * 9 + " ".join(y[cc][:-1].split(" ")))
            print("Assertion Error: results don’t match.")

    except ZeroDivisionError:
        print("ZeroDivisionError: You can’t divide by 0.")
        print("Given input: " + i)
    except ValueError:
        print("ValueError: only numeric input is accepted.")
        print("Given input: " + i)

    except IndexError:
        print("IndexError: number of input files less than expected.")
        print("- Game Over -",end=" ")
        print(i)
    except:
        print("kaBOOM: run for your life!")
        pass

