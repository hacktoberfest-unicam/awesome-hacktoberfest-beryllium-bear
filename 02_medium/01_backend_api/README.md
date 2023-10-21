# Backend API
API stands for Application Programming Interface; as the name says, those are intermediary pieces of code that allow exchanging data between different software.
Currently, APIs are mostly used in websites; almost all the websites that are commonly used have the concept of APIs and a clear separation between front-end and back-end.

Along with the API concept, some standard architectures are present in websites.
Among them, the two most common nowadays are REST and SOAP.

REST stands for REpresentational State Transfer and uses standard HTTP requests to exchange data, mainly using JSON files.
SOAP stands for Simple Object Access Protocol, is mainly focused on the performed operation, and also uses the XML format to exchange information.

In this problem, you are asked to develop a REST API that given an array, returns the sorted version.
It is important to notice that the array may contain different object types.


## Limitations
While it is possible to implement a REST API from scratch only using sockets or similar APIs in low-level programming languages, we suggest using a more structured framework.
For this problem, you are allowed to use:
- Python Frameworks (Django, Flask and FastAPI)
- Java Frameworks (Spring Boot Web)
- JavaScript Frameworks (Express.js, Node.js, Next.js)
- PHP Vanilla (Vanilla means base version of it, without any framework)
- PHP Framework (Laravel)

Note: you are not required to work on the graphical appearence, testing the APIs with `curl` from the Unix/Linux Terminal or [Postman](https://www.postman.com/) will be enough.
