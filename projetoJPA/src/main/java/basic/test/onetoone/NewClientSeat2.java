package basic.test.onetoone;

import basic.model.onetoone.Client;
import basic.model.onetoone.Seat;
import dao.Dao;

public class NewClientSeat2 {
    public static void main(String[] args) {
        Seat seat = new Seat("5F");
        Client client = new Client("Paulo", seat);

        Dao<Object> dao = new Dao<>();

        dao.openTransaction()
                .includeTransaction(seat)
                .includeTransaction(client)
                .closeTransaction();
    }
}
