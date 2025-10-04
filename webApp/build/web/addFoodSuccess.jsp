<%-- 
    Document   : addFoodSuccess
    Created on : Jul 15, 2025, 2:36:42 PM
    Author     : Baster
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Food Success</title>
</head>
<body>
    <h2>addfood_succeed</h2>
    <hr/>
<%
    ArrayList<Food> foods = (ArrayList<Food>) session.getAttribute("foods");
    if (foods == null || foods.isEmpty()) {
%>
    <p>No food data found.</p>
<%
    } else {
        for (Food food : foods) {
            // รวม foodNutrients จาก String[] เป็นข้อความคั่นด้วย comma
            String nutrients = "";
            if(food.getFoodNutrients() != null) {
                nutrients = String.join(", ", food.getFoodNutrients());
            }
%>
    <p>
        <strong>Name:</strong> <%= food.getFoodName() %><br/>
        <strong>Price:</strong> <%= food.getFoodPrice() %> Bath<br/>
        <strong>Type:</strong> <%= food.getFoodType() %><br/>
        <strong>Nutrients:</strong> <%= nutrients %><br/>
        <strong>Spicy Level:</strong> <%= food.getFoodSpicy() %>
    </p>
    <hr/>
<%
        }
    }
%>
    <a href="addFood.html">addFood_again</a>
</body>
</html>