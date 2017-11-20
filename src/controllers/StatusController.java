package controllers;

import models.Status;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatusController" ,urlPatterns = "/status")
public class StatusController extends HttpServlet {
   CgbService service;
   String url;
   public StatusController(){
       super();
       service=new CgbService();
       url="";
   }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Status status=service.getStatusById(id);
                request.setAttribute("status",status);
                request.setAttribute("action","edit");
                url="";
            }
            if(action.equals("add")){
                request.setAttribute("action","add");
                url="";
            }

        }
        if(method.equals("POST")){
            if(action.equals("update")){
               Status status=new Status();
               status.setId(Integer.parseInt(request.getParameter("id")));
               status.setType(request.getParameter("type"));
               status.setDescription(request.getParameter("description"));
               String msg=service.changeStatus(status)?"Actualizado con exito":"Hubo un error";
                log(msg);


            }
            //deberia redirigirse a un panel de control de un administrador
            url="";
        }
        request.getRequestDispatcher(url).forward(request,response);
    }


}
