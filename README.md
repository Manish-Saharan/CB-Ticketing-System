# Ticketing System Application

This is a simple ticketing system application implemented in Java with Spring Boot. The application allows users to purchase train tickets and manage their bookings.

## Features

- Purchase a new ticket
- View receipt for a ticket
- View users and their allocated seats by section
- Remove a user from the train
- Change a user's seat from one section to another

## Technologies Used

- Java
- Spring Boot
- Maven (for dependency management)
- RESTful API

## API Endpoints

- POST /purchaseTicket: Purchase a new ticket
- GET /receipt/{id}: View receipt for a ticket 
- GET /ticketsBySection/{section}: View users and their allocated seats by section
- DELETE /deleteTicket/{id}: Remove a user from the train
- PUT /modifySeat/{id}: Change a user's seat to a new section

## Usage

- To purchase a new ticket, send a POST request to /purchaseTicket with the ticket details in the request body.
- To view a receipt for a ticket, send a GET request to /receipt/{id}.
- To view users and their allocated seats by section, send a GET request to /ticketsBySection/{section}.
- To remove a user from the train, send a DELETE request to /deleteTicket/{id}.
- To change a user's seat to a new section, send a PUT request to /modifySeat/{id}.
