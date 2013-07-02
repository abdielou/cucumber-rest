package monkeys;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * (C) Copyright 6/20/13 Hewlett-Packard Development Company, L.P.
 * Date: 6/20/13
 * Time: 10:24 AM
 *
 * @author abdiel
 */
@XmlRootElement
public class Monkey {
    public String action;
    public String id;
    public String name;

    public Monkey(String id){
        this.id = id;
        this.action = "chimp";
        this.name = "";
    }
}
