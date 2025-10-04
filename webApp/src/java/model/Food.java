/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Baster
 */
package model;

public class Food {

    private String id;
    private String foodName;
    private String foodType;
    private String[] foodNutrients;
    private String foodSpicy;
    private int foodPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String[] getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(String[] foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    public String getFoodSpicy() {
        return foodSpicy;
    }

    public void setFoodSpicy(String foodSpicy) {
        this.foodSpicy = foodSpicy;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setNutrient(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
