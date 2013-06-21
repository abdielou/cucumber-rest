package monkeys;

/**
 * MIT License
 * Date: 6/19/13
 * Time: 5:09 PM
 *
 * @author abdiel
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.Assert.*;

public class StepDefs {

    private Monkey monkey;
    private URI uri;
    private WebResource webResource;
    private Monkey[] resultArray;
    private String id = "";
    private Response.Status status;
    private ClientResponse response;

    @Given("^I access the url \"([^\"]*)\"$")
    public void I_access_the_url(String uri) throws URISyntaxException {
        this.uri = new URI(uri);
    }


    @When("^I provide parameter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void I_provide_parameter_as(String param, String value) {
        System.out.println(param + "::" + value);
        if(param.equalsIgnoreCase("id"))
            this.id = value;
        else
            throw new IllegalArgumentException();
    }

    @When("^I retrieve the results$")
    public void I_retrieve_the_results() {
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(config);
        if (this.id.isEmpty() || this.id == null) {
            this.webResource = client.resource(this.uri);
            Class arrayClass = Array.newInstance(Monkey.class, 0).getClass();
            this.response = this.webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
            this.resultArray = (Monkey[])this.response.getEntity(arrayClass);
        }
        else{
            this.webResource = client.resource(this.uri).path(this.id);
            this.response = this.webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
            this.monkey = this.response.getEntity(Monkey.class);
        }

    }

    @Then("^the status code should be (\\d+)$")
    public void the_status_code_should_be(int code) {
        Response.Status requested = null;
        if(code == 200)
            requested = Response.Status.OK;
        assertEquals(requested, response.getResponseStatus());
    }

    @Then("^it should have the field \"([^\"]*)\" containing the value \"([^\"]*)\"$")
    public void it_should_have_the_field_containing_the_value(String field, String value) throws NoSuchFieldException, IllegalAccessException {
        assertNotNull(this.monkey.getClass().getField(field));
        assertTrue(((String) this.monkey.getClass().getField(field).get(this.monkey)).equalsIgnoreCase(value));
    }

    @Then("^it should have the field \"([^\"]*)\"$")
    public void it_should_have_the_field(String field) throws NoSuchFieldException {
        assertNotNull(this.monkey.getClass().getField(field));
    }

}
