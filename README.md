# Rest-Api-Security
The Repository contains all the concept which comes under spring-security 

🌀 Whenever we add springboot dependency to our application. spring security enable form based authentication by default.
                
              -  The default username is "user" and password will print in console every time we start the application.
                
## HOW Basic Auth works ?

When a client hit a server without providing username and password . it will get 401 unauthorized error. 
In order to authenticate the user , server need username and pasword so when put username and password in request header as Basic64 encoded form then server does some 
validation to authenticate the user if authentication successfull it will return 200 ok status.
Basic Auth is good when we access external Api

Drawback of basic auth is that we cannot logout once login because username and password are sent on every request and server has to validate wheather it is correct or not.

🌀 WebSecurityConfigureAdapter is the default configuration class used by spring-security.

🌀 antMatcher() is a method of HttpSecurity, it doesn't have anything to do with authorizeRequests(). Basically, http.antMatcher() tells Spring to only configure HttpSecurity if the path matches the provided pattern.

🌀 Whenever we start our application , spring security creats an user in InMemoryDatabase with username as user and password is randomly generated password.

🌀 Roles are nothing but high level view of users of your application. A Role comprises of several authority or permissions.

🌀 We can also assign multiple roles to single user 

In order to use Role and Permission base using Annotation. we can user @PreAuthorize annotation.


CSRF stands for cross site request fogery , when we develop an appplication with csrf security enabled . sever sent a X-XSRF token to the client in cookies and for every subsequent request it expect that token then only it let the request to access the resources.


# Remember-me is use to configure validity of the session id 













