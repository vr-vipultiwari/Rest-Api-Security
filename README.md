# Rest-Api-Security
The Repository contains all the concept which comes under spring-security 


Authentication is the process of letting an application know who we are. Typically, when we access any application, for example, banking application, the first step is to
log in by providing our user ID and password.
The banking application will validate that user id and password. This process is called authentication. If the authentication is successful, then we can access other pages in the application.
If not, we cannot.

Next is authorization, once a user logs in or authenticate, how does the application know how much  access the user or another application has?
That is where authorization jumps in and it uses roles to do authorization.
Each role is mapped to certain
URLs or methods in the application, and the user with certain roles will have access to certain
functionality within the application and certain users will not have access to certain functionality
in the application.
