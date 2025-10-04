<%-- 
    Document   : showAllFood
    Created on : Jul 22, 2025, 2:17:40 PM
    Author     : SciLab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Food" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>รายการอาหารทั้งหมด</h2>
        <%
            ArrayList<Food> foods = (ArrayList<Food>) session.getAttribute("foods");
            for (Food food : foods) {
                out.println(food.getFoodName()+ " " + food.getFoodPrice() + " " +food.getFoodType()+ " " +food.getFoodNutrients() + " "+food.getFoodSpicy()+"<br/>");
            }            
        %>
    </body>
</html>
