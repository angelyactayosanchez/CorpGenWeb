package controllers;

import models.InventoriesTransaccion;
import models.User;
import services.CgbService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ITController",urlPatterns = "/it")
public class ITController extends HttpServlet {
        CgbService service;
        String url="";

    public ITController() {
        super();
        service=new CgbService();
       url="";
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest("GET",req,resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest("POST",req,resp);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){

            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                InventoriesTransaccion transaccion=service.getTransaccionBy(id);
                request.setAttribute("transaccion",transaccion);
                request.setAttribute("action","edit");
                url="editIT.jsp";
            }

            if(action.equals("create")){
               // request.setAttribute("action","create");
                url="newIT.jsp";
                request.setAttribute("action","create");
            }

        }
        if(method.equals("POST")){
            if(action.equals("create")){
                InventoriesTransaccion transaccion=new InventoriesTransaccion();
                User user=new User();
                transaccion.setStatus(request.getParameter("status"));
                transaccion.setCreatedAt(request.getParameter("createdAt"));
                transaccion.setCreatedBy(user.setCreatedBy(Integer.parseInt(request.getParameter("userId"))));
                transaccion.setUpdatedAt(request.getParameter("updatedAt"));
                transaccion.setUpdatedBy(user.setUpdatedBy(Integer.parseInt(request.getParameter("updateByID"))));
                String msg=service.createInvTransaccion(transaccion)?"Creado con exito":"Hubo un error";
                log(msg);

            }
            if(action.equals("update")){
               InventoriesTransaccion transaccion=new InventoriesTransaccion();
                transaccion.setId(Integer.parseInt(request.getParameter("id")));
                transaccion.setStatus(request.getParameter("status"));
                transaccion.setUpdatedAt(request.getParameter("updatedAt"));
                transaccion.setUpdatedBy(new User().setId(Integer.parseInt(request.getParameter("updatedBy"))));
                String msg=service.updateInvTransaccion(transaccion)?"Actualizado con exito":"Hubo un error";
                log(msg);
            }
            //Debe ir a un panel de control o algo asi v:
            url="";
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
