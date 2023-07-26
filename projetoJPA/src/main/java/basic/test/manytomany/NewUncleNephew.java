package basic.test.manytomany;

import basic.model.manytomany.Nephew;
import basic.model.manytomany.Uncle;
import dao.Dao;

public class NewUncleNephew {
    public static void main(String[] args) {
        Uncle aunt1 = new Uncle("Maria");
        Uncle uncle2 = new Uncle("João");

        Nephew nephew1 = new Nephew("Junior");
        Nephew niece2 = new Nephew("Ana");

        aunt1.getNephews().add(nephew1);
        nephew1.getUncles().add(aunt1);

        aunt1.getNephews().add(niece2);
        niece2.getUncles().add(aunt1);

        uncle2.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle2);

        uncle2.getNephews().add(niece2);
        niece2.getUncles().add(uncle2);

        Dao<Object> dao = new Dao<>();

        dao.openTransaction()
                .includeTransaction(aunt1)
                .includeTransaction(uncle2)
                .includeTransaction(nephew1)
                .includeTransaction(niece2)
                .closeTransaction();
    }
}
