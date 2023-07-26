package basic.test.onetomany;

import basic.model.Product;
import basic.model.onetomany.ItemRequest;
import basic.model.onetomany.Request;
import dao.Dao;

public class NewRequest {
    public static void main(String[] args) {
        Dao<Object> dao = new Dao<>();

        Request request  = new Request();
        Product product = new Product("Geladeira", 2789.99);
        ItemRequest itemRequest = new ItemRequest(request, product, 10);

        dao.openTransaction()
                .includeTransaction(request)
                .includeTransaction(product)
                .includeTransaction(itemRequest)
                .closeTransaction();


    }
}
