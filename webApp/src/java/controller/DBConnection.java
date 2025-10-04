/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Food;

public class DBConnection {

    public boolean insertNewFood(Food food) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/srikai", "root", "UBU_12345678");

            Statement statement = connection.createStatement();

            String query = "INSERT INTO food (name, price, type, nutrient, spicyLevel) VALUES ('"
                    + food.getFoodName() + "', "
                    + food.getFoodPrice() + ", '"
                    + food.getFoodType() + "', '"
                    + food.getFoodNutrients() + "', '"
                    + food.getFoodSpicy() + "')";
            System.out.println("SQL: " + query);

            int i = statement.executeUpdate(query);
            if (i != 0) {
                result = true;
            }

            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;
    }

    public List<Food> retrieveAllFood() {
        List<Food> foods = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/srikai", "root", "UBU_12345678");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM food");

            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodName(resultSet.getString("name").trim());
                food.setFoodPrice(resultSet.getInt("price"));
                food.setFoodType(resultSet.getString("type").trim());
                food.setNutrient(resultSet.getString("nutrient").trim());
                food.setFoodSpicy(resultSet.getString("spicyLevel").trim());
                foods.add(food);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return foods;
    }
}
