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





When you create your very first rest application and secure it in the next lecture, you will see a lot of
magic happening behind the scenes.
When you add the springboot security dependency in this lecture, I will walk you through all the important
components that are responsible for that magic when a end user sends a request or a
A restful client sends the request to our rest application.
The very first component in spring security that intercepts that request is the authentication filter.
The authentication filter is a servlet filter class that will see if the user has authenticated.
If not, it will send that request to the authentication manager to check if the details sent by the
user are correct.
If the username and password are valid, the authentication manager in turn uses authentication, provided
this is where the login logic or the authentication logic is defined.
The authentication provider will not fetch the user details from the database or from L dap or in memory.
It will use user details service for that purpose.
It also uses a password.
Encoder because we don't want to store passwords in plain text so the passwords will be encoded, the incoming
password from the user will be encoded and then the comparison is done.
Once the authentication provider checks, if the authentication details, the username, password, etc,
are correct, then it will send the appropriate response back to the authentication manager.
Authentication manager hands it back to the authentication filter if the user details are OK.
If the authentication succeeded.
The authentication filter will use a authentication success handler and stores that authentication
information the user entity it self in a security context.
In an instance of security context, if the authentication failed, it will use the authentication failure
handler to send the appropriate response back to the client.
So remember these six components authentication filter, authentication manager, authentication provider.
This is where the login logic is defined.
The user details service is responsible for fetching the user information.
It could be from L dap it could be from an authorization server of Oauth it could be a database, in-memory,
etc. And then the password encoder is responsible for encoding the passwords.
Finally, the security context is where the user information is stored for future.
Let's look at the spring docs and see how these classes will look like if you go to Google and simply
search for spring authentication.
Filter.
Click on this class here authentication filter, you will go to the docs i have already opened all of this.
The spring authentication filter is the only class.
The rest of them are interfaces.
And this class implements the Java X dot
Servelet dot filter.
It is a simple.
Servelet filter that filters the incoming requests.
It checks if the user has already logged in, if he has already logged in from the security context
it knows about it, then it will not use all of this mechanism.
Again, if he is sending the user name and password, if he hasn't already logged in, then it will
start using all of these components.
Next is the authentication provider.
This is an interface, it has a method called authenticate.
This is the method the authentication filter will invoke by passing in the user name and password through
this authentication object.
This guy uses that authentication manager.
Then the authentication manager in turn uses user details, service and the password encoder
And finally, if the login happens successfully, authentication happens successfully, the Servelet
filter authentication filter will store that information in this security context as authentication
object, as you can see, except for the filter, everything else here is an interface.
So Spring provides some default implementations for all of these for password encoder.
There are tons of implementations in the spring security crypto package, as you will see later o
for the user details service the authentication manager and authentication provider.
There are default implementations that will be enabled when you start using spring security automatically
those implementations will be enabled and we can customize if we want to write our own user details
service, which is very common, we will.
Over right this
This will implement this user detail service and do it.
Same for the authentication manager.
If you want to customize authentication manager, you simply write your own authentication manager.
As you will see in lectures later on.
You can configure all this stuff if you don't want to use the defaults.
So remember, these key components filter manager provider a provider.
This part here is very important, the authentication provider, because we can define our own authentication
logic inside the authentication provider by implementing such a class.
And the user details service is also important because we will be creating our own user detail service
that can fetch the information from the database, etc..
We will be using inbuilt password encoders which can encode and decode the password for us.
Finally, the security context is internally used by authentication filter to store the information.
The user information once the authentication is successful.


