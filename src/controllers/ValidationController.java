package controllers;

import models.StatusEntity;
import models.User;
import models.UsersEntity;
import org.omg.CORBA.PUBLIC_MEMBER;
import services.CgbService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidationController",urlPatterns = "/validation")
public class ValidationController extends HttpServlet {
    CgbService service=new CgbService();
    public static String LOGINSUCESS="/HomeUser.jsp";
    public static String WELCOME_USER="WelcomeUser.jsp";
    public static String INDEX="/index.jsp";



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
            String user="";
            String password=new String( request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
            UsersEntity u=new UsersEntity();
            String validation="";
            if(!request.getParameter("email").equalsIgnoreCase("") && !request.getParameter("password").equalsIgnoreCase("")){
                try {
                    request.setAttribute("validation",validation);
                    User user1=service.getUserByValidation(email,password);
                    request.setAttribute("user",user1);
                    RequestDispatcher dispatcher=request.getRequestDispatcher(WELCOME_USER);
                        dispatcher.forward(request,response);
                    log("Funciona v:");
                }catch (Exception e){

                    log("Datos incorrectos");
                    validation="Incorrecto";
                    request.setAttribute("validation",validation);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("");
                    dispatcher.forward(request,response);


                }
            }else{
                if (u.validate(user,password)==false){
                    request.setAttribute("validation",validation);

                    log("No hay datos");
                }
            }
    }
}
