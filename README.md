## Quick Links
- Live Deployed Website [here](http://spring.sylicia.com/)!
- [Kanban Board](https://github.com/nathanielCherian/spring-game/projects/1) includes tickets

## Main Website (Deployment)

## Dark Mode
- Top-right toggle button
- Changes background website theme to dark black/grey

![lightmode](https://user-images.githubusercontent.com/54604091/110501903-82fa3580-80af-11eb-9df2-2a9657a58f48.PNG)![darkmode](https://user-images.githubusercontent.com/54604091/110501893-8097db80-80af-11eb-8f74-acd06f933a0f.PNG)

## Bitcoin Transaction Decoder
- Uses existing API to decode any bitcoin transaction

![thing_50](https://user-images.githubusercontent.com/54604091/110501593-2f87e780-80af-11eb-864d-49f24ca5cfd8.png)

## Database API

## Representational Map
- Uses stored database of "people"
- Uses connections to organize and connect "people" together using relationships tab

![peoplemap](https://user-images.githubusercontent.com/54604091/110501261-d91aa900-80ae-11eb-9766-c499c9332bef.PNG)![peopl](https://user-images.githubusercontent.com/54604091/110505518-13864500-80b3-11eb-854b-9e3c48f51037.png)

## Highlighted Features
- **Dark Mode with Cookies**: for dark mode we are using cookies to store the user's theme preference
This way if a user chooses to use dark mode it will save their selection and the next time they use the
website it will switch accordingly. Try this by flipping the switch in the top left and then refreshing the page.
-  **Markdown parsers and API's**: Instead of displaying our readme through github we can server it directly
through the website. At first we were going to write HTML for the entire document but instead we are fetching the markdown content 
straight from github. Then we take this plaintext and run it through githubs flavored markdown API and use Jquery
to render it directly onto the page. 
- **CI (Continuous Integration)**: We are expirimenting with continous integration to smooth deployment options
The pipeline starts with compiling the jar file and then running a script server side that will automatically update our content. 
Additionally, because we are integrating markdown into our website served through GitHub, we can simply push to our repo
to update the content on the website. 
- **Bitcoin API**: As a fun project to showcase on our website we are hosting a REST API that returns mutated data from the 
blockchain. On top of this we created a front-end client-side application in javascript that allows you to explore the segment details
of a bitcoin transaction.
- **SQLite Wrapper**
```
Table people = new Table("People")
        .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
        .addColumn(new Column("name", Column.STRING).isNotNull())
        .addColumn(new Column("school", Column.STRING))
        .create();
```

## Contributors
 - Nathaniel Cherian [@nathanielCherian](https://github.com/nathanielCherian) 
 - Jett Kim [@JettKim](https://github.com/JettKim)
 - Alex Titov [@alextitov19](https://github.com/alextitov19)
 - Benny Herrick [@bennyherrick](https://github.com/bennyherrick)

## Runtime Instructions
Requirements:
- JDK 15
- Maven Installer
Steps:
1. Clone project `https://github.com/nathanielCherian/spring-game`
2. Run `src/main/java/com.example.project/Main.java`
3. Navigate to [localhost:8080](http://localhost:8080/)

## Technologies Used:
- Websocket Protocol: HTTP function runs as a server that responds to requests.
- ThreeJS:You can use Three. js in any way you could use "canvas" , including full-screen animations, or slides and has to connect with our Websocket and AWS.
- Javascript canvas: HTML element which can be used to draw graphics via scripting. This can be used to draw graphs, combine photos, or create simple (and not so simple) animations.
- Nginx:HTTP server and reverse proxy(a gate way between the internet and the website browser)
- AWS EC2: a web service that provides secure, resizable compute capacity in the cloud. It is designed to make web-scale cloud computing easier for developers.

## Planned
- ReactJS
- MongoDB
- Finish Easter Eggs (AP FRQ)
- Add more functionality to frontend code
- Expirement with static reactjs binaries
- Extend the functionalities of our API's and ones that we are using

