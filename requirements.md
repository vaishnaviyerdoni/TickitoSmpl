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
2. Events Table
3. Venues Table
4. Show Table
5. Seat table
6. Booking table

## Features

- JWT login for user and admin
- add toasts (toastify) for success and error
