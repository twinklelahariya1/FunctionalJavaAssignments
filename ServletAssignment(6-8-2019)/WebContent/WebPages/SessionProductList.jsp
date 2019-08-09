<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
List of products in the on the app.....

<br>

<form action="SessionProductServlet" method="post">
<input type="button" name="Pizza" value="Pizza">
<input type="text" name="PizzaQty" value="0">
<input type="submit" name="PizzaOrder" value="PizzaOrder">
</form>
<br>
<form action="SessionProductServlet" method="post">
<input type="button" name="Burger" value="Burger">
<input type="text" name="BurgerQty" value="0">
<input type="submit" name="BurgerOrder" value="BurgerOrder">
</form>
<br>
<form action="SessionProductServlet" method="post">
<input type="button" name="Momos" value="Momos">
<input type="text" name="MomosQty" value="0">
<input type="submit" name="MomosOrder" value="MomosOrder">
</form>
<br>
<form action="SessionProductServlet" method="post">
<input type="button" name="Frankie" value="Frankie">
<input type="text" name="FrankieQty" value="0">
<input type="submit" name="FrankieOrder" value="FrankieOrder">
</form>
<br>
<a href="SessionUserCartList.jsp"><input type="submit" value="Go to Cart"></a>
<br>

<br>
<a href="Login.jsp"><input type="submit" value="logout"></a>
</body>
</html>