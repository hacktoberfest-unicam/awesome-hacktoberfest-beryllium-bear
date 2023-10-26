from tkinter import *
import math 
import calculator


def onClick(s) :
    e.insert(0,s)

def onOpBtn(fun) :
    num = e.get()
    e.delete(0,END)
    global val 
    val = float(num)
    global op 
    op = fun 
def onEq() : 
    num2 = float(e.get())
    result = op(val,num2)
    e.delete(0,END)
    e.insert(0,str(result))
def sqrt():
    res = float(e.get())
    res=math.sqrt(res)
    e.delete(0,END)
    e.insert(0,res)
root = Tk()
e = Entry(root,text="0",width=50,borderwidth=5)
e.grid(row=0,column=0,columnspan=3)
btn1 = Button(root,text="1",command=lambda : onClick("1"),padx=50,pady=10)
btn2 = Button(root,text="2",command=lambda : onClick("2"),padx=50,pady=10)
btn3 = Button(root,text="3",command=lambda : onClick("3"),padx=50,pady=10)
btn4 = Button(root,text="4",command=lambda : onClick("4"),padx=50,pady=10)
btn5 = Button(root,text="5",command=lambda : onClick("5"),padx=50,pady=10)
btn6 = Button(root,text="6",command=lambda : onClick("6"),padx=50,pady=10)
btn7 = Button(root,text="7",command=lambda : onClick("7"),padx=50,pady=10)
btn8 = Button(root,text="8",command=lambda : onClick("8"),padx=50,pady=10)
btn9 = Button(root,text="9",command=lambda : onClick("9"),padx=50,pady=10)
btn0 = Button(root,text="0",command=lambda : onClick("0"),padx=110,pady=10)
btneq= Button(root,text="=",command=onEq,padx=50,pady=10)
btnSu= Button(root,text="+",command=lambda : onOpBtn(calculator.sum),padx=50,pady=10)
btnDi= Button(root,text="-",command=lambda : onOpBtn(calculator.dif),padx=50,pady=10)
btnMu= Button(root,text="*",command=lambda : onOpBtn(calculator.mul),padx=50,pady=10)
btnDv= Button(root,text="/",command=lambda : onOpBtn(calculator.div),padx=50,pady=10)
btnPw= Button(root,text="^",command=lambda : onOpBtn(math.pow),padx=50,pady=10)
btnSq= Button(root,text="sqrt",command= sqrt,padx=50,pady=10)
btnDi.grid(row=1,column=1)
btnDv.grid(row=1,column=0)
btnMu.grid(row=2,column=3)
btnSq.grid(row=3,column=3)
btnPw.grid(row=4,column=3)
btnSu.grid(row=5,column=3)
btneq.grid(row=5,column=2)
btn1.grid(row=4,column=0)
btn2.grid(row=4,column=1)
btn3.grid(row=4,column=2)
btn4.grid(row=3,column=0)
btn5.grid(row=3,column=1)
btn6.grid(row=3,column=2)
btn7.grid(row=2,column=0)
btn8.grid(row=2,column=1)
btn9.grid(row=2,column=2)
btn0.grid(row=5,column=0,columnspan=2)
root.mainloop()
