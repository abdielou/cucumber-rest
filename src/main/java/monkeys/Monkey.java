package monkeys;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * MIT License
 *
 * @author abdiel
 */
@Entity
@Table(name = "monkeys")
@Access(AccessType.FIELD)
public class Monkey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Banana> bananas;

    @Basic(optional = true)
    private String action = "chimp";

    public Monkey() {
    }

    public Monkey(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Banana> getBananas() {
        return bananas;
    }

    public void setBananas(List<Banana> bananas) {
        this.bananas = bananas;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
