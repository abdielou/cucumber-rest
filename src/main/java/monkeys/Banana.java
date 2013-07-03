package monkeys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: abdiel
 * Date: 7/2/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "bananas")
@Access(AccessType.PROPERTY)
public class Banana implements Serializable {
    private static final long serialVersionUID = 1L;

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Monkey peeler;

    private String description;

    public Banana() {
    }

    public Banana(Monkey peeler, String description) {
        this.peeler = peeler;
        this.description = description;
    }

    @ManyToOne(optional = false)
    public Monkey getPeeler() {
        return peeler;
    }

    public void setPeeler(Monkey peeler) {
        this.peeler = peeler;
    }

    @Basic(optional = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
