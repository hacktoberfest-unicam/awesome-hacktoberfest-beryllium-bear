Price = int(input("Please type in the price \n"))
print("The price you have typed: " + str(Price))
if Price > 50:
    Price = Price - (20/100 * Price)
else:
    Price = Price - (10/100 * Price)
print("The discounted price is: " + str(Price))

