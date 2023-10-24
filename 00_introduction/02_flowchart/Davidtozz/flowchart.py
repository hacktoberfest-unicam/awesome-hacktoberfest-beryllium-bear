

def discount(price):
    if price > 50:
        price = price * 0.8
    else:
        price = price * 0.9
    
    return price

def main():
    price = float(input("Enter the price: "))
    print(discount(price))
    
main()