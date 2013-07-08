package monkeys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * MIT License
 *
 * @author abdiel
 */
@Entity
@Table(name = "bananas")
@Access(AccessType.FIELD)
public class Banana implements Serializable {
    private static final long serialVersionUID = 1L;

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Monkey peeler;

    @Basic(optional = false)
    private String description;

    public Banana() {
    }

    public Banana(Monkey peeler, String description) {
        this.peeler = peeler;
        this.description = description;
    }

    public Monkey getPeeler() {
        return peeler;
    }

    public void setPeeler(Monkey peeler) {
        this.peeler = peeler;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
