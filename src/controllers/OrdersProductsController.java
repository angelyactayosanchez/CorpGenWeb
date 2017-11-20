package controllers;

import models.Order;
import models.OrderProduct;
import models.Product;
import services.CgbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="OrdersProductsController",urlPatterns = "/orderproduct")
public class OrdersProductsController extends HttpServlet {
    String url;
    CgbService service;

    public OrdersProductsController() {
        super();
        service=new CgbService();
        url="";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void processRequest(String method, HttpServletRequest request,HttpServletResponse  response)  throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");

        if (method.equals("GET")) {
            if(action.equals("add")){
                request.setAttribute("action","add");
                url="";
            }
            if(action.equals("edit")){
                OrderProduct orderProduct=service.getOrderProductsById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("orderProduct",orderProduct);
                request.setAttribute("action", "edit");
                url="";
            }
        }
        if(method.equals("POST")){
            if(action.equals("create")){
                OrderProduct orderProduct=new OrderProduct();
                Product product=new Product();
                Order order=new Order();
                orderProduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                orderProduct.setProduct(product.setId(Integer.parseInt(request.getParameter("productId"))));
                orderProduct.setPrice(Double.parseDouble(request.getParameter("product_id")));
                orderProduct.setOrder(order.setId(Integer.parseInt(request.getParameter("orderId"))));
                String msg=service.createOrderProducts(orderProduct)?"Creado con exito":"Ocurrio un problema";
                log(msg);
            }
            if(action.equals("update")){
                OrderProduct orderProduct=service.getOrderProductsById(Integer.parseInt(request.getParameter("id")));
                orderProduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                String msg=service.updateQuantityOrderProducts(orderProduct)?"Actualizado con exito":"Ocurrio un error";
                log(msg);
            }
        }
    }


}
