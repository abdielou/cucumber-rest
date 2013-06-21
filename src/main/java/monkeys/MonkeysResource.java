package monkeys;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * (C) Copyright 6/20/13 Hewlett-Packard Development Company, L.P.
 * Date: 6/20/13
 * Time: 10:22 AM
 *
 * @author abdiel
 */
@Path("/monkeys")
public class MonkeysResource {
    @Context
    UriInfo uri;

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_XML})
    public Monkey[] getAllMonkeys() {
        Monkey[] monkeys = new Monkey[1];
        monkeys[0] = new Monkey("1");
        return monkeys;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Monkey getById(@PathParam("id") String id){
        return new Monkey(id);
    }
}
