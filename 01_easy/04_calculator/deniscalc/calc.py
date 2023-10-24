operazione=""
while(operazione!="5"):
    print("Welcome in denis calculator please choose the operation you wanna do: ")
    print("1. sum\n2. subtraction\n3. multiplication\n4. division\n5. exit")
    operazione = input()
    if operazione=="1":
        a = int(input("Digit first number: "))
        b = int(input("Digit second number: "))
        print("Result: "+str(a+b))
    elif operazione=="2":
        a = int(input("Digit first number: "))
        b = int(input("Digit second number: "))
        print("Result: "+str(a-b))
    elif operazione=="3":
        a = int(input("Digit first number: "))
        b = int(input("Digit second number: "))
        print("Result: "+str(a*b))
    elif operazione=="4":
        a = int(input("Digit first number: "))
        b = int(input("Digit second number: ")) #non ho voglia di implementare il check del diviso per 0
        print("Result: "+str(a/b))
    