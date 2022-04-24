# Rest-Api-Security
The Repository contains all the concept which comes under spring-security 


Authentication is the process of letting an application know who we are. Typically, when we access any application, for example, banking application, the first step is to
log in by providing our user ID and password.
The banking application will validate that user id and password. This process is called authentication. If the authentication is successful, then we can access other pages in the application.
If not, we cannot.

Next is authorization, once a user logs in or authenticate, how does the application know , how much  access the user or another application has?
That is where authorization jumps in and it uses roles to do authorization.
Each role is mapped to certain
URLs or methods in the application, and the user with certain roles will have access to certain
functionality within the application and certain users will not have access to certain functionality
in the application.


There are different ways of authentication in the HTTP or Web application world, starting with basic authentication, form based authentication, and then in the restful API world we can implement. Oauth single sign on where we implement authentication and authorization for all applications within our organization through single Sign on. We can also create our own custom login mechanism instead of using basic Form or Oauth we can create our own authentication and authorization process as well.
So authentication is the process of letting an application know who you are, whether you have access or not. An authorization is the process of the application determining how much access you have depending on the role that is assigned to your user. Next comes confidentiality. This is where applications ensure that the data they are sharing is not vulnerable to hackers. For example, you are logging in providing authentication details. What if a friendly neighborhood hacker hacks your username and password over the network?

That is where encryption and decryption comes in.
The simplest way of encrypting and decrypting is by using his HTTP.
Yes, once the communication is authenticated sorry
Once the communication is encrypted, the data that is exchanged, even if the hacker captures it,
he will not be able to make sense out of it because these application the sender application will use
a certain key public key and sends that user details.
And then the application will use a private key which will decrypt those details.
Even if a hacker gets the details in between, he will not be able to do anything with those details
unless he has the private key.
That is nothing but maintaining the confidentiality of the data being exchanged across applications
or from a user to the application.
Next comes integrity.

Integrity is where applications can ensure that whatever data is being exchanged is really coming from
the Same user that is expecting or the application it is expecting and it is not changed in the process.
For example, if this hacker captures the authentication details or any data, if he put something else
in that data and sends it to the banking application, the banking application should know that the
data was not tweaked and the integrity is still maintained.
That is where signatures come in later on.
When you work with Oauth and JWT, you will learn about authorisation server and resource server.
