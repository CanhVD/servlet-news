package controller.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import utils.HttpUtil;

import java.io.IOException;

@WebServlet(urlPatterns = {"/api/v1/categories"})
public class CategoryController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUtil.of(request.getReader()).toModel(Category.class);
        for (Long id : category.getIds()) {
            System.out.println(id);
        }
    }
}
