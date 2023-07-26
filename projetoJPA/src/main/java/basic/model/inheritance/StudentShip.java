package basic.model.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class StudentShip extends Student{
    private Double scholarValue;

    public StudentShip() {
    }


    public StudentShip(Long registration, String name, Double scholarValue) {
        super(registration, name);
        this.scholarValue = scholarValue;
    }

    public Double getScholarValue() {
        return scholarValue;
    }

    public void setScholarValue(Double scholarValue) {
        this.scholarValue = scholarValue;
    }
}
