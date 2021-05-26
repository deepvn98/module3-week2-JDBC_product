package controller;

import model.Product;
import service.ProductInterface;
import service.ProductJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductInterface productService = new ProductJDBC();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if (action==null){
           action ="";
       }
       switch (action){
           case "create":
               showFormCreateProduct(request, response);
               break;
           case "edit":
               showFormEdit(request, response);
               break;
           case "delete":
               showFormDelete(request, response, "product/delete.jsp");
               break;
           default:
               showAll(request, response);
               break;
       }

    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response, String s) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(s);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductByID(id);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductByID(id);
        request.setAttribute("product",product);
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = (int) (Math.random()*1000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("desc");
        String produce = request.getParameter("produce");
        Product product = new Product(id,name,price,desc,produce);
        this.productService.create(product);
        response.sendRedirect("/ProductServlet");
    }

    private void showFormCreateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> productList = productService.showAll();
        request.setAttribute("danhsach",productList);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "create":
               createProduct(request,response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String describer = request.getParameter("describer");
                String producer = request.getParameter("producer");
                Product product = new Product(id,name,price,describer,producer);
                productService.update(id,product);
                response.sendRedirect("/ProductServlet");
                break;
            case "delete":
                int id1 = Integer.parseInt(request.getParameter("id"));
                Product product1 = productService.getProductByID(id1);
                if (product1!=null){
                    productService.remove(id1);
                    response.sendRedirect("/ProductServlet");
                }else {
                    response.sendRedirect("error-404.jsp");
                }
                break;
            default:
                showAll(request, response);
                break;
        }

    }
}
