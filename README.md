SEN PROJECT 4: API DOCUMENTATION


/** 
!To be Removed!

Nk is currently working on:
a lot of things, oh no scope creep. thats why im writing it down.


	I need to write code so Succesful sign up updates the database.

	I want the alert that you got some login wrong or something to show on the hmtl. like the text boxes going red.
	that requires a streamwriter i think, to write CSS to the HTML.
	
	Hashing of passwords so they can be hidden in the database

**/

Why we used the Twilio API
We decided to use the Twilio external API.
The Twilio API is a restful API. 
Reasons why we decided on a restful API:
•	Generally, RESTful APIs are easier to understand and uses standard HTTP methods.
•	Since RESTful API’s are know to be stateless, each request is independent from other interactions of the previous state.
•	The RESTful API is easier in terms of data format. While the most common format is JSON, the API can handle multiple different formats, such as HTML and plain text.
•	REST API’s have lower overhead and are thus generally faster.
•	Since REST API’s use standard HTTP methods and status codes, this makes it a lot easier to integrate with the system.
•	REST API’s  support standard HTTP-based security features, such at OAuth for authentication.
•	REST API’s indicates the success or failure of a request with HTTP status codes.
•	REST is stateless, thus it enhances reliability since the system does not need to recover between each transaction.
What does the API do
On the website  https://www.twilio.com/docs/usage/tutorials/how-to-use-your-free-trial-account-namer information can be found on how to use this API, in a short:
•	Twilio provides you with a free unique Twilio number that you can use for your messages. 
•	On this website you will have a dashboard you can use to send messages and view your authentication token as well as your SID
•	Using the authentication token and SID the website provides you with an example snippet of the code that you can use(Seen bellow)
 
 
•	 Since we are building in java, we extracted the java snippet and integrated it into our code.
How is the API integrated
The API uses a callback function that checks the job table to see if any jobs have a job status of unassigned. If it sees a job with no assignment, the API is initiated and all the unassigned technicians are sent a text message(Due to Twilio verification restrictions, and a lack of time to apply, the API only sends text to a virtual number hosted by Twilio)


Project Functions:
User Registration and Authentication

Description: Handles user sign-up, login, and authentication.

Functions:

register_user(): Registers a new user.

login_user(): Authenticates user credentials.

logout_user(): Logs out the user.

SMS Sending

Description: Integrates with the SMS API to send and receive messages.

Functions:

send_sms(): Sends an SMS through the SMS API.

Database Operations

Description: Manages CRUD (Create, Read, Update, Delete) operations for your database.

Functions:

create_job(): Adds a new entry to the database.

get_technicians(): Retrieves all technicians

update_jobs(): Updates an existing database entry.


User Management

Description: Handles user-related operations.

Functions:

get_user_profile(): Retrieves user profile details.

update_user_profile(): Updates user profile information.

delete_user_profile(): Deletes a user profile.

Object Management

Description: Manages your application objects (e.g., products, services).

Functions:

create_object(): Creates a new object.

retrieve_object(): Fetches object details.

update_object(): Updates object information.

Website Interaction

Description: Deals with the web interface and user interactions.

Functions:

handle_form_submission(): Processes form data from the website.

Notifications and Alerts

Description: Manages sending notifications and alerts to users.

Functions:

send_push_notification(): Sends a push notification.
