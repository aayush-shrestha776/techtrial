package com.TechSansar.controller;

import com.TechSansar.model.ProductModel;
import com.TechSansar.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductModel> product = productService.getAllProducts();

        if (product == null || product.isEmpty()) {
            req.setAttribute("showSkeleton", true);
        } else {
            req.setAttribute("product", product);
            req.setAttribute("showSkeleton", false);
        }

        req.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(req, resp);
    }
}

