package controllers;

import models.InventoriesTransaccion;
import models.Inventory;
import models.InventoryOperation;
import models.Product;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IOController",urlPatterns = "/ip")
public class IOController extends HttpServlet {
    CgbService service;
    String url;

    public IOController() {
        super();
        service=new CgbService();
        url="";
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest("POST",req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest("GET",req,resp);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(method.equals("GET")){
            if (action.equals("add")){

                request.setAttribute("action","add");
                url="addIO.jsp";
            }
            if(action.equals("edit")){
                InventoryOperation operation=service.getInvOperationById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("operation",operation);
                request.setAttribute("action","edit");
                url="editIO.jsp";
            }
        }
        if(method.equals("POST")){/*
            if (action.equals("create")){
                Inventory inventory=service.getInventoryById(Integer.parseInt(request.getParameter("id")));
                InventoriesTransaccion transaccion=service
                Product product;
                InventoryOperation operation=new InventoryOperation();
                operation.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                operation.setType(Integer.parseInt(request.getParameter("type")));
                operation.setInventory(inventory.setId(Integer.parseInt(request.getParameter("invID"))));

            }*/
        }
        request.getRequestDispatcher(url).forward(request,response);

    }

}
