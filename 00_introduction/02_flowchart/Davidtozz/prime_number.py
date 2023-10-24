# print all priime numbers between 2 and 100 (both included)

def is_prime(number):
    for i in range(2, number):
        if number % i == 0:
            return False
    return True

def print_primes():
    for i in range(2, 101):
        if is_prime(i):
            print(i)
    
print_primes()
