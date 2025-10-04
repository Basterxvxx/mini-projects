/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Food;

/**
 *
 * @author Baster
 */
@WebServlet(urlPatterns = {"/AddFoodServlet"})
public class AddFoodServlet extends HttpServlet {
    ArrayList<Food> foods = new ArrayList<Food>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String foodName = request.getParameter("foodName");
        int foodPrice = Integer.parseInt(request.getParameter("foodPrice"));
        String[] nutrientsArr = request.getParameterValues("foodNutrients");
        String foodType = request.getParameter("foodType");
        String foodSpicy = request.getParameter("foodSpicy");
        
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodPrice(foodPrice);
        food.setFoodNutrients(nutrientsArr);
        food.setFoodType(foodType);
        food.setFoodSpicy(foodSpicy);
        
        HttpSession session = request.getSession();
        ArrayList<Food> foods = (ArrayList<Food>) session.getAttribute("foods");
        if (foods == null) {
                foods = new ArrayList<>();
            session.setAttribute("foods", foods);
}
        
        foods.add(food);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/addFoodSuccess.jsp");rd.forward(request, response);}
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
