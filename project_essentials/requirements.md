# Ticket Booking System

## Frontend

- Admin Panel
  - Admin user
      <!-- - registration -->
    - login
  - theatres (venues)
    - CRUD operations
      - 1. Add a venue
      - 2. Update a venue
      - 3. Get venue by id
      - 4. get all venues
      - 5. delete a venue

  - movies (events)
    - CRUD operations
      - 1. add a movie
      - 2. get all movies
      - 3. get movie by id
      - 4. update movie
      - 5. delete movie
      <!-- - 6. reviews (null) -->
      <!-- - 7. ratings -->

  - shows (actual event that will be streamed at a venue)
    - CRUD operations
      - 1. add a show
      - 2. get all shows at a venue
      - 3. get show by id at given venue
      - 4. update show timings
      - 5. delete a show
      - 6. After time has elapsed declare show invalid

  - customer user
    - get all users
    - get user by id

- User Panel (Customer panel)
  - User
    - registration (add User)
    - login
    - get profile (get by id)
    - update password and forget password
    - delete account
  - show booking
    - book ticket
    - delete ticket
    <!-- - cancel booking -->

  - revue (?)

## Backend

    - Admin API

    - User API

## Database

1. User Table (Admin user and customer user)
    - id
    - profile pic
    - firstName
    - lastname
    - age
    - email 
    - passwd
    - role (customer and admin)

2. Events Table
    - id
    - name
    - genre
    - rating
    - duration

3. Venues Table
    - id
    - name
    - addr 
    - seating capacity
    - areFacilitiesAvailable
    
4. Show Table
    - id
    - venueId
    - eventId
    - isEighteenPlus
    - date
    - startTime
    - endtime
    - duration
    - language
    - foodCombos

5. Seat table
    - id
    - seatno
    - venueId
    
6. Booking table
    - id
    - userid
    - showId
    - seatId
    - paymentStatus

7. oldMovies
    - id
    - name 
    - yearOfRelease

8. revue
    - id
    - userId
    - oldMoviesId
    - isInterested(boolean) --only after certain number of votes, the admin will receive the notification to host the movie


## Features

- JWT login for user and admin
- add toasts (toastify) for success and error
