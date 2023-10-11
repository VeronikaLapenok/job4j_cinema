# Job4j_cinema (training project)

Author: Veranika Lapianok</br>
Mail: veronika.lapenok.yr@gmail.com

## General description

In this assignment you need to develop a website for buying cinema tickets (one cinema, not a chain, for simplicity). 
Such resources have a lot of logic. Your task is to write only:

* Registration/Login;
* Output of film shows and films;
* Purchasing tickets.

## Technical task

For implementation you need to use: Spring Boot, Thymeleaf, Bootstrap, Liquibase, Sql2o, PostgreSQL.

Representation:

* Home page. Display general information about the resource;
* Schedule. Display sessions and related films. When selecting a specific session, the user is taken to the ticket purchase page;
* Cinema library. Display a list of films;
* Ticket purchase page. Display information about the session and the movie. There are also 2 drop-down lists - one for specifying a row, the other for specifying a place, and buttons “Buy”, “Cancel”;
* Page with the result of a successful ticket purchase. Display a message to the user, for example, “You have successfully purchased a ticket to this place...”;
* Page with the result of an unsuccessful ticket purchase (the ticket has already been purchased). Display a message to the user, for example, “It was not possible to purchase a ticket for the specified seat. It is probably already taken. Go to the ticket booking page and try again.” You need to implement such functionality in the same way as registering a user;
* Registration page;
* Login page.



