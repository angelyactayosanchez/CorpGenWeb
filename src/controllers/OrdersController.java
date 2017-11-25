package controllers;

import models.Order;
import models.User;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrdersController",urlPatterns = "/orders")
public class OrdersController extends HttpServlet {

    CgbService service;
    String url="";

    public OrdersController() {
        super();
        service=new CgbService();
        url="";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest("GET",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest("POST",req,resp);
    }


    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){/*
            if(action.equals("show")){
                List<Location> locations=service.getAllLocations();
                request.setAttribute("locations",locations);

            }*/
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Order order=service.getOrderById(id);
                request.setAttribute("order",order);

            }
            if(action.equals("delete")){
                int id=Integer.parseInt(request.getParameter("id"));
                Order order=service.getOrderById(id);
                request.setAttribute("order",order);

            }
            if(action.equals("add")){
                request.setAttribute("action","add");
            }

        }
        if(method.equals("POST")){
            if(action.equals("create")){
                User user=new User();
                String state=request.getParameter("state");
                String createdAt=request.getParameter(request.getParameter("createdAt"));
                int createdBy=Integer.parseInt(request.getParameter("createdBy"));
                String updatedAt=request.getParameter("updatedAt");
                int updatedBy=Integer.parseInt(request.getParameter("updatedBy"));
               // Order order=service.createOrder(state,createdAt,user.setCreatedBy(createdBy),updatedAt,user.setUpdatedBy(updatedBy));
                url="index1.jsp";
            }
            if(action.equals("delete")){
                int id=Integer.parseInt(request.getParameter("id"));
                String state=request.getParameter("state");
                String updatedAt=request.getParameter("updatedAt");
                int updatedBy=Integer.parseInt(request.getParameter("updatedBy"));
                //Order order=service.getOrderById(id);
                boolean isUpdated=service.removeOrder(id,state,updatedAt,updatedBy);
                url="";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
