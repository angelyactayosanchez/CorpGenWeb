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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ValidationController",urlPatterns = "/validation")
public class ValidationController extends HttpServlet {
    CgbService service=new CgbService();
    String url="";
    public static String LOGINSUCESS="homeUser.jsp";
    public static String WELCOME_USER="WelcomeUser.jsp";
    public static String INDEX="index.jsp";
    public static String LOGIN="login.jsp";



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");

            String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
            UsersEntity u=new UsersEntity();
            String validation="";
            if(!request.getParameter("email").equalsIgnoreCase("") && !request.getParameter("password").equalsIgnoreCase("")){

                    request.setAttribute("validation",validation);
                    User user1=service.getUserByValidation(email,password);

                    request.setAttribute("user",user1);

                HttpSession session =   request.getSession();
                session.setAttribute("usuario",user1);
                session.setAttribute("id",user1.getId());
                session.setAttribute("password",user1.getPassword());
                session.setAttribute("name",user1.getFirtName());
                session.setAttribute("name2",user1.getLastName());
                session.setAttribute("address",user1.getAddress());
                session.setAttribute("numPhone",user1.getNumber_phone());
                session.setAttribute("gender",user1.getGender());
                session.setAttribute("emai",user1.getEmail());
                session.setAttribute("statusID",user1.getStatus().getType());


                RequestDispatcher dispatcher=request.getRequestDispatcher("homeUser.jsp");
                        dispatcher.forward(request,response);
                    log("Funciona v:");


            }else{
                if (u.validate(email,password)==false){
                    request.setAttribute("validation",validation);

                    log("No hay datos");
                    url="index.jsp";
                }
            }/*
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
                url="homeUser.jsp";
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
     }/**/
    }
}

