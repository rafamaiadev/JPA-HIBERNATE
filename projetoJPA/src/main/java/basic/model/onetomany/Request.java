package basic.model.onetomany;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Request() {
        this(new Date());
    }

    public Request(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
