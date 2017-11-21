package controllers;

import models.StatusEntity;
import models.User;
import models.UsersEntity;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidationController",urlPatterns = "/validation")
public class ValidationController extends HttpServlet {
    CgbService service=new CgbService();
    String url="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String email=request.getParameter("email");
            String user="";
            String password=request.getParameter("password");
            UsersEntity u=new UsersEntity();
            StatusEntity statusEntity=new StatusEntity();
            String validation="";
            if(!request.getParameter("email").equalsIgnoreCase("") && !request.getParameter("password").equalsIgnoreCase("")){
                try {
                    request.setAttribute("validation",validation);
                    User userlog=service.getUserByValidation(email,password);
                    request.setAttribute("userlog",userlog);
                    url="loginSucces.jsp";
                    log("Funciona v:");
                }catch (Exception e){

                    log("Datos incorrectos");
                    validation="Incorrecto";
                    request.setAttribute("validation",validation);
                    url="login.jsp";

                }
            }else if (u.validate(user,password)==false){
                request.setAttribute("validation",validation);
                url="login.jsp";
                log("No hay datos");
            }

    request.getRequestDispatcher(url).forward(request,response);
    }
}
