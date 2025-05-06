package com.TechSansar.service;

import com.TechSansar.model.ProductModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/TechSansar";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();

        String query = "SELECT * FROM product";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setImageUrl(rs.getString("image_url"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}

