# ShearUp

An application that helps barbers build a portfolio of abilities, and where clients find barbers faster with the help of a visual dashboard. Aside from being a portfolio site for barbers and a job listing site of their own craft, ShearUp is a matchmaking service for the barbering industry.

## Motivation

During the COVID pandemic clients were having trouble connecting to Barbers. With state restrictions on gathering and businesses being non-operational for a time there needed to be a way to contact your local barber. 
This is when the idea for Shearup was created, by Knoah Cotto. Shearup aims to connect clients with a Barber in a post COVID world. This application is for Barbers to easily promote themselves, their services, and have clients contact them for their services.

## API Reference

* MapboxAPI
Purpose: - ability to dynamically display Barber locations so clients are able to see
https://docs.mapbox.com/api/

* FileStackAPI
Purpose: - ability to upload pictures on
https://www.filestack.com/docs


## Framework used

Built with 
* Spring Boot

## User Stories

### Visitor Story:
- As a visitor, I can visit the landing page, see a login option for both client and barber, as well as a registration option. 
- Visitors will fill out a barber or a client registration form to get full access to features of the application. 
- Clients and Barbers will have different features.
- As a visitor I am able to look at all the Barbers, as well as click on their Barber profile page by clicking on Barber. 
- On the landing page visitors can choose to register as a client or barber.
- Visitors will see error messages for failed login attempts for Clients and Barber form. (Wrong email/password)
- Visitors need to be logged in to access full features of the application. 
- Upon successful registration visitors will be redirected to the login page for client or barber depending on what kind of user they are.

### Client Story:
- When a client uses the login for clients he will be redirected to a client profile page. 
- Authenticate client when logging in
- The logged in client will be able to see their name, email, and bio on the profile page. With the option to upload a picture. 
- The logged in client will be able update their profile image and email if it changes. 
- The logged in client will be able to delete reviews they have given.
- Clients will have a dynamic navbar on their profile page.
- Clients will be able to navigate to a page that displays all Barbers.
- Clients are able to click on a specific Barber and be redirected to the Barber’s profile page. 
- When a logged in client visits the Barber profile page it will have a Map showing location of Barber from MapBox API. Also will display barber working hours.
- On the Barber profile page, clients can see what services Barber provides.
- On the Barber profile page, clients can request to book with a barber.

### Barber Story:
- Authenticate Barber when logging in.
- When a Barber uses the login for Barbers he will be redirected to a Barber profile page.
- The logged in Barber will be able to see his username, name, email, and bio on his page. 
- Barber will have services provided on profile page
- Barber will be able to Add new services as well as edit existing ones.
- Barber will have the option to upload a photo of a specific service.
- Barber will have leads populate on page from clients requesting to book.
- The logged in Barber will be able to see reviews clients have given them
- Barbers will have a dynamic navbar on their profile page.
- Barbers will also have the option to upload a profile picture. Filestack API would be used to upload images.
- On the barber profile page it displays a map from MapBox API with location of barber. 
-Barber will have services provided on profile page

## Features

* Login Authentication for Barber users and Clients users
* Edit profile options for Barber users and Client users
* Barber user can edit their barber details regarding  bio, phone-number, and their hours of operation.
* Barber user can edit their location and have it updated for clients.
* Barber user can add their services with a picture that clients can see. 
* Barber user can see leads populate on profile from clients requesting to book with them.
* Dynamic Navbar that changes with logged in Barbers and Clients
* Clients can leave reviews of Barbers and have it displayed on the client profile.
* Reviews given by client show up in
* Clients can go back and delete reviews
* Star rating system on reviews that allows clients to rate a specific barber.
* Mapbox API used to dynamically display Barber location on Barber profile.
* FileStack API was used to upload pictures.
* Bootstrap Mobile Responsive


## Code Example (Still in progress)

Show what the library does as concisely as possible, developers should be able to figure out how your project solves their problem by looking at the code example. 
Make sure the API you are showing off is obvious, and that your code is short and concise.





