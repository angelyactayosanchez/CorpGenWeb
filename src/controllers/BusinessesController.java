package controllers;

import models.Business;
import services.CgbService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "BusinessesController", urlPatterns = "/businesses")
public class BusinessesController extends javax.servlet.http.HttpServlet {
    CgbService service;
    String url;

    public BusinessesController() {
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

    private void processRequest(String method, HttpServletRequest request,HttpServletResponse  response)  throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");

        if(method.equals("GET")) {
            /* Index Action
            */if(action.equals("index")) {
                List<Business> businesses = service.getAllBusiness();
                request.setAttribute("businesses", businesses);
                url = "listBusinesses.jsp";
            }
            if(action.equals("show")) {
                // int id = Integer.parseInt(request.getParameter("id"));
                String ruc= request.getParameter("ruc");
                Business business = service.getBusinessByRUC(ruc);
                request.setAttribute("business", business);
                url = "showBusinessInfo.jsp";
            }
            if(action.equals("new")) {
                url = "newBusiness.jsp";
            }
            if(action.equals("edit")) {

                String ruc=request.getParameter("ruc");
                Business business = service.getBusinessByRUC(ruc);
                request.setAttribute("business", business);
                url = "editBusiness.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                /*
                String ruc=request.getParameter("ruc");
                String name = request.getParameter("name");
                String address=request.getParameter("address");
                String phone=request.getParameter("phone");
                String email=request.getParameter("email");
                Business business=service.createBusiness(ruc,name,address,phone,email);*/
                Business b=new Business();
                b.setRuc(request.getParameter("ruc"));
                b.setName(request.getParameter("name"));
                b.setAddress(request.getParameter("address"));
                b.setPhone(request.getParameter("phone"));
                b.setEmail(request.getParameter("email"));
                String msg=service.createBusiness(b)?"Creado con exito":"Hubo un error";
                log(msg);
                List<Business> businesses = service.getAllBusiness();
                request.setAttribute("businesses", businesses);
                url = "listBusinesses.jsp";
            }
            if(action.equals("update")) {
                String ruc=request.getParameter("ruc");
                String name = request.getParameter("name");
                String address=request.getParameter("address");
                String phone=request.getParameter("phone");
                String email=request.getParameter("email");

                boolean isUpdated = service.updateBusiness(ruc,name,address,phone,email);
                List<Business> businesses = service.getAllBusiness();
                request.setAttribute("businesses", businesses);
                url = "listBusinesses.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }


}