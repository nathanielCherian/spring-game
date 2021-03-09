## Quick Links
- Live Deployed Website [here](http://spring.sylicia.com/)!
- [Kanban Board](https://github.com/nathanielCherian/spring-game/projects/1) includes tickets
- [Commercial](https://www.youtube.com/watch?v=Jxi7qnZ0sfo) for N@TM

## Main Website (Deployment)
- http://spring.sylicia.com/ deployed through AWS EC2
- Frontend development with HTML, CSS, and JS
- Backend API's for data

## Dark Mode
![lightmode](https://user-images.githubusercontent.com/54604091/110505920-75df4580-80b3-11eb-9e0b-4850122a5184.PNG)
![darkmode](https://user-images.githubusercontent.com/54604091/110505927-78419f80-80b3-11eb-8914-83a66514c8f4.PNG)
- Created with javascript and uses cookies to track users selection
- Using css `mix-blend-mode` property to change children elements contrast in relation to parents

[Code](https://github.com/nathanielCherian/spring-game/blob/master/src/main/resources/templates/fragments/header.html#L61-L110)


## Bitcoin Transaction Decoder
![thing_50](https://user-images.githubusercontent.com/54604091/110501593-2f87e780-80af-11eb-864d-49f24ca5cfd8.png)

- Uses existing API from [blockchain.com](https://www.blockchain.com/) to get hex data of a transaction in Java
- Parse this data to a simpler and more readable format and create our own endpoint [here](http://spring.sylicia.com/api/transaction/3492e0ec39cfc64d1478b1463498f4b4805dc26b51831da989127ef6d5eb1a530)
- Use javascript fetch with asynchronous programming to get data from our endpoint
- Split up the hex block by byte size and jquery/html to render it to user

[Javascript code implementaiton](https://github.com/nathanielCherian/spring-game/blob/master/src/main/resources/templates/bitcoin.html#L100-L187)

[Java code implementation](https://github.com/nathanielCherian/spring-game/blob/master/src/main/java/com/example/project/api/BitcoinAPI.java)
 
## Database API
- We are using the `sqlite-jdbc` java package to manage our database server-side
- Custom [java wrapper](https://github.com/nathanielCherian/spring-game/blob/master/src/main/java/com/example/project/Database/Table.java) and [SQLite Controller](https://github.com/nathanielCherian/spring-game/blob/master/src/main/java/com/example/project/Database/SQLiteController.java) that allows us to convert java objects into their SQL counterparts
Example:
```
Table people = new Table("People")
        .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
        .addColumn(new Column("name", Column.STRING).isNotNull())
        .addColumn(new Column("school", Column.STRING))
        .create();
```
People are added to the databse with
```
Object[] data = new Object[3];
data[0] = null; //id
data[1] = (String) object.get("name");
data[2] = (String) object.get("school");
people.createRow(data);
```

In order to represent the many-to-many releationships between different people in the database we are using a second table that holds a foreign key to the peoples table ID column.
```
Table relationships = new Table("Relationships")
        .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
        .addColumn(new Column("personId1", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
        .addColumn(new Column("personId2", Column.INTEGER).isForeignKey("People", "id", Column.CASCADE))
        .create();
```

[Implementation](https://github.com/nathanielCherian/spring-game/blob/master/src/main/java/com/example/project/People/People.java#L49-L60)


To allow the database to connect to the internet we are using json communication through POST requests at [this endpoint](http://spring.sylicia.com/api/db/people).
```
@RequestMapping(value = "/api/db/people", method = RequestMethod.POST, consumes = "text/plain")
        public String peoplePostAPI(@RequestBody String payload){
        String statuscode = people.parseJSON(payload);
        return statuscode;
}
```
[Implementation](https://github.com/nathanielCherian/spring-game/blob/master/src/main/java/com/example/project/MainRESTController.java#L30-L64)

## Representational Map
![peoplemap](https://user-images.githubusercontent.com/54604091/110501261-d91aa900-80ae-11eb-9766-c499c9332bef.PNG)![peopl](https://user-images.githubusercontent.com/54604091/110505518-13864500-80b3-11eb-854b-9e3c48f51037.png)

- To represent the many-to-many relationships between users in the database we are using a node-edge-graph that is commonly used to illustrate friendships on social media.
- All done through pure javascript with html canvas to draw shapes
- Javascript asynchronus mapping to fetch data concurrently
- Used [cytoscape.js](https://js.cytoscape.org/) to render nodes

[Implementation](https://github.com/nathanielCherian/spring-game/blob/master/src/main/resources/templates/map.html#L158-L247)

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

