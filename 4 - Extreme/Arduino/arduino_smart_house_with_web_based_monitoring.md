# Smart remote-controlled Arduino home

The goal here is to create an Arduino project to simulate a smart home with a service to remote-control it.

Some example of features such a house could be provided with are:
- Temperature measurement and regulation
- Humidity measurement and regulation
- Opening/closing main gate
- Unauthorized access detection

Having set up sensors and actuators all across the smart home we now link those to a web-based management service.
On the website we should see live data of our house, as well as have the option to toggle some simple functionality.

An example could be "turn the heater on" which would allow the end-user to begin heating water for his bathtub just before getting out of work.
This remote control panel allows the user to also change target parameters. 
Using the example from above again, the user should be able to set the target temperature for the water.

## Requirements
- Website with a remote control panel and graphs with live information as well as options to display historic data.
- Arduino code which simulates a smart home 
- LaTeX report (with source code as well) on where to position sensors and actuators to implement your proposed solution

## Technologies
Not having access to a physical Arduino board requires some workaround like a simulation tool.
As for your choice of IDE, we provide some recommendations below

- Arduino (Example simulation tool: https://wokwi.com/)
- Arduino IDE
- VSCode + Extension (https://docs.wokwi.com/vscode/getting-started and/or https://marketplace.visualstudio.com/items?itemName=vsciot-vscode.vscode-arduino)

### Website development
Here's some examples of the most common frameworks used
You can mix and match from here, or use something else. Consider asking the organizers if you plan on using some dark technology no one knows

- Python (Full-Stack: Django/Flask/FastApi)
- Java (Full-Stack: Spring Boot Web)
- JavaScript/TypeScript (Vue.js, Angular, React)
- PHP

-------
(versione di Harlock)

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
