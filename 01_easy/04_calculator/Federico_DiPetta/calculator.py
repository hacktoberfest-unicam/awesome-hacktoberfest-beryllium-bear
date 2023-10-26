def sum(a,b) : 
    return a+b 
def mul(a,b) : 
    return a*b
def dif(a,b) :
    return a-b
def div(a,b) : 
    return a/b

def number () :
    val = val 
    
def operator (x) : 
    if(x == "+" ) : 
            return sum
    elif(x == "-") :
            return dif 
    elif(x == "*" ) :
         return mul
    elif(x=="/") :
         return div
    RuntimeError

def apply (func, a , b) :
     return func (a,b)

op = sum
val = 0
y=True
while True :
    if(y) :
        print("digita un numero oppure C per cancellare : ")
        x = input()
        if(x=="C" or x=="c") :
             val=0 
             op=sum
        else :
            val = op(int(val),int(x))
            y = False
            print ("il risultato è "+str(val))
    else :
        print("digita l'operatore tra + , * , - , / ")
        x = input()
        y=True
        op=operator(x)


        