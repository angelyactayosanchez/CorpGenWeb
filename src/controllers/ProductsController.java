package controllers;

import models.Category;
import models.Product;
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

@WebServlet(name = "ProductsController",urlPatterns = "/products")
public class ProductsController extends HttpServlet {
    CgbService service=new CgbService();
    String url;

    public ProductsController() {
        super();
        service=new CgbService();
        url="";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest("GET",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest("POST",request,response);
    }


    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(method.equals("GET")){
            if(action.equals("edit")){
                int id=Integer.parseInt(request.getParameter("id"));
                Product product=service.getProductById(id);
                request.setAttribute("product",product);

            }
            if(action.equals("info")){

               // request.setAttribute("action","add");
                HttpSession session=request.getSession();
                int id=(int)session.getAttribute("id");
                int idProduct=Integer.parseInt(request.getParameter("id"));

                Product product=service.getProductById(idProduct);
                request.setAttribute("product",product);
                Category category=service.getCategoryById(product.getCategory().getId());
                request.setAttribute("category",category);
                url="showProductInfo.jsp";

            }
            if(action.equals("index")){
                HttpSession session=request.getSession();
                int id=(int)session.getAttribute("id");
                User user=service.getUserById(id);
                request.setAttribute("user",user);
                List<Product> products=service.getAllProducts();
                request.setAttribute("products",products);
                url="panelProducts.jsp";

            }

        }
        if(method.equals("POST")){
            if(action.equals("create")){
                Product product=new Product();
                Category category=new Category();
                product.setBrand(request.getParameter("brand"));
                product.setDescription(request.getParameter("description"));
                product.setName(request.getParameter("name"));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setCategory(category.setId(Integer.parseInt(request.getParameter("cateId"))));

               String msg=service.createProduct(product)?"Creado con exito":"Hubo un problema";
               log(msg);

            }
            if(action.equals("update")){
               Product product=new Product();
               product.setId(Integer.parseInt(request.getParameter("id")));
               product.setPrice(Double.parseDouble(request.getParameter("price")));
               product.setCategory(new Category().setId(Integer.parseInt(request.getParameter("cateID"))));
               product.setName(request.getParameter("name"));
               product.setDescription(request.getParameter("description"));
               product.setScore(Integer.parseInt(request.getParameter("score")));
               String msg=service.updateProduct(product)?"Actualizado con exito":"Hubo un problema";
               log(msg);

            }

            //deberia redirigirse a un panel de control de un administrador
            url="";
        }
        request.getRequestDispatcher(url).forward(request,response);
    }

}
