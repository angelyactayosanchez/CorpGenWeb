package controllers;

import models.Status;
import models.StatusEntity;
import models.User;
import models.UsersEntity;
import services.CgbService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersController",urlPatterns = "/users")
public class UsersController extends HttpServlet {

    CgbService service=new CgbService();
    String url="";

    public UsersController() {
        super();
        service=new CgbService();
        url="";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       String action=request.getParameter("action");
        if(action.equals("create")){

            User user=new User();
            Status status=new Status();
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setPassword(request.getParameter("password"));
            user.setGender(Integer.parseInt(request.getParameter("gender")));
            user.setAddress(request.getParameter("address"));
            //user.setNumber_phone(request.getParameter("phone"));
            user.setEmail(request.getParameter("email"));
            user.setStatus(status.setId(2));
            String msg=service.createNormalUser(user)?"Creado con exito":"Ocurrio un error";
            log(msg);
            url="WelcomeUser.jsp";
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
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lName"));
            user.setPassword(request.getParameter("password"));
            user.setGender(Integer.parseInt(request.getParameter("gender")));
            user.setAddress(request.getParameter("address"));
            user.setNumber_phone(request.getParameter("phone"));
            String msg=service.updateUser(user)?"Datos Actualizados":"Ocurrio un error";
            log(msg);
        }
        request.getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse  response)  throws javax.servlet.ServletException, IOException {

        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("new")){

                request.setAttribute("action","new");
                url="newUser.jsp";
            }
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                User user=service.getUserById(id);
                request.setAttribute("user",user);
                url="editUser.jsp";
            }
            if(action.equals("index")){
                User user=service.getUserById(Integer.parseInt(request.getParameter("userID")));
                request.setAttribute("user",user);
                url="WelcomeUser.jsp";
            }
        }
        if(method.equals("POST")){



        }
        request.getRequestDispatcher(url).forward(request,response);

    }
}
