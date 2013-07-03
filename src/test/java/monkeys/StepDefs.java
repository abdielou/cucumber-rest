package monkeys;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    private MonkeyRepository monkeyRepository;

    @Autowired
    private MockMvc mockMvc;

    private String basePath;
    private ResultActions mvcResult;
    private Long id;

    @Given("^There is a monkey with name \"([^\"]*)\"$")
    public void There_is_a_monkey_with_name(String name) throws Throwable {
        Monkey monkey = new Monkey(name);
        monkeyRepository.save(monkey);
    }

    @Given("^The monkey named \"([^\"]*)\" has (\\d+) bananas$")
    public void The_monkey_named_has_bananas(String name, int count) throws Throwable {
        List<Monkey> monkeys = monkeyRepository.findByName(name);
        List<Banana> bananas = new ArrayList<Banana>();
        bananas.add(new Banana(monkeys.get(0),"small")); // who cares?... just do the first
        bananas.add(new Banana(monkeys.get(0),"smaller"));
        monkeys.get(0).setBananas(bananas);
    }

    @Given("^I access the url \"([^\"]*)\"$")
    public void I_access_the_url(String path) throws Throwable {
        this.basePath = path;
    }

    @When("^I do a get all$")
    public void I_do_a_get_all() throws Throwable {
        mvcResult = this.mockMvc.perform(get("/monkeys").contentType(MediaType.APPLICATION_JSON));
    }

    @When("^I do a get$")
    public void I_do_a_get() throws Throwable {
        mvcResult = this.mockMvc.perform(get("/monkeys/{id}", this.id).contentType(MediaType.APPLICATION_JSON));
    }

    @Then("^the status code should be (\\d+)$")
    public void the_status_code_should_be(int code) throws Throwable {
        mvcResult.andExpect(status().is(code));
    }

    @Then("^there should be (\\d+) monkeys$")
    public void there_should_be_monkeys(int size) throws Throwable {
        mvcResult.andExpect(jsonPath("$", Matchers.hasSize(size)));
    }

    @Given("^I provide parameter \"([^\"]*)\" as (\\d+)$")
    public void I_provide_parameter_as(String name, Long value) throws Throwable {
        if(name.equalsIgnoreCase("id"))
            this.id = value;
        else
            throw new PendingException();
    }

    @Then("^it should have the field \"([^\"]*)\" containing the value \"([^\"]*)\"$")
    public void it_should_have_the_field_containing_the_value(String field, String value) throws Throwable {
        mvcResult.andExpect(jsonPath("$." + field, is(value)));
    }

    @Then("^it should have the field \"([^\"]*)\" containing the value (\\d+)$")
    public void it_should_have_the_field_containing_the_value(String field, int value) throws Throwable {
        mvcResult.andExpect(jsonPath("$." + field, is(value)));
    }

    @Then("^it should have the field \"([^\"]*)\"$")
    public void it_should_have_the_field(String field) throws Throwable {
        mvcResult.andExpect(jsonPath("$." + field).exists());
    }

    @When("^I delete the monkey$")
    public void I_delete_the_monkey() throws Throwable {
        mvcResult = mockMvc.perform(delete("/monkeys/{id}",this.id).contentType(MediaType.APPLICATION_JSON));
    }

}
