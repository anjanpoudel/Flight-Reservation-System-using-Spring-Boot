<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Complete Reservation </title>
</head>
<body>
	<h2> Complete Reservation </h2>
	Airlines: ${flight.operatingAirlines} <br/>
	Departure City: ${flight.departureCity} <br/>
	Arrival City: ${flight.arrivalCity} <br/>
	
	<form action="completeReservation" method="post">
		<pre>
		<h2> Passenger Details: </h2>
		First Name: <input type = "text" name = "passangerFirstName"/>
		Last Name: <input type = "text" name = "passangerlastName"/>
		Email: <input type = "text" name = "passangerEmail"/>
		Phone: <input type = "text" name = "passangerPhone"/> 
		
		<h2> Card Details: </h2>
		Name:  <input type = "text" name = "nameOnTheCard"/>
		Card Number :  <input type = "text" name = "cardNumber"/>
		Expiry Date:  <input type = "text" name = "expirationDate"/>
		Three Digit Sec Code:  <input type = "text" name = "securityCode"/>
		<input type = "hidden" name= "flightId" value = "${flight.id}">
		<input type = "submit" value = "confirm"/>
		</pre>
	</form>
</body>
</html>