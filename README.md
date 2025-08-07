# Garage Controller

## Services

### Consumer services

- Allows consumers to avail door to door garbage collection service.
- Consumer can schedule the collection based on his requirement.

### Provider services

- View services: Provides the services like collection of dry, wet and all type of garbage collection.
- View bookings
  - consumer can view his booking by providing a assigned booking id.
  - admins can view all the bookings

### Authentication service

- services to register and verify logged in user
- generate and verify jwt token

## Models

- User: user details
- Collection: collector details
- booking: booking details

## Repositories

- User data
- Collector data
- Booking data

## Flow

### Consumer 
- Register: provide user dto and add in user database ("/register")
- Login: login with creds and get jwt token ("/login")
- View service: ("/services")
  - provide jwt token in request 
  - response will be list of services
  - select the rdirect url to book service