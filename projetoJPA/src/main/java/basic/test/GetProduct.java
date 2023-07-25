package basic.test;

import basic.model.Product;
import dao.Dao;

import java.util.List;

public class GetProduct {
    public static void main(String[] args) {
        Dao<Product> dao = new Dao<>(Product.class);
        List<Product> products = dao.getAll();

        for (Product product : products) {
            System.out.println("ID: " + product.getId() + " Name: " + product.getName());
        }
    }
}
