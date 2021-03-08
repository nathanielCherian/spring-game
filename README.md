## Quick Links
- Live Deployed Website [here](http://spring.sylicia.com/)!
- [Kanban Board](https://github.com/nathanielCherian/spring-game/projects/1) includes tickets

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

## Runtime Instructions
Requirements:
- JDK 15
- Maven Installer
Steps:
1. Clone project `https://github.com/nathanielCherian/spring-game`
2. Run `src/main/java/com.example.project/Main.java`
3. Navigate to [localhost:8080](http://localhost:8080/)

## Technologies Used:
- Websocket Protocol
- ThreeJS
- Javascript canvas
- Nginx
- AWS EC2

## Planned
- ReactJS
- MongoDB
- Finish Easter Eggs (AP FRQ)
- Add more functionality to frontend code
- Expirement with static reactjs binaries
- Extend the functionalities of our API's and ones that we are using

