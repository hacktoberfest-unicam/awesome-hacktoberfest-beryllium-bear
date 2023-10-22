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