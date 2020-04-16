<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2> Flight Details </h2>
Airlines: ${reservation.flight.operatingAirlines} <br/>
Flight No: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival Time: ${reservation.flight.arrivalCity}<br/>
Date of Departure: ${reservation.flight.dateOfDeparture}<br/>
Estimated Departure Time : ${reservation.flight.estimatedDepartureTime } <br/>

<h2> Passenger Details </h2>

First Name: ${reservation.passanger.firstName} <br/>
Last Name: ${reservation.passanger.lastName} <br/>
Email: ${reservation.passanger.email} <br/>
Phone: ${reservation.passanger.phone} <br/>


<form action="completeCheckIn" method = "post">
Enter the Number of Bags You Want to Check in: <input type = "text" name = "numberOfBags"/>
<input type = "hidden" value="${reservation.id}"> 
<input type = "submit" value = "Check In">
</form>
</body>
</html>