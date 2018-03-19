<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kalkulator kredytowy</title>
</head>
<body>
	<form action = "hello" method="post">
		<form action = "hello" method="post">
		<label>Jaka kwota: <input type ="text" id= "amountOfCredit" name= "amountOfCredit"/></label></br>
		<label>Preferowana ilosc rat: <input type ="text" id= "numberOfInstalments" name= "numberOfInstalments"/></label></br>
		<label>Oprocentowanie: <input type ="number" min="1" max="25" step="1" id= "interest" name= "interest" value="0"/></label></br>
		
		<label>Jaka oplata stala: <input type ="text" id= "fixedFee" name= "fixedFee"/></label></br>
		<label>Rodzaj rat: <select name ="typeOfInstalments">
			<option>Malejaca</option>
			<option>Stala</option>
		</select></label></br>
		<input type = "checkbox" name = "makePdf" value = "makePdf">Utworz plik PDF 
		<input type = "submit" value= "wyslij"/>
	</form>
</body>
</html>