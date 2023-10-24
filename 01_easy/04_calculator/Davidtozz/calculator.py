# This function adds two numbers
def add(x, y):
    return x + y

# This function subtracts two numbers
def subtract(x, y):
    return x - y

# This function multiplies two numbers
def multiply(x, y):
    return x * y

# This function divides two numbers
def divide(x, y):
    return x / y

# create the four basic functions of a calculator

def calculate(operation, *numbers):
    if operation == '+':
        return add(*numbers)
    elif operation == '-':
        return sub(*numbers)
    elif operation == '*':
        return multiply(*numbers)
    elif operation == '/':
        return divide(*numbers)
    else:
        raise ValueError('Invalid operation')

print(add(2,2))
print(subtract(2,2))
print(multiply(2,2))
print(divide(2,2))
    

