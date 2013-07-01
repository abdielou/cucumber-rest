package monkeys;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * MIT License
 * Date: 6/19/13
 * Time: 5:09 PM
 *
 * @author abdiel
 */
@WebAppConfiguration
@ContextConfiguration("classpath:cucumber.xml")
public class StepDefs {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private String path;
    private ResultActions mvcResult;

    @Given("^I access the url \"([^\"]*)\"$")
    public void I_access_the_url(String path) throws Throwable {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.path = path;
    }

    @When("^I retrieve the results$")
    public void I_retrieve_the_results() throws Throwable {
        mvcResult = this.mockMvc.perform(get(this.path).contentType(MediaType.APPLICATION_JSON));
    }

    @Then("^the status code should be (\\d+)$")
    public void the_status_code_should_be(int code) throws Throwable {
        mvcResult.andExpect(status().isOk());
    }

    @Then("^there should be more than (\\d+) monkeys$")
    public void there_should_be_more_than_monkeys(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I provide parameter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void I_provide_parameter_as(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^it should have the field \"([^\"]*)\" containing the value \"([^\"]*)\"$")
    public void it_should_have_the_field_containing_the_value(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^it should have the field \"([^\"]*)\"$")
    public void it_should_have_the_field(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
