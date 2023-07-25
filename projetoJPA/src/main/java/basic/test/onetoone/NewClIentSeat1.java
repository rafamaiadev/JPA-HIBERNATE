package basic.test.onetoone;

import basic.model.onetoone.Client;
import basic.model.onetoone.Seat;
import dao.Dao;

public class NewClIentSeat1 {
    public static void main(String[] args) {
        Seat seat = new Seat("16C");
        Client client = new Client("Ana", seat);

        Dao<Object> dao = new Dao<>();

        dao.includeAtomic(client);
    }
}
