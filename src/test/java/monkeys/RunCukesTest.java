package monkeys;

/**
 * MIT License
 *
 * @author abdiel
 */
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"progress"}, glue = {"monkeys","cucumber.runtime.java.spring.hooks"})
public class RunCukesTest {
}
