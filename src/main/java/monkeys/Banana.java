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

    @Basic(optional = false)
    private String description;

    public Banana() {
    }

    public Banana(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
