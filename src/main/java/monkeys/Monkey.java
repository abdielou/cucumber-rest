package monkeys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * (C) Copyright 6/20/13 Hewlett-Packard Development Company, L.P.
 * Date: 6/20/13
 * Time: 10:24 AM
 *
 * @author abdiel
 */
@Entity
@Table(name = "monkeys")
@Access(AccessType.PROPERTY)
public class Monkey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private List<Banana> bananas;

    private String action = "chimp";

    public Monkey() {
    }

    public Monkey(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Basic(optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "peeler", fetch = FetchType.EAGER)
    public List<Banana> getBananas() {
        return bananas;
    }

    public void setBananas(List<Banana> bananas) {
        this.bananas = bananas;
    }

    @Basic(optional = true)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
