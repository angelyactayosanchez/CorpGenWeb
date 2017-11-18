package controllers;

import models.Business;
import models.Category;
import services.CgbService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CategoriesController",urlPatterns = "/category")
public class CategoriesController extends HttpServlet {

    CgbService service;
    String url;

    public CategoriesController() {
        super();
        service = new CgbService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse  response)  throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");

        if(method.equals("GET")) {
            /*
            if(action.equals("index")) {
                List<Category> categories = service.getAllCategories();
                request.setAttribute("categories", categories);
                url = "listCategories.jsp";
            }*/
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
               Category category=service.getCategoryById(id);
                request.setAttribute("category", category);
                url = "showCategoryInfo.jsp";
            }
            if(action.equals("new")) {
                url = "newCategory.jsp";
            }
            if(action.equals("edit")) {
                int id=Integer.parseInt(request.getParameter("id"));
                Category category=service.getCategoryById(id);
                request.setAttribute("category", category);
                url = "editCategory.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String description=request.getParameter("description");
                Category category=service.createCategory(description);
                List<Category> categories = service.getAllCategories();
                request.setAttribute("categories", categories);
                url = "listCategories.jsp";
            }
            if(action.equals("update")) {
                int id=Integer.parseInt(request.getParameter("id"));
                String description=request.getParameter("description");

                boolean isUpdated = service.updateCategory(id,description);
                List<Category> categories = service.getAllCategories();
                request.setAttribute("categories", categories);
                url = "listCategories.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
