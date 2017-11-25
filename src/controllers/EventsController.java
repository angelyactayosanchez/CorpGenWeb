package controllers;

import models.Event;
import models.Location;
import models.Product;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventsController",urlPatterns = "/event")
public class EventsController extends HttpServlet {
    CgbService service=new CgbService();
    String url="";

    public EventsController() {
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
        HttpSession session=request.getSession();
        if(method.equals("GET")){
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Event event =service.getPromotionById(id);
                request.setAttribute("event", event);
                url="events.jsp";
            }
            if(action.equals("info")){
                //request.setAttribute("action","add");
                int id=Integer.parseInt(request.getParameter("pId"));
                Event event =service.getPromotionById(id);

                Location location=service.getLocationById(event.getLocation().getId());
                request.setAttribute("location",location);
                request.setAttribute("event", event);
                url="infoPromo.jsp";
            }
            if(action.equals("index")){

                List<Event> events =service.getAllEvents();

                request.setAttribute("events", events);
                url="events.jsp";
            }

        }
        if(method.equals("POST")){
            if(action.equals("create")){
               Event event =new Event();
               Location location=new Location();
               Product product=new Product();
               event.setId(Integer.parseInt(request.getParameter("id")));
               event.setName(request.getParameter("name"));
               event.setState(request.getParameter("state"));

               event.setTimeStart(request.getParameter("timeStart"));
               event.setTimeFinish(request.getParameter("timeFinish"));
               event.setLocation(location.setId(Integer.parseInt(request.getParameter("id"))));
               event.setProduct(product.setId(Integer.parseInt(request.getParameter("id"))));

               String  msg=service.createPromotion(event)?"Creado con exito":"Hubo un error";
               log(msg);


            }
            if(action.equals("update")){
                int id=Integer.parseInt(request.getParameter("id"));
                Event event =service.getPromotionById(id);
                event.setState(request.getParameter("state"));
                String msg=service.changeStatusPromo(event)?"Actualizado con exito":"Hubo un problema";
                log(msg);

            }

        }
        request.getRequestDispatcher(url).forward(request,response);
    }


}
