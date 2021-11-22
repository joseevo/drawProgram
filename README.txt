Springer Nature's coding challenge


Console Drawing Program
---------------------------------------------------------------------------------------------------------------------------
Simple console version of a drawing program


Overview
---------------------------------------------------------------------------------------------------------------------------

The program was built using Java 15 and Maven resorting to JUnit Framework for testing.

The Program uses the "Main" class to display the instructions for the program usage and 

continuously collect the user's input, splitting and storing each instruction in a list. 

After collecting the user's input, it calls the "InputReader" class with that input to 

receive an instantiation of an object of one of the subclasses of the "Geometry" parent class.

In Main, the "draw" method of the instantiated object is called to validate the 

user's input and return a multi-index array representing the geometric element drawn or 

quits the program according to the user's command.


Build and run
---------------------------------------------------------------------------------------------------------------------------

If you want to run the program in an IDE, such as Eclipse, just need to clone the repository, 
open the project in the IDE and run the Main.java.


usage
---------------------------------------------------------------------------------------------------------------------------

Command 	Description

C w h 	      - Should create a new canvas of width w and height h.

L x1 y1 x2 y2 - Should create a new line from (x1,y1) to (x2,y2) . Currently only horizontal or vertical lines are supported.

		Horizontal and vertical lines will be drawn using the x character.

R x1 y1 x2 y2 - Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2) . 
		Horizontal and vertical lines will be drawn using the x character.

Q 	      - Should quit the program.


tests
---------------------------------------------------------------------------------------------------------------------------

Created some tests to check:
 
	-null or negative input 
	-non integers -wrong shape coordinates 
	-coordinates outside the canvas scope 
	-insufficient number of instructions on the input


notes
---------------------------------------------------------------------------------------------------------------------------

the creation of the canvas is limited to a 4000 width by 4000 height to prevent an OutOfMemoryError (the max value can be extended).

