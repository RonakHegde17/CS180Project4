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
