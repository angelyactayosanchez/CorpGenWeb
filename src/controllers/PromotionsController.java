package controllers;

import models.Location;
import models.Product;
import models.Promotion;
import models.User;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PromotionsController",urlPatterns = "/promotion")
public class PromotionsController extends HttpServlet {
    CgbService service;
    String url;

    public PromotionsController() {
        super();
        service=new CgbService();
        url="";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest("POST",request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("GET",request,response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Promotion promotion=service.getPromotionById(id);
                request.setAttribute("promotion",promotion);
                url="promotions.jsp";
            }
            if(action.equals("add")){
                request.setAttribute("action","add");
            }
            if(action.equals("index")){
                //HttpSession session=request.getSession();

                List<Promotion> promotions=service.getAllPromotions();

                request.setAttribute("promotions",promotions);
                url="promotions.jsp";
            }

        }
        if(method.equals("POST")){
            if(action.equals("create")){
               Promotion promotion=new Promotion();
               Location location=new Location();
               Product product=new Product();
               promotion.setId(Integer.parseInt(request.getParameter("id")));
               promotion.setName(request.getParameter("name"));
               promotion.setState(request.getParameter("state"));

               promotion.setTimeStart(request.getParameter("timeStart"));
               promotion.setTimeFinish(request.getParameter("timeFinish"));
               promotion.setLocation(location.setId(Integer.parseInt(request.getParameter("id"))));
               promotion.setProduct(product.setId(Integer.parseInt(request.getParameter("id"))));

               String  msg=service.createPromotion(promotion)?"Creado con exito":"Hubo un error";
               log(msg);


            }
            if(action.equals("update")){
                int id=Integer.parseInt(request.getParameter("id"));
                Promotion promotion=service.getPromotionById(id);
                promotion.setState(request.getParameter("state"));
                String msg=service.changeStatusPromo(promotion)?"Actualizado con exito":"Hubo un problema";
                log(msg);

            }

        }
        request.getRequestDispatcher(url).forward(request,response);
    }


}
