package basic.test.onetomany;

import basic.model.onetomany.ItemRequest;
import basic.model.onetomany.Request;
import dao.Dao;

public class GetRequest {
    public static void main(String[] args) {
        Dao<Request> dao = new Dao<>(Request.class);
        Request request = dao.getById(1L);

        for (ItemRequest item : request.getItens()) {
            System.out.println(item.getQuantity());
        }
    }
}
