chain=""

blocco=""

while(blocco!="exit"):
    blocco = input("Add your string: (digit exit to end the program) ")
    if(blocco!="exit"):
        chain=chain+blocco

print(chain)