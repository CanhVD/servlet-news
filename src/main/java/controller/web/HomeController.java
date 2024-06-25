package controller.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import service.impl.CategoryService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home", "/dang-nhap"})
public class HomeController extends HttpServlet {

    private final CategoryService categoryService = new CategoryService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        request.setAttribute("mess", "Mac Pham");
        List<Category> categories = categoryService.getAllCategories();
        Category category = categoryService.getCategoryById(1L);
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}
