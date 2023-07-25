package basic.test;

import basic.model.Product;
import dao.Dao;

public class NewProduct {
    public static void main(String[] args) {
        Product product = new Product("Fogão", 2500.0);

        Dao<Product> dao = new Dao<>(Product.class);

        dao.includeAtomic(product);
    }
}
