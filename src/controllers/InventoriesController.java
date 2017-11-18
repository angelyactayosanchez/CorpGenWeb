package controllers;

import models.Category;
import models.Inventory;
import services.CgbService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InventoriesController extends HttpServlet{

    CgbService service;
    String url;

    public InventoriesController() {
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

        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("add")){
                url="newInventory.jsp";
                request.setAttribute("action","add");
            }
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Category category=service.getCategoryById(id);
                request.setAttribute("category",category);
                url="editInventory.jsp";
            }
        }
        if(method.equals("POST")){
            if(action.equals("create")){

                int current_stock=Integer.parseInt(request.getParameter("current_stock"));
                int initial_stock=Integer.parseInt(request.getParameter("initial_stock"));
                int minimal_stock=Integer.parseInt(request.getParameter("minimal_stock"));
                Inventory inventory=service.createInventory(current_stock,initial_stock,minimal_stock);
                //Todavia no tengo ni idea que poner en el front-end
                url="";
            }
            if(action.equals("update")){
                int id=Integer.parseInt(request.getParameter("id"));
                int current_stock=Integer.parseInt(request.getParameter("current_stock"));
                int initial_stock=Integer.parseInt(request.getParameter("initial_stock"));
                int minimal_stock=Integer.parseInt(request.getParameter("minimal_stock"));
                boolean isUpdated=service.updateInventoryStock(id,current_stock,initial_stock,minimal_stock);
                url="";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);

    }

}
