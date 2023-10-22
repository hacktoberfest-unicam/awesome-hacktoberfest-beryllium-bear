# Arduino
In this project, you have to expand your solution from the previous difficulty level to have a server that after a login shows the user live and historic data with plots, and allows the user to change thresholds from the interface.
For example, a user may have an A/C in their house connected to the smart system and want to turn on the A/C when the temperature rises above a certain threshold.
In this case, the web interface has to provide a user-friendly handle to set the threshold when the user is not at home.

# References
We suggest looking to [Wokwi](https://wokwi.com/ ) for a platform that simulates the Arduino behaviour.
This platform also provides a VSCode extension.
Is also possible to use the [Arduino IDE](https://www.arduino.cc/en/software)
To develop the back end we suggest using a web development framework and assuming it will be connected to a RaspberryPI that will communicate to the Arduino via serial port.
You are free to use your preferred language, but we suggest looking to:
- Python (Full-Stack: Django/Flask/FastApi)
- Java (Full-Stack: Spring Boot Web)
- JavaScript/TypeScript (Any Framework)

Note: It is possible to also mix frameworks and have a RESTful backend in Django and a JavaScript Framework for the front end.
