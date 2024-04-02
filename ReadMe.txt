Main.java
----------
This class contains the program that allows users to interact with the database,
such as the signing up, logging in, viewing users, viewing number of friends, logging out, and deleting their account.
This class acts as the control flow and implementation of the Database and UserProfile classes.



Database.java
----------
This class contains the program necessary to process files
that create user profiles and then write all the user profiles
created into a new file that represents the database. This class includes
methods like addUser and removeUser that can alter the users in the
database. Additionally, there is a searchUsers method that returns an
arrayList of all the users that contain what the user searched, for example,
if a user looked up a name that multiple users have, this method would return
an array list with all the users that have that name. There is also a view user
method that shows a users information.

DatabaseTests.java
----------
This class contains methods that allow users to test the functionality of the Database class with different inputs.
There are 5 tests - 
1: Testing the ability to add new users to a test database file.
2: Check for existing usernames in the database (This is used in the actual program to prevent duplicate usernames)
3: When given a username, this tests checks for the correct associated password (This is used to allow login in the actual program)
4: When given a username, this test attempts to log in with an incorrect associated password (This is used to prevent login in the actual program)
5: This test will attempt to log in with a username that doesn't exist. This is used to verify the programs ability to check for existing usernames during the login process.
There are either one or two strings in each test case "username" and "password". Both strings can be modified to whatever the tester wishes to test.

DatabaseInterface.java
----------
This is the interface for the database class,
so it consists of all the methods used in 
database.java.

UserProfile.java
----------
This class constructs a new UserProfile object, 
this object contains information pertaining to that user.
These users will be stored and read by the database class.
This class also contains methods that modify the blocked
and friend users of that UserProfile. This class also contains
a toString method that shows a string representaion of that created object.

GUI.java
This class will implement the transition of user input to the graphical interface that users can interact with.
This will be implemented towards the end of phase 2/start of phase 3.

UserProfileInterface.java
----------
This is the interface for the UserProfile class,
and it contains all the methods inside UserProfile.java.

ClientInterface.java
----------
This is the interface that will be used in phase 2
for clients using our app.

ServerInterface.java
----------
This is the interface that will be used in phase 2
for the main server of our app.

Message.java
----------
This class creates messages with strings and will be used
primarily in phase 2 (proper testing will be done in phase 2
when we actucally implemnet the class).

MessageInterface.java
----------
This is the interface for the message class, again, will be
primarily used for phase 2.
