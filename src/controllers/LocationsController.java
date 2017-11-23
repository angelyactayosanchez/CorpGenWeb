package controllers;


import models.Business;
import models.Location;
import models.User;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationsController",urlPatterns = "/location")
public class LocationsController extends HttpServlet {
        CgbService service;
        String url;
        public static String  LOCATION_INDEX_URI="listLocations.jsp";

    public LocationsController() {
        super();
        service=new CgbService();
        url="";
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse  response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("index")){
                User user=service.getUserById(Integer.parseInt(request.getParameter("userID")));
                request.setAttribute("user",user);
                Business business=service.getBusinessByRUC(request.getParameter("ruc"));
                request.setAttribute("business",business);
                List<Location> locations=service.getLocationsByRuc(request.getParameter("ruc"));
                request.setAttribute("locations",locations);
                url="panelLocations.jsp";
            }
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Location location=service.getLocationById(id);
                request.setAttribute("location",location);

            }
            if(action.equals("add")){
                request.setAttribute("action","add");
               
            }

        }
        if(method.equals("POST")){
            
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
