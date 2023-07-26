package basic.test.inheritance;

import basic.model.inheritance.Student;
import basic.model.inheritance.StudentShip;
import dao.Dao;

public class NewStudent {
    public static void main(String[] args) {
        Dao<Student> dao = new Dao<>();

        Student student = new Student(1234L, "João");
        StudentShip studentShip = new StudentShip(12345L, "Maria", 1000.0);

        dao.openTransaction()
                .includeTransaction(student)
                .includeTransaction(studentShip)
                .closeTransaction();
    }
}
