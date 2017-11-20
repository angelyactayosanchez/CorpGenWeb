package controllers;

import models.Status;
import models.User;
import services.CgbService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersController extends HttpServlet {

    CgbService service;
    String url;

    public UsersController() {
        super();
        service=new CgbService();
        url="";
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

                request.setAttribute("action","add");
                url=".jsp";
            }
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                User user=service.getUserById(id);
                request.setAttribute("user",user);
                url="editUser.jsp";
            }
        }
        if(method.equals("POST")){
            if(action.equals("create")){

               User user=new User();
               Status status=new Status();
               user.setFirstName(request.getParameter("fName"));
               user.setLastName(request.getParameter("lName"));
               user.setPassword(request.getParameter("password"));
               user.setGender(Integer.parseInt(request.getParameter("gender")));
               user.setAddress(request.getParameter("address"));
               user.setNumber_phone(request.getParameter("phone"));
               user.setEmail(request.getParameter("email"));
               user.setStatus(status.setId(Integer.parseInt(request.getParameter("stId"))));
               String msg=service.createNormalUser(user)?"Creado con exito":"Ocurrio un error";

            }
            if(action.equals("updateToAdmin")){
                int id=Integer.parseInt(request.getParameter("id"));
                Status status=new Status();
                User user=service.getUserById(id);
                user.setStatus(status.setId(Integer.parseInt(request.getParameter("stId"))));
                String msg=service.changeStatus(user)?"Permisos actualizados":"Ocurrio un error";
                log(msg);
            }
            if(action.equals("updateUser")){
                User user=new User();
                user.setFirstName(request.getParameter("fName"));
                user.setLastName(request.getParameter("lName"));
                user.setPassword(request.getParameter("password"));
                user.setGender(Integer.parseInt(request.getParameter("gender")));
                user.setAddress(request.getParameter("address"));
                user.setNumber_phone(request.getParameter("phone"));
                String msg=service.updateUser(user)?"Datos Actualizados":"Ocurrio un error";
                log(msg);
            }
        }
        request.getRequestDispatcher(url).forward(request,response);

    }
}
