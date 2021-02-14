# p1-mosaic-spring: [Spring Website](http://ec2-44-239-226-169.us-west-2.compute.amazonaws.com/)
Due to the AWS limit on maximum hours that the website can be run on its servers for its free tier version, we have implemented a schedule that **shuts down the website every night from 8:00pm to 8:00am on days mon-thu, but on fri-sun the server shuts down from 10:00pm to 8:00am**. Sorry for your inconvenience and thank you for your patience.

## Project Contributors
| Contributor | GitHub Link | Journal Link |
| ----------- | ----------- | ----------- | 
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Sara Beniwal | [@saraben21](https://github.com/saraben21) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)

## ScrumBoard
<a href="https://github.com/mhayescs19/p1-mosaic-spring/projects/1"><img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/board-entire-button.png" width="30%" height="auto"><a/> 

## Project Idea
We  plan on making a synergy clone where teachers can view their students and give out grades and take roll call. Would also have two differnt views one for students another for teachers. Will be using AWS to host the website and associated databases. <br><br>

**Student View**
- Log-in system (StudentID, password)
- Side bar to access their own personal grades <br> <br>
**Gradebook:**
- Overview of all classes grades
- Click each class to view the individual grade of the class
- Table with: Date, Assignment, Score, Score Type, Points, Notes <br> <br>
**Student Info:**
- Name, grade, ID number, counselor name, GPA (specifically at a given instance)
- Static schedule <br> <br>
**School Information:**
- Name, Principal, Address, Website <br> <br>
**Calendar:**
- Students can view upcoming assignments due on their calendar <br> <br>

**Teacher View**
- Log-in system (Teacher username, password)
- Teacher modifies assignments and grades <br> <br>
**Gradebook (Teacher):**
- Create assignment categories with assignment weights
- Create assignment name and Input assignment points
- Backend code/JS to calculate percentage/letter grade and GPA
- Delete function for mistake and error correction <br> <br>
**Class Roster:**
- See students in their class (entire roster) with name, grade, ID, and high school year
- Table with: Date, Assignment, Score, Score Type, Points, Notes
- Filter with search function for students and grades <br> <br>
**Calendar:**
- Assignments added by teacher shows up on calendar for student in class <br> <br>

## Project Plan (Rough)
**Week of 02/19:** Front End/CSS Styling/ Main Student-Teacher View Page Setup <br> 
**Week of 02/26:** BackEnd Java Code/Javascript and Connect to Database <br> 
**Week of 03/05:** Debugg/Add Other Features if Time Allows <br>
  
## Runtime Guidance For Entire Project
1. Clone the project repository.
2. Open the src directory, open the Main directory, open the Java directory, open the com.example.project package and open the Main.java file.
3. Run from Main.java (inside of the "Main" package) OR set up configuration to Main.
<img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/runtime-main-java.png" height="auto" width="40%"> <img src="https://github.com/mhayescs19/p1-mosaic-spring/blob/master/assets/runtime-config.png" width="45%" height="auto">

## 2/05  Weekly Project Contributions and Artifacts Log
### Week 8
<!-- # [Tickets Video](https://drive.google.com/file/d/1hbOL0yeJWl4qi3kuO4QO8DL3UynJ-QnG/view?usp=sharing) -->
### 1. [Set Up Spring Boot Barebones Via JetBrains Tutorial + Example Nav Bar Imported](https://github.com/mhayescs19/p1-mosaic-spring/issues/1) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/#)
A basic menu was implemented. The main challenges was implementing the CSS styling. Temporary inline CSS styling was used to get the menu to function. Created by Michael Hayes <br>
**Contents** <br>
* Basic JetBrains tutorial + Mr. M example code with MainController.java was used to create a homepage with an [example menu](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/fragments/header.html) with [CSS styling](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/fragments/headfile.html#L14) (temporary inline CSS styling imported in headfile to header - Direct use of a .css file seems better).
* A [hyperlink list](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/menuAP.html#L54) on a page that is liked via the menu also sends the user to 4 separate pages that host some FRQs

### 2. [Michael Display Unit 5 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/4) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/michael)
The PasswordGenerator class is implemented onto an HTML page with the corresponding inputs for a prefix and length of randomized string of characters to generate a unique password. Additionally the all of the generated passwords are also displayed via a table below the "interactable" area of the page. No CSS styling has been implemented yet. Created by Michael Hayes <br>
**Contents** <br>
* Similar [@GetParam decorators used](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/java/com/example/project/MainController.java#L65) for two separate variables in apPracticeMichael method in MainController.java
* Merged pali lab and table COVID19 api call HTML examples: used [two input fields in a single form](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L10) and [one table](https://github.com/mhayescs19/p1-mosaic-spring/blob/a0dd3df31cad9d3179b6f75ad2dfc7cf3c6841e9/src/main/resources/templates/ap-practice/michael.html#L19) (* see comments in michael.html as I shared my learning and remaining confusions about the HTML tags used)

### 3. [Nakul Display Unit 4 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/nakul)
The Unit 4 AP FRQ contained the directions for writing a class called Consecutive. There was only one part and that was to make a program in this class that takes a string, evaluates the number of times a character appears consecutively for each character in the string, and returns the character that appears the most consecutively and how many times it appeared. The input is taken and the result is displayed via an HTML page and CSS Styling was applied to make the page unique. Created by Nakul Nandhakumar <br>
**Contents** <br>
* [@GetParam Spring Command](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L65) and Thymeleaf Engine was used to receive information from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/nakul.html#L20) with user information entered
* [CSS Styling File](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) with text formatting, colors, etc. added for HTML page's paragrpahs, headers, div blocks, etc.
* [Thymeleaf Objects](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/nakul.html#L30) used to assign and display data to HTML page

### 4. [Nakul Javascript Pythagorean Lab](https://github.com/mhayescs19/p1-mosaic-spring/issues/2) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/labs/Pythagorean)
Created a simple page that uses user input for the legs of a right triangle and uses the pythagorean theoream to calculate the hypotenuse of the right triangle. No CSS Styling for this page yet. Created by Nakul Nandhakumar <br>
**Contents** <br>
* [Pythagoras](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) HTML file for Pythagoreas
* [Embedded Javascript](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) using script tag that takes user input from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/labs/Pythagorean.html#L23) for "a" and "b" values of right-triangle.
* [@GetMapping](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L75) to create root for menuLab and Pythagoras root page and added [LABS](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/fragments/header.html#L11) tab in header file to have the tab appear on the navigation bar.

### 5. [Andrew Frq1 web implementation](https://github.com/mhayescs19/p1-mosaic-spring/issues/3) - [WebPage](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/andrew)
Created a backend that able to intercept an java object using @ModelAttribute to capture the http request, with the given http request I then create the object needed to the frq1 prombelm. I then take the returns from the frq1 class and then use theymleaf to pass it back to the html page. I also used to differnt submit oppitons one one form.
**Content**<br>
* [th:object](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/Andrew/andrew.html#L63) this takes in inputs and adds it to a java object.
* [two subbmit opptions](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/Andrew/andrew.html#L69) this allows you subbmit with either a get mapping or a postmapping.
* [DTO](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/AndrewFrq1/StringStruct.java) a java class with the sole job of storing data to transfer to another class.

### 6. [Sara Display Unit 3 AP FRQ](https://github.com/mhayescs19/p1-mosaic-spring/issues/5) - [HTML PAGE](http://ec2-54-185-111-14.us-west-2.compute.amazonaws.com/ap-practice/sara)
The Unit 3 AP FRQ #1 contained the directions for sending messages to an individual who is planning to attend a party. The code is meant to ask the user if they are attending the party by taking their answer in as a boolean, and if so, to enter what meal they would like to eat using integer values to represent specific items. The input is taken and the result is displayed (string/string concatenation) via an HTML page. Created by Sara Beniwal <br>
**Contents** <br>
* [@GetParam Spring Command](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/java/com/example/project/MainController.java#L90) and Thymeleaf Engine was used to receive information from [form](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/sara.html) with user information entered
* [Thymeleaf Objects](https://github.com/mhayescs19/p1-mosaic-spring/blob/master/src/main/resources/templates/ap-practice/sara.html#L3) used to assign and display data to HTML page

### 7. [Implement Hangman Java Backend From Previous Project](https://github.com/mhayescs19/p1-mosaic-spring/issues/7)
Ported Hangman Model and Control code from a trimester 1 swing based project. Two interfaces were attempted: First a restricted input text field to retrieve a character and second a-z buttons which the user can interact. The latter button clicks were chosen for the final user interaction. Created by Michael Hayes <br>
**Contents**
* Button presses return a value to the backend, control code manages letter check
* Java [control object](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/java/com/example/project/MainController.java#L124) manages checking the letter and displaying the phrase. This object also hosts many other attributes, including a connection to model which is used for phrase
* Control_java is a [global scope](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/java/com/example/project/MainController.java#L18) in order to keep the phrase for multiple guesses since the @GetMapping is a function and local scope applies
* Investigating button returns led to a possible solution using JS but normal [HTML attributes](https://github.com/mhayescs19/p1-mosaic-spring/blob/2243945656fe4b91692345692625775b404a80cb/src/main/resources/templates/labs/hangman.html#L56) were used to return correct letter using value="" incapsulating it in a <form>
